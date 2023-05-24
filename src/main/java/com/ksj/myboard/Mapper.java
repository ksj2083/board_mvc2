package com.ksj.myboard;

import com.ksj.myboard.controller.*;

public class Mapper {

    public Controller getController(String cmd) {

        if(cmd.equalsIgnoreCase("Account")) {
            return new AccountController();
        }

        if(cmd.equalsIgnoreCase("Board")) {
            return new BoardController();
        }


        return null;
    }
}
