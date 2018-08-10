package NIO;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Kevin.Z on 2018/3/26.
 */
public class Nio {

    public static void main(String[] args) {
        channel();
    }

    static void channel() {
        try {
            File newFile = new File("hw.txt");
            RandomAccessFile file = new RandomAccessFile(newFile, "rw");
            FileChannel inChannel = file.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(32);
            int length = -1;
            byte[] bytes = new byte[(int) inChannel.size()];
            int index = 0;

            while ((length = inChannel.read(buf)) != -1) {
                System.out.println("Read: " + length);
                buf.flip();
                while (buf.hasRemaining()) {
                    bytes[index] = buf.get();
                    index++;
                }
                buf.clear();
            }
            file.close();
            System.out.println(index);
            System.out.println(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
