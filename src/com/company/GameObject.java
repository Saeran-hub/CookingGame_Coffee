package com.company;

import java.util.TimerTask;

public class GameObject {
    private static GameObject instance;
    Guest guest;//顾客类
    Day day;//日期类
    Drink drink;//饮品类
    //ExTimer game_timer;


    int kind;//1:剧情模式   2：挑战模式
    int stat;//当前游戏的状态。1：禁止生成新的顾客。0:允许生成新的顾客。
    int run;
    int talkp;//顾客序列指针
    int wordp;//文字指针
    int cups;
    String guestphotodir="gamepics/guest/guest";
    String guestphoto;
    String photofomat=".png";
    String text="";
    private GameObject(){
        guest=new Guest();
        drink=new Drink();
        day=new Day();
        talkp=0;
        wordp=0;
        stat=0;
        cups=0;
        run=0;
    }
    public static GameObject getInstance() {
        if (instance == null) {
            instance = new GameObject();
        }
        return instance;
    }
}
