package TestGridBagLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kevin.Z on 2017/9/28.
 */
public class Main {
    private JButton btn = null;

    public Main() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridBagLayout());

        JPanel p1 = new JPanel();
        p1.add(new JLabel("label1"));
        p1.add(new JLabel("label2"));

        btn = new JButton("button 1");
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.gridx = 0;
        c1.insets = new Insets(5,5,5,5);
        c1.gridy = 0;
        c1.weightx = 1.0;
        panel.add(p1, c1);

        btn = new JButton("Button 2");
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.weightx = 0.5;
        /*c2.gridx = 1;
        c2.gridy = 0;*/
        panel.add(new JLabel("Button 2"),c2);

        btn = new JButton("Button 3");
        GridBagConstraints c3 = new GridBagConstraints();
        c3.fill = GridBagConstraints.HORIZONTAL;
        c3.weightx = 0.5;
        /*c3.gridx = 2;
        c3.gridy = 0;*/
        panel.add(new JLabel("Button 3"),c3);

        btn = new JButton("btn x");
        //c3.gridx = 3;
        /*c3.gridwidth = 2;
        c3.gridheight = 2;*/
        panel.add(btn,c3);

        btn = new JButton("Long-Name Button 4");
        GridBagConstraints c4 = new GridBagConstraints();
        c4.fill = GridBagConstraints.BOTH;
        c4.weighty = 1.0;
        c4.ipady = 40;
        c4.weightx = 0.0;
        c4.gridwidth = 3;
        /*c4.gridx = 0;
        c4.gridy = 1;*/
        panel.add(btn,c4);

        btn = new JButton("BUtton 5");
        GridBagConstraints c5 = new GridBagConstraints();
        c5.fill = GridBagConstraints.HORIZONTAL;
        c5.weighty = 1.0;
        c5.anchor = GridBagConstraints.PAGE_END;
        c5.insets = new Insets(10,0,0,0);
        c5.gridy = 2;
        c5.gridx = 1;
        c5.gridwidth = 2;
        panel.add(btn,c5);

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new Main();
    }
}
