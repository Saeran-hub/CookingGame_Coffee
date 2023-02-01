package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


class Frame1 extends JFrame implements WindowListener
{
    JButton game_challenge = new JButton("挑战");
    JButton game_story = new JButton("剧情");
    JLabel bg;
    Frame1 myself=this;
    Frame2 f2;
    Frame f3;

    private class btListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("挑战"))
            {
                setVisible(false);
                f2=new Frame2(myself);
            }
            else if(e.getActionCommand().equals("剧情"))
            {
                setVisible(false);
                f3=new Frame3(myself);
            }
        }
    }

    public Frame1()
    {
        this.setTitle("Coffee Game");
        this.setSize(1400, 800);
        //导入字体
        //导入字体
        Font font = Loadfont.loadFont("../../../方正像素12.TTF", 26f);
        //设置背景
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("gamepics/city.png");
        bg = new JLabel(img);
        this.getLayeredPane().add(bg, new Integer(Integer.MIN_VALUE));
        bg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        this.setLayout(new FlowLayout());
        //设置挑战模式
        game_challenge.addActionListener(new btListener());
        game_challenge.setSize(300,200);
        game_challenge.setLocation(300,400);
        game_challenge.setFont(font.deriveFont(Font.BOLD).deriveFont(32));
        game_challenge.setBackground(Color.black);
        game_challenge.setForeground(Color.PINK);
        //设置故事模式
        game_story.addActionListener(new btListener());
        game_story.setSize(300,200);
        game_story.setLocation(800,400);
        game_story.setFont(font.deriveFont(Font.BOLD).deriveFont(32));
        game_story.setBackground(Color.black);
        game_story.setForeground(Color.PINK);
        this.add(game_challenge);
        this.add(game_story);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void back(){
        setVisible(true);
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        setVisible(true);
    }
    public void windowClosed(WindowEvent e) {
    }
    public void windowIconified(WindowEvent e) {
    }
    public void windowDeiconified(WindowEvent e) {
    }
    public void windowActivated(WindowEvent e) {
    }
    public void windowDeactivated(WindowEvent e) {
    }

}

public class Main {

    public static void main(String[] args) {
        Frame1 f1 = new Frame1();
        f1.setVisible(true);
    }

}

