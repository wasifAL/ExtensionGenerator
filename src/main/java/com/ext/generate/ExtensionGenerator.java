package com.ext.generate;

import java.nio.charset.Charset;

public class ExtensionGenerator {


    public static void main(String[] args){

        Demo demo = new Demo();
        demo.writeFileWithEncoding(Charset.forName(demo.prop.getProperty("data.encoding")));
        demo.readFileWithEncoding(Charset.forName(demo.prop.getProperty("data.encoding")));
    }


}
