package com.ext.generate;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

public class Demo {
    public Properties prop;
    public Demo(){
        prop = new Properties();
        try {
            //load a properties file from class path, inside static method
            prop.load(ExtensionGenerator.class.getClassLoader().getResourceAsStream("config.properties"));

            //get the property value and print it out
            System.out.println(prop.getProperty("data.location"));
//            System.out.println(prop.getProperty("data.encoding"));
//            System.out.println(prop.getProperty("data.encryption.algorithm"));
//            System.out.println(prop.getProperty("data.encryption.salt"));
//            System.out.println(prop.getProperty("data.encryption.key"));

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void writeFileWithEncoding(Charset encoding){
        try {
            File fileDir = new File(prop.getProperty("data.location")+"test.txt");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), encoding));

            out.append("कইতদকগভক ন্যফভগিয়হফ ইয়িয়ফ্যফইয় f ভুল্গ ইউয়গভলুয়ভ্লিউয়ফগ ").append("\r\n");
            out.append("你好，世界").append("\r\n");

            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void readFileWithEncoding(Charset encoding){
        try {
            File fileDir = new File(this.prop.getProperty("data.location")+"test.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), encoding));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
