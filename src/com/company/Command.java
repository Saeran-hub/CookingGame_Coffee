package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public interface Command {
    int execute(GameObject go,int i,int j);//i,j为在给饮料加内容时指定层数
}

//命令1：用于生成一个顾客的需求
class CreateGuest implements Command{

    public int execute(GameObject go,int i,int j){
        go.guest.order_drink();
        go.guest.trans_name();
        go.guest.trans_demand();
        if(go.guest.choice==1){
            go.text="来个"+ go.guest.drinkname+"吧。";
        }
        else {
            go.text = "能给我做杯" + go.guest.demandname+"的饮料吗？";
        }
        return 1;
    }

}

//命令2：获取顾客对应CG,赋值给GameObject中的guestphoto
 class PaintGuest  implements Command{
     public int execute(GameObject go,int i,int j){
         if(go.kind == 1){//剧情模式

         }
         else{//挑战模式
             Random rand = new Random();
             int randguest= rand.nextInt(25)+1;
             go.guestphoto=go.guestphotodir+Integer.toString(randguest)+go.photofomat;
         }
         return 1;
     }

}

//命令3：点击按钮制作饮料，i为添加层数，j为材料编号
class UpdateDrink implements Command{
    public int execute(GameObject go,int i,int j){
        if(i==1){
            go.drink.add_basic(j);
        }
        else if(i==2){
            go.drink.add_second(j);
        }
        else{
            go.drink.add_third(j);
        }
        return 1;
    }
}

//命令4：点击按钮的同时，更新饮料的口味评价
class UpdateScore implements Command{

