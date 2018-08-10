package TestTrip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Kevin.Z on 2017/8/10.
 *
 * Trip的服务器又不能用了……192.168.88.55
 */
public class Main {
    private JFrame frame = new JFrame();
    private JPanel panel;
    private JLabel label;
    private JTextField textField;
    private JButton btnChoose;
    private JButton btnUpload;
    private JButton btnDownload;
    private JButton btnList;

    public Main() {
        panel = new JPanel();
        label = new JLabel("chose file path");
        textField = new JTextField(30);
        btnChoose = new JButton("choose");
        btnUpload = new JButton("upload");
        btnDownload = new JButton("download");
        btnList = new JButton("list file");

        panel.add(label);
        panel.add(textField);
        panel.add(btnChoose);
        panel.add(btnUpload);
        panel.add(btnDownload);
        panel.add(btnList);

        btnChoose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getFilePath();
            }
        });

        btnUpload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uploadFile();
            }
        });

        btnDownload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                downloadFile();
            }
        });

        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

    }

    public void getFilePath() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.showDialog(new JLabel(), "choose");
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            textField.setText(file.getAbsolutePath());
        }
    }

    public void uploadFile() {
        String path = textField.getText();
        int begin = path.lastIndexOf("\\");
        String fileName = path.substring(begin + 1, path.length());
        //留着，有用
        if ("" != path) {

        }
    }

    public void downloadFile() {
        TripService.getFields();
    }

    public static void main(String[] args) {
        new Main();
    }
}
