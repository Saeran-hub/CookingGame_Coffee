package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Config {
    String background;
    String img_bean1;
    String img_bean2;
    String img_bean3;
    String img_bean4;
    String img_coffee;
    String img_milk;
    String img_water;
    String img_oat;
    String img_bxg;
    String img_nn;
    String img_s;
    String img_ymn;
    String img_xc;
    String img_jg;
    String img_ckl;
    String img_ny;
    int background_sizex;
    int background_sizey;
    int back_sizex;
    int back_sizey;
    int back_locationx;
    int back_locationy;
    int button1_locationx;
    int button1_locationy;
    int button1_spacingx;
    int button1_spacingy;
    int button1_sizex;
    int button1_sizey;
    int button2_locationx;
    int button2_locationy;
    int button2_spacingy;
    int button2_sizex;
    int button2_sizey;
    int button3_locationx;
    int button3_locationy;
    int button3_spacingx;
    int button3_spacingy;
    int button3_sizex;
    int button3_sizey;
    int img1_locationx;
    int img1_locationy;
    int img1_sizex;
    int img1_sizey;
    int img2_locationx;
    int img2_locationy;
    int img2_sizex;
    int img2_sizey;
    int imgguest_locationx;
    int imgguest_locationy;
    int imgguest_sizex;
    int imgguest_sizey;
    int duihua_sizex;
    int duihua_sizey;
    int duihua_locationx;
    int duihua_locationy;
    int time_sizex;
    int time_sizey;
    int time_locationx;
    int time_locationy;
    int tboard_sizex;
    int tboard_sizey;
    int tboard_locationx;
    int tboard_loactiony;
    int tboard_spacingy;
    int button4_locationx;
    int button4_locationy;
    int next_locationx;
    int next_locationy;
    Config(){
        BufferedReader reader;
        String configfile1="config1";
        String configfile2="config2";
        ArrayList<String> config1 = new ArrayList<String>();
        ArrayList <String> config2 =new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(configfile1));
            String line = reader.readLine();
            config1.add(line);
            while (line != null) {
                // read next line
                line = reader.readLine();
                config1.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        background=config1.get(0);
        img_bean1=config1.get(1);
        img_bean2=config1.get(2);
        img_bean3=config1.get(3);
        img_bean4=config1.get(4);
        img_coffee=config1.get(5);
        img_milk=config1.get(6);
        img_water=config1.get(7);
        img_oat=config1.get(8);
        img_bxg=config1.get(9);
        img_nn=config1.get(10);
        img_s=config1.get(11);
        img_ymn=config1.get(12);
        img_xc=config1.get(13);
        img_jg=config1.get(14);
        img_ckl=config1.get(15);
        img_ny=config1.get(16);
        try {
            reader = new BufferedReader(new FileReader(configfile2));
            String line = reader.readLine();
            config2.add(line);
            while (line != null) {
                line = reader.readLine();
                config2.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        background_sizex=Integer.valueOf(config2.get(0));
        background_sizey=Integer.valueOf(config2.get(1));
        back_sizex=Integer.valueOf(config2.get(2));
        back_sizey=Integer.valueOf(config2.get(3));
        back_locationx=Integer.valueOf(config2.get(4));
        back_locationy=Integer.valueOf(config2.get(5));
        button1_locationx=Integer.valueOf(config2.get(6));
        button1_locationy=Integer.valueOf(config2.get(7));
        button1_spacingx=Integer.valueOf(config2.get(8));
        button1_spacingy=Integer.valueOf(config2.get(9));
        button1_sizex=Integer.valueOf(config2.get(10));
        button1_sizey=Integer.valueOf(config2.get(11));
        button2_locationx=Integer.valueOf(config2.get(12));
        button2_locationy=Integer.valueOf(config2.get(13));
        button2_spacingy=Integer.valueOf(config2.get(14));
        button2_sizex=Integer.valueOf(config2.get(15));
        button2_sizey=Integer.valueOf(config2.get(16));
        button3_locationx=Integer.valueOf(config2.get(17));
        button3_locationy=Integer.valueOf(config2.get(18));
        button3_spacingx=Integer.valueOf(config2.get(19));
        button3_spacingy=Integer.valueOf(config2.get(20));
        button3_sizex=Integer.valueOf(config2.get(21));
        button3_sizey=Integer.valueOf(config2.get(22));
        img1_locationx=Integer.valueOf(config2.get(23));
        img1_locationy=Integer.valueOf(config2.get(24));
        img1_sizex=Integer.valueOf(config2.get(25));
        img1_sizey=Integer.valueOf(config2.get(26));
        img2_locationx=Integer.valueOf(config2.get(27));
        img2_locationy=Integer.valueOf(config2.get(28));
        img2_sizex=Integer.valueOf(config2.get(29));
        img2_sizey=Integer.valueOf(config2.get(30));
        imgguest_locationx=Integer.valueOf(config2.get(31));
        imgguest_locationy=Integer.valueOf(config2.get(32));
        imgguest_sizex=Integer.valueOf(config2.get(33));
        imgguest_sizey=Integer.valueOf(config2.get(34));
        duihua_sizex=Integer.valueOf(config2.get(35));
        duihua_sizey=Integer.valueOf(config2.get(36));
        duihua_locationx=Integer.valueOf(config2.get(37));
        duihua_locationy=Integer.valueOf(config2.get(38));
        time_sizex=Integer.valueOf(config2.get(39));
        time_sizey=Integer.valueOf(config2.get(40));
        time_locationx=Integer.valueOf(config2.get(41));
        time_locationy=Integer.valueOf(config2.get(42));
        tboard_sizex=Integer.valueOf(config2.get(43));
        tboard_sizey=Integer.valueOf(config2.get(44));
        tboard_locationx=Integer.valueOf(config2.get(45));
        tboard_loactiony=Integer.valueOf(config2.get(46));
        tboard_spacingy=Integer.valueOf(config2.get(47));
        button4_locationx=Integer.valueOf(config2.get(48));
        button4_locationy=Integer.valueOf(config2.get(49));
        next_locationx=Integer.valueOf(config2.get(50));
        next_locationy=Integer.valueOf(config2.get(51));
    }
}