    public int execute(GameObject go,int i,int j){
        if(i==1) {
            if (go.drink.basic == 1) {
                go.drink.ku = 2;
                go.drink.suan = 8;
                go.drink.tian = 0;
                go.drink.ice = 1;
                go.drink.hot = 3;
            } else if (go.drink.basic == 2) {
                go.drink.ku = 4;
                go.drink.suan = 6;
                go.drink.tian = 0;
                go.drink.ice = 1;
                go.drink.hot = 3;
            } else if (go.drink.basic == 3) {
                go.drink.ku = 6;
                go.drink.suan = 4;
                go.drink.tian = 0;
                go.drink.ice = 1;
                go.drink.hot = 3;
            } else if (go.drink.basic == 4) {
                go.drink.ku = 8;
                go.drink.suan = 2;
                go.drink.tian = 0;
                go.drink.ice = 1;
                go.drink.hot = 3;
            } else {
            }
        }
        //第二层jurdge;
        else if(i==2) {
            if (go.drink.second == 5) {
                go.drink.ku = go.drink.ku + 3;
                go.drink.suan = go.drink.suan + 2;
                go.drink.tian = go.drink.tian + 0;
                go.drink.ice = go.drink.ice + 0;
                go.drink.hot = go.drink.hot + 3;
            } else if (go.drink.second == 6) {
                go.drink.ku = go.drink.ku + 0;
                go.drink.suan = go.drink.suan - 1;
                go.drink.tian = go.drink.tian + 2;
                go.drink.ice = go.drink.ice + 2;
                go.drink.hot = go.drink.hot + 0;
            } else if (go.drink.second == 7) {
                go.drink.ku = go.drink.ku - 2;
                go.drink.suan = go.drink.suan - 1;
                go.drink.tian = go.drink.tian -3;
                go.drink.ice = go.drink.ice + 3;
                go.drink.hot = go.drink.hot + 0;
            } else if (go.drink.second == 8) {
                go.drink.ku = go.drink.ku -1;
                go.drink.suan = go.drink.suan -0 ;
                go.drink.tian = go.drink.tian + 3;
                go.drink.ice = go.drink.ice + 2;
                go.drink.hot = go.drink.hot + 0;
            } else {
            }
            go.drink.ku=Math.max(go.drink.ku,0);
            go.drink.suan=Math.max(go.drink.suan,0);
            go.drink.tian=Math.max(go.drink.tian,0);
            go.drink.ice=Math.max(go.drink.ice,0);
            go.drink.hot=Math.max(go.drink.hot,0);
        }
        //第三层jurdge;
        else if(i==3) {
            if (go.drink.third == 9) {
                go.drink.ku = go.drink.ku + 0;
                go.drink.suan = go.drink.suan + 2;
                go.drink.tian = go.drink.tian + 0;
                go.drink.ice = go.drink.ice + 0;
                go.drink.hot = go.drink.hot + 0;
            } else if (go.drink.third == 10) {
                go.drink.ku = go.drink.ku + 0;
                go.drink.suan = go.drink.suan - 1;
                go.drink.tian = go.drink.tian + 1;
                go.drink.ice = go.drink.ice + 2;
                go.drink.hot = go.drink.hot + 0;
            } else if (go.drink.third == 11) {
                go.drink.ku = go.drink.ku - 1;
                go.drink.suan = go.drink.suan - 1;
                go.drink.tian = go.drink.tian - 1;
                go.drink.ice = go.drink.ice +0;
                go.drink.hot = go.drink.hot - 0;
            } else if (go.drink.third == 12) {
                go.drink.ku = go.drink.ku + 0;
                go.drink.suan = go.drink.suan - 1;
                go.drink.tian = go.drink.tian + 1;
                go.drink.ice = go.drink.ice + 2;
                go.drink.hot = go.drink.hot + 0;
            } else if (go.drink.third == 13) {
                go.drink.ku = go.drink.ku + 0;
                go.drink.suan = go.drink.suan - 1;
                go.drink.tian = go.drink.tian + 5;
                go.drink.ice = go.drink.ice + 2;
                go.drink.hot = go.drink.hot + 1;
            } else if (go.drink.third == 14) {
                go.drink.ku = go.drink.ku + 0;
                go.drink.suan = go.drink.suan - 1;
                go.drink.tian = go.drink.tian + 3;
                go.drink.ice = go.drink.ice + 1;
                go.drink.hot = go.drink.hot + 2;
            } else if (go.drink.third == 15) {
                go.drink.ku = go.drink.ku + 2;
                go.drink.suan = go.drink.suan - 0;
                go.drink.tian = go.drink.tian + 4;
                go.drink.ice = go.drink.ice + 0;
                go.drink.hot = go.drink.hot + 4;
            } else if (go.drink.third == 16) {
                go.drink.ku = go.drink.ku - 1;
                go.drink.suan = go.drink.suan - 1;
                go.drink.tian = go.drink.tian + 5;
                go.drink.ice = go.drink.ice + 0;
                go.drink.hot = go.drink.hot + 0;
            } else {
            }
            go.drink.ku=Math.max(go.drink.ku,0);
            go.drink.suan=Math.max(go.drink.suan,0);
            go.drink.tian=Math.max(go.drink.tian,0);
            go.drink.ice=Math.max(go.drink.ice,0);
            go.drink.hot=Math.max(go.drink.hot,0);
        }
        else{}
        return 1;
    }
}
//命令5：按钮“完成”调用的命令，比较当前drink/score值是否符合且满足顾客的需要
class Compare implements Command{
    public int execute(GameObject go,int i,int j){
        if(go.guest.choice==1){
            if(go.guest.name_basic==go.drink.basic && go.guest.name_second==go.drink.second && go.guest.name_third==go.drink.third){
                return 1;
            }
            return 0;
        }
        else {
            if(go.guest.demand_ku==1){
                if(go.drink.ku<=3){}
                else{return 0;}
            }
            else if(go.guest.demand_ku==2){
                if(go.drink.ku>3&&go.drink.ku<=6){}
                else{return 0;}
            }
            else{
                if(go.drink.ku>6){}
                else{return 0;}
            }
            if(go.guest.demand_suan==1){
                if(go.drink.suan<=3){}
                else{return 0;}
            }
            else if(go.guest.demand_suan==2){
                if(go.drink.suan>3&&go.drink.suan<=6){}
                else{return 0;}
            }
            else{
                if(go.drink.suan>6){}
                else{return 0;}
            }
            if(go.guest.demand_tian==1){
                if(go.drink.tian<=3){}
                else{return 0;}
            }
            else if(go.guest.demand_tian==2){
                if(go.drink.tian>3&&go.drink.tian<=6){}
                else{return 0;}
            }
            else{
                if(go.drink.tian>6){}
                else{return 0;}
            }
            if(go.guest.demand_ice==1){
                if(go.drink.ice<=3){}
                else{return 0;}
            }
            else if(go.guest.demand_ice==2){
                if(go.drink.ice>3&&go.drink.ice<=6){}
                else{return 0;}
            }
            else{
                if(go.drink.ice>6){}
                else{return 0;}
            }
            if(go.guest.demand_hot==1){
                if(go.drink.hot<=3){}
                else{return 0;}
            }
            else if(go.guest.demand_hot==2){
                if(go.drink.hot>3&&go.drink.hot<=6){}
                else{return 0;}
            }
            else{
                if(go.drink.hot>6){}
                else{return 0;}
            }
        }
        return 2;
    }
}

