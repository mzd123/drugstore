package com.mzd.drugstore.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
//ceshi
public class Redis4Imgs {
    public static String readImage(String type) {
        File file2 = new File("C:\\Users\\acer\\Desktop\\商城\\表结构.png");
        try {
            BufferedImage img = ImageIO.read(file2);
            String imagestr;
            imagestr = encodeToString(img, type);
            System.out.println(imagestr);
            return imagestr;
        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return null;
    }

    public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    /**
     * 解码
     *
     * @param imageString
     * @return
     */
    public static byte[] decodeToImage(String imageString) {
        byte[] imageByte = new byte[]{};
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            return imageByte;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageByte;
    }

    public static void main(String[] args) {
        String s = readImage("png");
        byte[] bytes = decodeToImage(s);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\acer\\Desktop\\商城\\测试.png"));
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
