package io;

import File.IOUtils;

import java.io.File;

/**
 * Created by Kevin.Z on 2018/4/8.
 */
public class IOUtility {
    public static void main(String[] args) {
        File f = new File("hw.txt");
        byte[] bs = IOUtils.getBytes(f);
        String s = new String(bs);
        System.out.println(s);
    }
}