//命令6：按钮“重做”触发，将drink与score全部置0
class Reset implements Command{
    public int execute(GameObject go,int i,int j){
        go.drink.basic=0;
        go.drink.second=0;
        go.drink.third=0;
        go.drink.hot=0;
        go.drink.ice=0;
        go.drink.ku=0;
        go.drink.suan=0;
        go.drink.tian=0;
        return 1;
    }
}

//命令7：按钮“加冰”触发，score的ice值+1，hot值-1
class AddIce implements Command{
    public int execute(GameObject go,int i,int j){
        go.drink.ice=go.drink.ice+1;
        go.drink.hot=go.drink.hot-1;
        go.drink.ice=Math.max(go.drink.ice,0);
        go.drink.hot=Math.max(go.drink.hot,0);
        return 1;
    }
}

//命令8：按钮“加热”触发，score的ice值+1，hot值-1
class AddHot implements Command{
    public int execute(GameObject go,int i,int j){
        go.drink.ice=go.drink.ice-1;
        go.drink.hot=go.drink.hot+1;
        go.drink.ice=Math.max(go.drink.ice,0);
        go.drink.hot=Math.max(go.drink.hot,0);
        return 1;
    }
}

//命令9：读剧情文件，剧情模式触发的命令
class ReadStory implements Command{
    public int execute(GameObject go,int i,int j){
        /*if(go.day.talkpersonnumlist.get(go.talkp).equals("0")&&go.talkp!=0){
            go.guestphoto=go.guestphotodir+go.day.talkpersonnumlist.get(go.talkp-1)+go.photofomat;
        }
        else {
            go.guestphoto = go.guestphotodir+go.day.talkpersonnumlist.get(go.talkp) + go.photofomat;
        }
        return 1;
         */
        if(go.talkp<go.day.talkpersonnumlist.size()){//有剧情没走完
            if(go.day.talkpersonnumlist.get(go.talkp).equals("999")){//该制作饮料了
                //broker.takeCommand(createguest);
                //broker.placeCommand(gameobject,0,0);
                //duihua.setText(gameobject.text);
                CreateGuest cg=new CreateGuest();
                cg.execute(go,0,0);
                if(go.guest.choice==1){
                    go.text="    来个"+go.guest.drinkname;
                }
                else{
                    go.text="    能做一杯"+go.guest.demandname+"的饮料吗";
                }
                go.talkp++;
                go.stat=1;
                return 1;
            }
            else{//对话
                if(go.day.talkpersonnumlist.get(go.talkp).equals("0")&&go.talkp!=0){
                    go.guestphoto=go.guestphotodir+go.day.talkpersonnumlist.get(go.talkp-1)+go.photofomat;
                }
                else {
                    go.guestphoto = go.guestphotodir+go.day.talkpersonnumlist.get(go.talkp) + go.photofomat;
                }
                //set_guest();
                go.text=go.day.talkwordlist.get(go.wordp);
                go.talkp++;
                go.wordp++;
                return 2;
            }
        }
        else{
            File daytxt = new File("day.txt");
            if (daytxt.delete()) {
            }
            else {
            }
            File dayt=new File("day.txt");
            try {
                if (dayt.createNewFile()) {
                } else {
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // 使用FileWriter写文件
            go.day.daynum++;
            if(go.day.daynum>=3){
                go.day.daynum=1;
            }
            try (FileWriter writer = new FileWriter(dayt)) {
                writer.write(Integer.toString(go.day.daynum));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            return 3;
        }
    }
}

