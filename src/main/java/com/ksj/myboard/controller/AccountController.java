package com.ksj.myboard.controller;

import com.ksj.myboard.service.UserService;
import com.ksj.myboard.type.PageMovement;
import com.ksj.myboard.type.PageMovementType;
import com.ksj.myboard.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountController implements Controller {

    private final UserService userService = new UserService();

    @Override
    public PageMovement execute(HttpServletRequest request, HttpServletResponse response) {

        String method = request.getParameter("method");

        if("signIn".equalsIgnoreCase(method)) {
            return signIn(request, response);
        }

        if("signUpPage".equalsIgnoreCase(method)) {
            return signUpPage(request, response);
        }

        if("signUp".equalsIgnoreCase(method)) {
            return signUp(request, response);
        }

        throw new RuntimeException();
    }

    private PageMovement signIn(HttpServletRequest request, HttpServletResponse response) {
//        String userId = request.getParameter("id");
//        String userPw = request.getParameter("password");
//
//        System.out.println("id : " + userId);
//        System.out.println("pw : " + userPw);
//
//        if(loginService.loginCheck(userId, userPw)) {
//            request.getSession().setAttribute("id", userId);
//            request.getSession().setMaxInactiveInterval(600);
//            request.setAttribute("state", "T");
//
//            return new PageMovement("login/AjaxLoginView.jsp", PageMovementType.FORWARD);
//        }
//
//        request.setAttribute("state", "F");
//        return new PageMovement("login/AjaxLoginView.jsp", PageMovementType.FORWARD);

        return null;
    }

    //http://localhost:8080/web/list.do?cmd=account&method=signuppage
    private PageMovement signUpPage(HttpServletRequest request, HttpServletResponse response) {
        return new PageMovement("signup.jsp", PageMovementType.REDIRECT);
    }

    private PageMovement signUp(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean result = userService.singUp(new UserVO(email, password));

        if(!result) throw new RuntimeException(); //중복발생

        
        //로그인으로 보낼 예정
        return new PageMovement("board.do?cmd=board&method=select", PageMovementType.REDIRECT);
        
    }

}
