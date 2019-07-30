package com.example.jpushdemo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgControl {
    private List<String> msgList;
    private static final int ListSize = 20;

    private static MsgControl instance = new MsgControl();
    private MsgControl(){
        msgList = new ArrayList<String>();
    }
    public static MsgControl getInstance(){
        if(instance == null){
            instance = new MsgControl();
        }
        return instance;
    }

    void addMsg(String msg){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        msg = format.format(date).toString() + " "+ msg;
        msgList.add(msg);
        while(msgList.size() >= ListSize){
            msgList.remove(0);
        }
    }

    String getString(){
        String retn = "";
        for(String msg : msgList){
            retn = msg + "\n" + retn;
        }
        return retn;
    }
}
