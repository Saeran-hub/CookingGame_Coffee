package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

class Frame3 extends JFrame implements WindowListener
{
    Config config;
    JButton fb2 = new JButton("提示");
    JButton bean_light=new JButton("轻烘培");
    JButton bean_city=new JButton("中浅烘培");
    JButton bean_medium=new JButton("中烘培");
    JButton bean_dark=new JButton("重烘培");
    JButton second_coffee=new JButton("咖啡");
    JButton second_milk=new JButton("牛奶");
    JButton second_water=new JButton("水");
    JButton second_oat=new JButton("燕麦奶");
    JButton third_passion=new JButton();
    JButton third_milk=new JButton();
    JButton third_water=new JButton();
    JButton third_oat=new JButton();
    JButton third_vanilla=new JButton();
    JButton third_nut=new JButton();
    JButton third_chocolate=new JButton();
    JButton third_cream=new JButton();
    JButton jnext=new JButton("完成");
    JButton jreset=new JButton("重做");
    JButton add_ice=new JButton("加冰");
    JButton add_hot=new JButton("加热");
    JButton jnextguest=new JButton("next");
    ExTimer timer;
    JLabel background;
    JLabel jl;
    JLabel ts;
    JLabel second_pic;
    JLabel guke;
    JTextField duihua;
    JTextField tasteboard1;
    JTextField tasteboard2;
    JTextField tasteboard3;
    JTextField tasteboard4;
    JTextField tasteboard5;
    JTextField time;
    GameObject gameobject;
    int tishi=0;
    //int dayang=0;
    Frame1 f;
    Frame3 f2;
    //Guest guest;
    Timer display_timer;

