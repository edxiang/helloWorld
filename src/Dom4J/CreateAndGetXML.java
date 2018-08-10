package Dom4J;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Kevin.Z on 2017/8/4.
 * A class to test that how to handle .xml file by java program
 * to create .xml file and get content from .xml file by java program
 */
public class CreateAndGetXML {
    public static void main(String[] args) {
        //new CreateAndGetXML().create();
        //new CreateAndGetXML().get();
        new CreateAndGetXML().get();
    }

    /**
     * 生成xml文件
     */
    public void create(){
        // 创建根节点 root
        Element root = DocumentHelper.createElement("Person");
        Document document = DocumentHelper.createDocument(root);

        // addAttribute 是指创建节点内的属性
        // ：<Person university="SCAU" location="GuangZhou"> 其中university和location就是Person的属性。
        root.addAttribute("university","SCAU");
        root.addAttribute("location","GuangZhou");

        // 创建节点的方式。
        // 而整个的dom树其实就是这么延伸下去的：将root看成一个节点，节点再添加节点（套多个for循环）
        Element e1 = root.addElement("student");
        e1.addElement("name").addText("xiaoxiang");

        // 以这种方式添加节点的话，最后的内容是这样子的：<name/>xiangxiao
        // 有点类似 HTML 的 <input />标签。
        // 这么说，通过这种方式来添加节点的话，多数是以添加 attribute 为目的的
        Element e2 = root.addElement("student");
        e2.addElement("name");
        e2.addText("xiangxiao");

        // 比如像下面这样
        Element e3 = root.addElement("student");
        Element ei = e3.addElement("input");
        ei.addAttribute("type","text");
        ei.addAttribute("value","for test");

        // 下面这种添加节点的方式该是比较好理解的，
        Element e4 = root.addElement("student");
        Element ex = e4.addElement("name");
        ex.addText("hello world!");

        // 当然，也可以写下面这种一锅端的方式：
        Element DONT_USE = root.addElement("student");
        DONT_USE.addElement("DONT").addAttribute("att1","value1").addAttribute("att2","value2").addText("don't use!!!");

        OutputFormat format = new OutputFormat("    ",true);
        format.setEncoding("UTF8");
        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream("Person.xml"),format);
            writer.write(document);
            writer.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取节点的方式一
     * 这种方式虽然看起来简单，但另一个方法更常用些，对于我来说
     */
    public void get(){
        try {
            File xmlFile = new File("Person.xml");
            SAXReader saxReader = new SAXReader();

            Document document = saxReader.read(xmlFile);
            // 获取根节点
            Element Persons = document.getRootElement();

            // 获取根节点的直接子节点
            for(Iterator i = Persons.elementIterator();i.hasNext();){
                // <student>...</student>
                Element student = (Element)i.next();
                for(Iterator j = student.elementIterator();j.hasNext();){
                    // 子节点的直接子节点：<name>...</name>
                    Element node = (Element)j.next();
                    // 获取节点的名字与内容：name:xiaoxiang
                    System.out.print(node.getName()+" : "+ node.getTextTrim());
                }
                System.out.println();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取节点的方式二
     * 根据父节点直接获取所有的子节点，同时也能获取该节点的所有属性
     */
    public void anotherGet(){
        try {
            File xml = new File("Person.xml");
            SAXReader saxReader = new SAXReader();

            Document document = saxReader.read(xml);
            Element Person = document.getRootElement();

            // 获取节点 person 的所有属性
            // 以键值对的形式打印
            List attrList = Person.attributes();
            System.out.printf("this is attribute: \n");
            for (int i = 0; i < attrList.size(); i++) {
                Attribute item = (Attribute)attrList.get(i);
                System.out.println(item.getName()+ " : "+item.getValue());
            }

            // 获取节点 person 的所有子节点
            // 在这个具体的例子中，就是 <student>、<student>..
            List nodeList = Person.elements();
            System.out.printf("this is element: \n");
            for (int i = 0; i < nodeList.size(); i++) {
                Element student = (Element)nodeList.get(i);
                // 获取节点 node 的所有子节点
                List contentList = student.elements();
                for (int j = 0; j < contentList.size(); j++) {
                    Element contentNode = (Element)contentList.get(j);
                    System.out.println(contentNode.getName()+" : "+contentNode.getTextTrim());
                }
            }

            // 根据dom树的结构，决定循环的次数。
            // 一般是两层循环；当然也有可能更多，主要取决于一开始的设计。
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
