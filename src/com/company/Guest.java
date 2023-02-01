package com.company;

import java.util.Random;

public class Guest {
    //点单
    int choice=-1;//=1为指定饮品名，=2为口味需求
    int name_basic;
    int name_second;
    int name_third;
    int demand_ku;
    int demand_suan;
    int demand_tian;
    int demand_ice;
    int demand_hot;
    //交谈
    String drinkname;
    String demandname;
    void trans_name(){
        if(name_basic==1){
            drinkname="轻烘培";
        }
        else if(name_basic==2){
            drinkname="中浅烘培";
        }
        else if(name_basic==3){
            drinkname="中烘培";
        }
        else if(name_basic==4){
            drinkname="重度烘培";
        }
        if(name_second==5){
            drinkname+="浓缩";
        }
        else if(name_second==6){
            drinkname+="拿铁";
        }
        else if(name_second==7){
            drinkname+="美式";
        }
        else if(name_second==8){
            drinkname+="燕麦拿铁";
        }
        if(name_third==9){
            drinkname="百香果"+drinkname;
        }
        else if(name_third==10){
            drinkname="加奶"+drinkname;
        }
        else if(name_third==11){
            drinkname="加水"+drinkname;
        }
        else if(name_third==12){
            drinkname="加燕麦"+drinkname;
        }
        else if(name_third==13){
            drinkname="香草"+drinkname;
        }
        else if(name_third==14){
            drinkname="坚果"+drinkname;
        }
        else if(name_third==15){
            drinkname="巧克力"+drinkname;
        }
        else if(name_third==16){
            drinkname="奶油"+drinkname;
        }
    }

    void order_drink(){
        Random rand = new Random();
        choice = rand.nextInt(2) + 1;
        //choice=1;
        if(choice==1) {
            name_basic = rand.nextInt(4) + 1;
            name_second=rand.nextInt(4)+ 5;
            name_third=rand.nextInt(8)+ 9;
        }
        else{
            demand_ku=rand.nextInt(3) + 1;
            demand_suan=rand.nextInt(3) + 1;
            demand_tian=rand.nextInt(3) + 1;
            demand_ice=rand.nextInt(3) + 1;
            demand_hot=rand.nextInt(3) + 1;
        }
    }
    void trans_demand(){
        if(demand_ku==1){
            demandname="不怎么苦,";
        }
        else if(demand_ku==2){
            demandname="中等苦,";
        }
        else{
            demandname="苦味重,";
        }
        if(demand_suan==1){
            demandname+="不酸，";
        }
        else if(demand_suan==2){
            demandname+="酸度适中，";
        }
        else{
            demandname+="很酸的，";
        }
        if(demand_tian==1){
            demandname+="无糖或少糖，";
        }
        else if(demand_tian==2){
            demandname+="甜味适中，";
        }
        else{
            demandname+="很甜的，";
        }
        if(demand_ice==1){
            demandname+="不要清凉，";
        }
        else if(demand_ice==2){
            demandname+="适中清凉，";
        }
        else{
            demandname+="很清凉，";
        }
        if(demand_hot==1){
            demandname+="不热";
        }
        else if(demand_hot==2){
            demandname+="温";
        }
        else{
            demandname+="热";
        }
    }
}
