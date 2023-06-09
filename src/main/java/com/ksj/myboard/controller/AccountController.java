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

        if("signInPage".equalsIgnoreCase(method)) {
            return signInPage(request, response);
        }

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
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserVO userVO = userService.signIn(email, password);

        if(userVO == null) {
            return new PageMovement("signIn.do?cmd=account&method=signInPage", PageMovementType.REDIRECT);
        }

        request.getSession().setAttribute("email", userVO.getEmail());
        request.getSession().setMaxInactiveInterval(600);
        return new PageMovement("list.do?cmd=board&method=select", PageMovementType.REDIRECT);
    }

    //http://localhost:8080/web/list.do?cmd=account&method=signuppage
    private PageMovement signUpPage(HttpServletRequest request, HttpServletResponse response) {
        return new PageMovement("signup.jsp", PageMovementType.FORWARD);
    }

    private PageMovement signInPage(HttpServletRequest request, HttpServletResponse response) {
        return new PageMovement("signin.jsp", PageMovementType.FORWARD);
    }

    private PageMovement signUp(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean result = userService.singUp(new UserVO(email, password));

        if(!result) throw new RuntimeException(); //중복발생


        return new PageMovement("signIn.do?cmd=account&method=signInPage", PageMovementType.REDIRECT);
    }

}
