package com.company;

//public class Drink {
//}
public class Drink {
    public int basic;//基底
    public int second;//辅料
    public int third;//配料
    public int zhuangshi;//装饰
    int ku;
    int suan;
    int tian;
    int ice;
    int hot;
    Drink(){
        basic=-1;
        second=-1;
        third=-1;
        zhuangshi=-1;
        ku=0;
        suan=0;
        tian=0;
        ice=0;
        hot=0;
    }
    public int add_basic(int d){//d为对应的咖啡种类
        if(d>=1&&d<=4){//basic=1:light roast ：轻度烘培，柠檬、草莓、柑橘风味
            basic =d;//baisc=2 : city roast :中浅度烘培，车厘子、葡萄风味
            return 1;//basic=3: medium roast :中度烘培，坚果、杏仁、蜂蜜风味
                     //basic=4: dark roast : 重度烘培，焦糖、巧克力风味
        }
        return 1;
    }
    public int add_second(int d){//d=5,使用基底的咖啡豆。d=6，使用牛奶。d=7，使用水.d=8,使用燕麦奶。
            second=d;
            return 1;
    }
    public int add_third(int d){//d=9使用基底咖啡豆，d=10使用牛奶，d=11使用水，d=12使用燕麦奶，d=13使用香草，d=14使用坚果糖浆，d=15使用巧克力粉,d=16使用奶油
            third=d;
            return 1;
    }
    void get_score(int c){
        //第一层jurdge;
        if(c==1) {
            if (basic == 1) {
                ku = 2;
                suan = 8;
                tian = 0;
                ice = 1;
                hot = 3;
            } else if (basic == 2) {
                ku = 4;
                suan = 6;
                tian = 0;
                ice = 1;
                hot = 3;
            } else if (basic == 3) {
                ku = 6;
                suan = 4;
                tian = 0;
                ice = 1;
                hot = 3;
            } else if (basic == 4) {
                ku = 8;
                suan = 2;
                tian = 0;
                ice = 1;
                hot = 3;
            } else {
            }
        }
        //第二层jurdge;
        else if(c==2) {
            if (second == 5) {
                ku = ku + 3;
                suan = suan + 2;
                tian = tian + 0;
                ice = ice + 0;
                hot = hot + 3;
            } else if (second == 6) {
                ku = ku + 0;
                suan = suan - 1;
                tian = tian + 2;
                ice = ice + 2;
                hot = hot + 0;
            } else if (second == 7) {
                ku = ku - 2;
                suan = suan - 1;
                tian = tian -3;
                ice = ice + 3;
                hot = hot + 0;
            } else if (second == 8) {
                ku = ku -1;
                suan = suan -0 ;
                tian = tian + 3;
                ice = ice + 2;
                hot = hot + 0;
            } else {
            }
            ku=Math.max(ku,0);
            suan=Math.max(suan,0);
            tian=Math.max(tian,0);
            ice=Math.max(ice,0);
            hot=Math.max(hot,0);
        }
        //第三层jurdge;
        else if(c==3) {
            if (third == 9) {
                ku = ku + 0;
                suan = suan + 2;
                tian = tian + 0;
                ice = ice + 0;
                hot = hot + 0;
            } else if (third == 10) {
                ku = ku + 0;
                suan = suan - 1;
                tian = tian + 1;
                ice = ice + 2;
                hot = hot + 0;
            } else if (third == 11) {
                ku = ku - 1;
                suan = suan - 1;
                tian = tian - 1;
                ice = ice +0;
                hot = hot - 0;
            } else if (third == 12) {
                ku = ku + 0;
                suan = suan - 1;
                tian = tian + 1;
                ice = ice + 2;
                hot = hot + 0;
            } else if (third == 13) {
                ku = ku + 0;
                suan = suan - 1;
                tian = tian + 5;
                ice = ice + 2;
                hot = hot + 1;
            } else if (third == 14) {
                ku = ku + 0;
                suan = suan - 1;
                tian = tian + 3;
                ice = ice + 1;
                hot = hot + 2;
            } else if (third == 15) {
                ku = ku + 2;
                suan = suan - 0;
                tian = tian + 4;
                ice = ice + 0;
                hot = hot + 4;
            } else if (third == 16) {
                ku = ku - 1;
                suan = suan - 1;
                tian = tian + 5;
                ice = ice + 0;
                hot = hot + 0;
            } else {
            }
            ku=Math.max(ku,0);
            suan=Math.max(suan,0);
            tian=Math.max(tian,0);
            ice=Math.max(ice,0);
            hot=Math.max(hot,0);
        }
        else{}

    }
}