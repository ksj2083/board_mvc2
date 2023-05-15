package com.ksj.myboard.controller;

import com.ksj.myboard.type.PageMovement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
    PageMovement execute(HttpServletRequest request,
                         HttpServletResponse response);


}
