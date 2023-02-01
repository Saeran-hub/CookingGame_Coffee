package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day {
    int daynum=1;
    ArrayList <String> talkwordlist = new ArrayList<String>();
    ArrayList <String> talkpersonnumlist =new ArrayList<String>();
    Day(){
        BufferedReader reader;
        String df="day.txt";
        try {
            reader = new BufferedReader(new FileReader(df));
            String line = reader.readLine();
            daynum=Integer.valueOf(line);
            while (line != null) {
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String talkwordfile="text\\talkword"+Integer.toString(daynum)+".txt";
        try {
            reader = new BufferedReader(new FileReader(talkwordfile));
            String line = reader.readLine();
            while (line != null) {
                talkwordlist.add(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String talkpersonfile="text\\talknum"+Integer.toString(daynum)+".txt";
        try {
            reader = new BufferedReader(new FileReader(talkpersonfile));
            String line = reader.readLine();
            while (line != null) {
                talkpersonnumlist.add(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
