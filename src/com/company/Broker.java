package com.company;
import java.util.ArrayList;
import java.util.List;
public class Broker {
    int result;
    private List<Command> commandList = new ArrayList<Command>();
    public void takeCommand(Command command){
        commandList.add(command);
    }

    public void placeCommand(GameObject g,int i,int j){
        if(commandList.size()==1){
            result=commandList.get(0).execute(g,i,j);
        }
        else {
            for (Command comm : commandList) {
                comm.execute(g, i, j);
            }
        }
        commandList.clear();
    }
}
