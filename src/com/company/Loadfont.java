package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

class Loadfont
{
    public static Font loadFont(String fontFileName, float fontSize)  //第一个参数是外部字体名，第二个是字体大小
    {
        try
        {
            File file = new File(fontFileName);
            FileInputStream aixing = new FileInputStream(file);
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, aixing);
            Font dynamicFontPt = dynamicFont.deriveFont(fontSize);

            aixing.close();
            return dynamicFontPt;
        }
        catch(Exception e)//异常处理
        {
            e.printStackTrace();
            return new Font("宋体", Font.PLAIN, 12);
        }
    }
    public static Font Font(){
        String root="d:";//项目根目录路径
        System.out.println(root);
        Font font = Loadfont.loadFont(root+"\\方正像素12.TTF", 12f);//调用
        return font;//返回字体
    }
}