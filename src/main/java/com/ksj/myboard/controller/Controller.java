package com.ksj.myboard.controller;

import com.ksj.myboard.type.PageMovement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    PageMovement execute(HttpServletRequest request,
                         HttpServletResponse response);


}
