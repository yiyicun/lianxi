package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileNIO {

    public static void main(String[] args) throws IOException {
        File file = new File("J:\\Desktop\\1.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        int readNum = channel.read(buffer);
        buffer.flip();
        byte[] b = buffer.array();
        for (byte b1 : b) {
            System.out.print((char)b1);
        }
    }
}
