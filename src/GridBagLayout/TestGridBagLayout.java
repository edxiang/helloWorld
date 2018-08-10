package GridBagLayout;

import com.tietoenator.trip.jxp.internal.http.Grid;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kevin.Z on 2017/9/26.
 */
public class TestGridBagLayout {

    public TestGridBagLayout(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JButton btn1 = new JButton("Button 1");
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.weightx = 0.2;
        c1.gridx = 0;
        c1.gridy = 0;
        panel.add(btn1,c1);

        JButton btn2 = new JButton("Button 2");
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.weightx = 0.2;
        c2.gridx = 1;
        c2.gridy = 0;
        panel.add(btn2);

        JButton btn3 = new JButton("Button 3");
        GridBagConstraints c3 = new GridBagConstraints();
        c3.fill = GridBagConstraints.HORIZONTAL;
        c3.weightx = 0.2;
        c3.gridx = 2;
        c3.gridy = 0;
        panel.add(btn3,c3);

        JButton btnx = new JButton("Button x");
        GridBagConstraints cx = new GridBagConstraints();
        cx.fill = GridBagConstraints.HORIZONTAL;
        c3.weightx = 0.5;
        cx.gridx = 3;
        cx.gridy = 0;
        panel.add(btnx,cx);

        JButton btn4 = new JButton("Long-Name Button 4");
        GridBagConstraints c4 = new GridBagConstraints();
        c4.fill = GridBagConstraints.HORIZONTAL;
        c4.ipady = 40;
        c4.weightx = 0.0;
        c4.gridwidth = 3;
        c4.gridx = 0;
        c4.gridy = 1;
        panel.add(btn4,c4);

        JButton btn5 = new JButton("5");
        GridBagConstraints c5 = new GridBagConstraints();
        c5.fill = GridBagConstraints.HORIZONTAL;
        c5.ipady = 0;
        c5.weighty = 1.0;
        c5.anchor = GridBagConstraints.PAGE_END;
        c5.insets = new Insets(10,0,0,0);
        c5.gridx = 1;
        c5.gridwidth = 4;
        c5.gridy = 2;
        panel.add(btn5,c5);

        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //frame.setSize(200,200);
        frame.pack();
    }



    public static void main(String[] args) {
        new TestGridBagLayout();
    }
}