    class Tsk extends TimerTask {
        public void run(){
            long tm=timer.delay/1000-((System.currentTimeMillis() - timer.startTime)/1000);
            System.out.println(tm);
            if(tm<=0){
                time.setText("已打烊");
            }
            else {
                time.setText("距打烊还有" + Long.toString(tm));
            }
        }
    }
    private class btListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equals("提示"))
            {
                tishi++;
                if(tishi%2==1){

                    ts.setIcon(new ImageIcon("gamepics/ts.png"));
                }
                else{
                    ts.setIcon(new ImageIcon("null.png"));
                }
            }

        }
    }
    void set_guest(){
        ImageIcon img=new ImageIcon(gameobject.guestphoto);
        guke.setIcon(img);
    }
    void update_tasteboard(){
        tasteboard1.setText("苦：  "+gameobject.drink.ku);
        tasteboard2.setText("酸：  "+gameobject.drink.suan);
        tasteboard3.setText("甜：  "+gameobject.drink.tian);
        tasteboard4.setText("清凉：  "+gameobject.drink.ice);
        tasteboard5.setText("温暖：  "+gameobject.drink.hot);
    }
    Frame3(Frame1 ff)
    {
        this.setLayout(null);//绘制界面
        config=new Config();
        //生成命令执行器
        Broker broker =new Broker();
        //生成
        gameobject =GameObject.getInstance();
        AddHot addhot=new AddHot();
        AddIce addice=new AddIce();
        Compare compare=new Compare();
        CreateGuest createguest=new CreateGuest();
        PaintGuest paintguest=new PaintGuest();
        Reset reset=new Reset();
        UpdateDrink updatedrink=new UpdateDrink();
        UpdateScore updatescore=new UpdateScore();
        ReadStory readstory=new ReadStory();

        f2=this;
        //导入字体
        Font font = Loadfont.loadFont("../../../方正像素12.TTF", 26f);
        this.setBackground(Color.BLACK);
        this.f=ff;
        this.setSize(config.background_sizex,config.background_sizey);
        this.setLocationRelativeTo(null);
        this.setTitle("CoffeeGame:剧情模式");
        //设置背景
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon(config.background);
        background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        //
        fb2.setSize(config.back_sizex,config.back_sizey);
        fb2.setLocation(config.back_locationx,config.back_locationy);
        fb2.setFont(font.deriveFont(Font.BOLD));
        fb2.setForeground(Color.orange);
        fb2.setBackground(Color.black);
        this.add(fb2);
        fb2.addActionListener(new Frame3.btListener());
        //咖啡豆（第一层）图片
        jl=new JLabel();
        jl.setSize(config.img1_sizex,config.img1_sizey);
        jl.setIcon(new ImageIcon("null.jpg"));
        jl.setLocation(config.img1_locationx,config.img1_locationy);
        f2.add(jl);
        ts=new JLabel();
        ts.setSize(300,125);
        ts.setLocation(500,300);
        f2.add(ts);
        //第二层图片
        second_pic=new JLabel();
        second_pic.setSize(config.img2_sizex,config.img2_sizey);
        second_pic.setIcon(new ImageIcon("null.jpg"));
        second_pic.setLocation(config.img2_locationx,config.img2_locationy);
        f2.add(second_pic);
        //第三层
        third_passion.setIcon(new ImageIcon(config.img_bxg));
        third_milk.setIcon(new ImageIcon(config.img_nn));
        third_water.setIcon(new ImageIcon(config.img_s));
        third_oat.setIcon(new ImageIcon(config.img_ymn));
        third_vanilla.setIcon(new ImageIcon(config.img_xc));
        third_nut.setIcon(new ImageIcon(config.img_jg));
        third_chocolate.setIcon(new ImageIcon(config.img_ckl));
        third_cream.setIcon(new ImageIcon(config.img_ny));
        //顾客图片
        guke=new JLabel();
        guke.setSize(config.imgguest_sizex,config.imgguest_sizey);
        guke.setLocation(config.imgguest_locationx,config.imgguest_locationy);
        f2.add(guke);
        //对话框位置与字体颜色
        duihua=new JTextField();
        duihua.setSize(config.duihua_sizex,config.duihua_sizey);
        duihua.setLocation(config.duihua_locationx,config.duihua_locationy);
        duihua.setOpaque(false);
        duihua.setBorder(BorderFactory.createEmptyBorder());
        duihua.setFont(font.deriveFont(Font.BOLD));
        duihua.setForeground(Color.white);
        f2.add(duihua);
        //计时器位置
        time=new JTextField();
        time.setSize(config.time_sizex,config.time_sizey);
        time.setLocation(config.time_locationx,config.time_locationy);
        time.setForeground(Color.YELLOW);
        font.deriveFont(Font.BOLD);
        time.setFont(font);
        time.setBackground(Color.black);
        time.setOpaque(false);
        time.setBorder(BorderFactory.createEmptyBorder());
        time.setText("第"+gameobject.day.daynum+"天");
        f2.add(time);
        //设置按钮底色
        third_passion.setBackground(Color.BLACK);
        third_milk.setBackground(Color.BLACK);
        third_water.setBackground(Color.BLACK);
        third_oat.setBackground(Color.BLACK);
        third_vanilla.setBackground(Color.BLACK);
        third_nut.setBackground(Color.BLACK);
        third_chocolate.setBackground(Color.BLACK);
        third_cream.setBackground(Color.BLACK);

        tasteboard1=new JTextField();
        tasteboard1.setSize(config.tboard_sizex,config.tboard_sizey);
        tasteboard1.setLocation(config.tboard_locationx,config.tboard_loactiony);
        tasteboard1.setBackground(Color.cyan);
        tasteboard1.setFont(new Font("汉仪综艺体简", Font.BOLD, 20));
        tasteboard1.setBorder(BorderFactory.createEmptyBorder());
        f2.add(tasteboard1);
        tasteboard2=new JTextField();
        tasteboard2.setSize(config.tboard_sizex,config.tboard_sizey);
        tasteboard2.setLocation(config.tboard_locationx,config.tboard_loactiony+config.tboard_sizey+config.tboard_spacingy);
        tasteboard2.setBackground(Color.cyan);
        tasteboard2.setFont(new Font("汉仪综艺体简", Font.BOLD, 20));
        tasteboard2.setBorder(BorderFactory.createEmptyBorder());
        f2.add(tasteboard2);
        tasteboard3=new JTextField();
        tasteboard3.setSize(config.tboard_sizex,config.tboard_sizey);
        tasteboard3.setLocation(config.tboard_locationx,config.tboard_loactiony+(config.tboard_sizey+config.tboard_spacingy)*2);
        tasteboard3.setBackground(Color.cyan);
        tasteboard3.setFont(new Font("汉仪综艺体简", Font.BOLD, 20));
        tasteboard3.setBorder(BorderFactory.createEmptyBorder());
        f2.add(tasteboard3);
        tasteboard4=new JTextField();
        tasteboard4.setSize(config.tboard_sizex,config.tboard_sizey);
        tasteboard4.setLocation(config.tboard_locationx,config.tboard_loactiony+(config.tboard_sizey+config.tboard_spacingy)*3);
        tasteboard4.setBackground(Color.cyan);
        tasteboard4.setFont(new Font("汉仪综艺体简", Font.BOLD, 20));
        tasteboard4.setBorder(BorderFactory.createEmptyBorder());
        f2.add(tasteboard4);
        tasteboard5=new JTextField();
        tasteboard5.setSize(config.tboard_sizex,config.tboard_sizey);
        tasteboard5.setLocation(config.tboard_locationx,config.tboard_loactiony+(config.tboard_sizey+config.tboard_spacingy)*4);
        tasteboard5.setBackground(Color.cyan);
        tasteboard5.setFont(new Font("汉仪综艺体简", Font.BOLD, 20));
        tasteboard5.setBorder(BorderFactory.createEmptyBorder());
        f2.add(tasteboard5);

        //轻度烘培按钮
        bean_light.setSize(config.button1_sizex,config.button1_sizey);
        bean_light.setLocation(config.button1_locationx,config.button1_locationy);
        bean_light.setBackground(Color.BLACK);
        bean_light.setBorder(BorderFactory.createEmptyBorder());
        bean_light.setFont(font.deriveFont((float) 20.0).deriveFont(Font.BOLD));
        bean_light.setForeground(Color.green);
        this.add(bean_light);
        //bean_light.addActionListener(new Frame2.btListener());
        bean_light.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置jl的图片
                jl.setIcon(new ImageIcon(config.img_bean1));
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,1,1);
                update_tasteboard();
            }
        });
        //中轻度烘培按钮
        bean_city.setSize(config.button1_sizex,config.button1_sizey);
        bean_city.setLocation(config.button1_locationx+config.button1_spacingx+config.button1_sizex,config.button1_locationy);
        bean_city.setBackground(Color.BLACK);
        bean_city.setBorder(BorderFactory.createEmptyBorder());
        bean_city.setFont(font.deriveFont((float) 20.0).deriveFont(Font.BOLD));
        bean_city.setForeground(Color.green);
        this.add(bean_city);
        bean_city.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl.setIcon(new ImageIcon(config.img_bean2));
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,1,2);
                update_tasteboard();

            }
        });
        //中度烘培按钮
        bean_medium.setSize(config.button1_sizex,config.button1_sizey);
        bean_medium.setLocation(config.button1_locationx,config.button1_locationy+config.button1_spacingy+config.button1_sizey);
        bean_medium.setBackground(Color.BLACK);
        bean_medium.setBorder(BorderFactory.createEmptyBorder());
        bean_medium.setFont(font.deriveFont((float) 20.0).deriveFont(Font.BOLD));
        bean_medium.setForeground(Color.green);
        this.add(bean_medium);
        bean_medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置jl的图片
                jl.setIcon(new ImageIcon(config.img_bean3));
                //drink.add_basic(3);
                //score.getscore(drink,1);
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,1,3);
                update_tasteboard();

            }
        });
        //重度烘培按钮
        bean_dark.setSize(config.button1_sizex,config.button1_sizey);
        bean_dark.setLocation(config.button1_locationx+config.button1_spacingx+config.button1_sizex,config.button1_locationy+config.button1_spacingy+config.button1_sizey);
        bean_dark.setBackground(Color.BLACK);
        bean_dark.setBorder(BorderFactory.createEmptyBorder());
        bean_dark.setFont(font.deriveFont((float) 20.0).deriveFont(Font.BOLD));
        bean_dark.setForeground(Color.green);
        this.add(bean_dark);
        bean_dark.addActionListener(new Frame3.btListener());
        bean_dark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置jl的图片
                jl.setIcon(new ImageIcon(config.img_bean4));
                //drink.add_basic(4);
                //score.getscore(drink,1);
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,1,4);
                update_tasteboard();
            }
        });
        //
        //辅料按钮
        //
        //咖啡加量按钮
        second_coffee.setSize(config.button2_sizex,config.button2_sizey);
        second_coffee.setLocation(config.button2_locationx,config.button2_locationy);
        second_coffee.setFont(font.deriveFont((float) 20.0).deriveFont(Font.BOLD));
        second_coffee.setBackground(Color.black);
        second_coffee.setForeground(Color.PINK);
        this.add(second_coffee);
        second_coffee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second_pic.setIcon(new ImageIcon(config.img_coffee));
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,2,5);
                update_tasteboard();
            }
        });
        //牛奶按钮
        second_milk.setSize(config.button2_sizex,config.button2_sizey);
        second_milk.setLocation(config.button2_locationx,config.button2_locationy+config.button2_sizey+config.button2_spacingy);
        second_milk.setFont(font.deriveFont((float) 20.0).deriveFont(Font.BOLD));
        second_milk.setBackground(Color.black);
        second_milk.setForeground(Color.PINK);
        this.add(second_milk);
        second_milk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second_pic.setIcon(new ImageIcon(config.img_milk));
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,2,6);
                update_tasteboard();
            }
        });
        //水按钮
        second_water.setSize(config.button2_sizex,config.button2_sizey);
        second_water.setLocation(config.button2_locationx,config.button2_locationy+(config.button2_sizey+config.button2_spacingy)*2);
        this.add(second_water);
        second_water.setFont(font.deriveFont((float) 20.0).deriveFont(Font.BOLD));
        second_water.setBackground(Color.black);
        second_water.setForeground(Color.PINK);
        second_water.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second_pic.setIcon(new ImageIcon(config.img_water));
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,2,7);
                update_tasteboard();
            }
        });
        //燕麦按钮
        second_oat.setSize(config.button2_sizex,config.button2_sizey);
        second_oat.setLocation(config.button2_locationx,config.button2_locationy+(config.button2_sizey+config.button2_spacingy)*3);
        second_oat.setFont(font.deriveFont((float) 20.0).deriveFont(Font.BOLD));
        second_oat.setBackground(Color.black);
        second_oat.setForeground(Color.PINK);
        this.add(second_oat);
        //second_oat.addActionListener(new Frame2.btListener());
        second_oat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置jl的图片
                second_pic.setIcon(new ImageIcon(config.img_oat));
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,2,8);
                update_tasteboard();
            }
        });
        //百香果按钮
        third_passion.setSize(config.button3_sizex,config.button3_sizey);
        third_passion.setLocation(config.button3_locationx,config.button3_locationy);
        third_passion.setBorder(BorderFactory.createEmptyBorder());
        this.add(third_passion);
        //bean_light.addActionListener(new Frame2.btListener());
        third_passion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,3,9);
                update_tasteboard();
            }
        });
        //牛奶加量按钮
        third_milk.setSize(config.button3_sizex,config.button3_sizey);
        third_milk.setLocation(config.button3_locationx+config.button3_spacingx+config.button3_sizey,config.button3_locationy);
        third_milk.setBorder(BorderFactory.createEmptyBorder());
        this.add(third_milk);
        //bean_light.addActionListener(new Frame2.btListener());
        third_milk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,3,10);
                update_tasteboard();
            }
        });
        //水加量按钮
        third_water.setSize(config.button3_sizex,config.button3_sizey);
        third_water.setLocation(config.button3_locationx+(config.button3_spacingx+config.button3_sizey)*2,config.button3_locationy);
        third_water.setBorder(BorderFactory.createEmptyBorder());
        this.add(third_water);
        third_water.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,3,11);
                update_tasteboard();
            }
        });
        //燕麦奶加量按钮
        third_oat.setSize(config.button3_sizex,config.button3_sizey);
        third_oat.setLocation(config.button3_locationx+(config.button3_spacingx+config.button3_sizey)*3,config.button3_locationy);
        third_oat.setBorder(BorderFactory.createEmptyBorder());
        this.add(third_oat);
        third_oat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,3,12);
                update_tasteboard();
            }
        });
        //香草按钮
        third_vanilla.setSize(config.button3_sizex,config.button3_sizey);
        third_vanilla.setLocation(config.button3_locationx,config.button3_locationy+config.button3_sizey+config.button3_spacingy);
        third_vanilla.setBorder(BorderFactory.createEmptyBorder());
        this.add(third_vanilla);
        //bean_light.addActionListener(new Frame2.btListener());
        third_vanilla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,3,13);
                update_tasteboard();
            }
        });
        //坚果加量按钮
        third_nut.setSize(config.button3_sizex,config.button3_sizey);
        third_nut.setLocation(config.button3_locationx+config.button3_sizex+config.button3_spacingx,config.button3_locationy+config.button3_sizey+config.button3_spacingy);
        third_nut.setBorder(BorderFactory.createEmptyBorder());
        this.add(third_nut);
        third_nut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,3,14);
                update_tasteboard();
            }
        });
        //巧克力加量按钮
        third_chocolate.setSize(config.button3_sizex,config.button3_sizey);
        third_chocolate.setLocation(config.button3_locationx+(config.button3_sizex+config.button3_spacingx)*2,config.button3_locationy+config.button3_sizey+config.button3_spacingy);
        third_chocolate.setBorder(BorderFactory.createEmptyBorder());
        this.add(third_chocolate);
        third_chocolate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,3,15);
                update_tasteboard();
            }
        });
        //奶油加量按钮
        third_cream.setSize(config.button3_sizex,config.button3_sizey);
        third_cream.setLocation(config.button3_locationx+(config.button3_sizex+config.button3_spacingx)*3,config.button3_locationy+config.button3_sizey+config.button3_spacingy);
        third_cream.setBorder(BorderFactory.createEmptyBorder());
        this.add(third_cream);
        third_cream.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                broker.takeCommand(updatedrink);
                broker.takeCommand(updatescore);
                broker.placeCommand(gameobject,3,16);
                update_tasteboard();
            }
        });
        jnext.setSize(config.button1_sizex,config.button1_sizey);
        jnext.setBackground(Color.GREEN);
        jnext.setFont(font.deriveFont((float) 20.0).deriveFont(Font.BOLD));
        jnext.setLocation(config.button4_locationx,config.button4_locationy);
        this.add(jnext);
        jnext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        broker.takeCommand(compare);
                        broker.placeCommand(gameobject,0,0);
                        if (broker.result >= 1) {
                            duihua.setText("");
                            guke.setIcon(new ImageIcon("null.jpg"));
                            gameobject.stat=0;
                        }
            }
        });
        jreset.setSize(config.button1_sizex,config.button1_sizey);
        jreset.setBackground(Color.RED);
        jreset.setFont(font.deriveFont((float) 20.0).deriveFont(Font.BOLD));
        jreset.setLocation(config.button4_locationx,config.button4_locationy-config.button1_sizey-config.button1_spacingy);
        this.add(jreset);
        jreset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                broker.takeCommand(reset);
                broker.placeCommand(gameobject,0,0);
                update_tasteboard();
            }
        });
        add_ice.setSize(config.button1_sizex,config.button1_sizey);
        add_ice.setBackground(Color.CYAN);
        add_ice.setFont(font.deriveFont((float) 20.0).deriveFont(Font.BOLD));
        add_ice.setLocation(config.button4_locationx-config.button1_sizex-config.button1_spacingx,config.button4_locationy);
        this.add(add_ice);
        //bean_light.addActionListener(new Frame2.btListener());
        add_ice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                broker.takeCommand(addice);
                broker.placeCommand(gameobject,0,0);
                update_tasteboard();
            }
        });
        add_hot.setSize(config.button1_sizex,config.button1_sizey);
        add_hot.setBackground(Color.orange);
        add_hot.setFont(font.deriveFont((float) 20.0).deriveFont(Font.BOLD));
        add_hot.setLocation(config.button4_locationx-config.button1_sizex-config.button1_spacingx,config.button4_locationy-config.button1_sizey-config.button1_spacingy);
        this.add(add_hot);
        //bean_light.addActionListener(new Frame2.btListener());
        add_hot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                broker.takeCommand(addhot);
                broker.placeCommand(gameobject,0,0);
                update_tasteboard();
            }
        });
        jnextguest.setSize(config.back_sizex,config.back_sizey);
        jnextguest.setLocation(config.next_locationx,config.next_locationy);
        jnextguest.setFont(font.deriveFont(Font.BOLD));
        jnextguest.setForeground(Color.orange);
        jnextguest.setBackground(Color.black);
        this.add(jnextguest);
        jnextguest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameobject.stat==1){
                    return ;
                }
                else {
                    broker.takeCommand(readstory);
                    broker.placeCommand(gameobject,0,0);
                    if(broker.result==1){
                        duihua.setText(gameobject.text);
                    }
                    else if(broker.result==2){
                        duihua.setText(gameobject.text);
                        set_guest();
                    }
                    else{
                        time.setText("    下班了,回去吧...");
                    }
                }
            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addWindowListener(new Frame1());
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        if(this.isVisible()) {
        }
    }


    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }
}