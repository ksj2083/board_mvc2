package com.ksj.myboard;

import com.ksj.myboard.controller.*;

public class Mapper {

    public Controller getController(String cmd) {

//        if(cmd.equalsIgnoreCase("Login")) {
//            return new LoginController();
//        }
//
//        if(cmd.equalsIgnoreCase("Info")) {
//            return new InfoController();
//        }
//
        if(cmd.equalsIgnoreCase("Board")) {
            return new BoardController();
        }
//
//        if(cmd.equalsIgnoreCase("insertBoard")) {
//            return new InsertController();
//        }
//
//        if(cmd.equalsIgnoreCase("hit")) {
//            return new HitController();
//        }
//
//        if(cmd.equalsIgnoreCase("detail")) {
//            return new DetailController();
//        }

        return null;
    }
}
