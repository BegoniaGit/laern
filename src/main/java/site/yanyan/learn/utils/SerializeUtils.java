package site.yanyan.learn.utils;


import java.io.*;

public class SerializeUtils {

    public static String serialize(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            String string = byteArrayOutputStream.toString("ISO_8859_1");
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return string;
        } catch (Exception e) {
        }
        return null;
    }

    public static Object deSerialize(String str) {
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes("ISO_8859_1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}