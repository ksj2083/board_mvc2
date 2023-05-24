package com.ksj.myboard.service;

import com.ksj.myboard.dao.UserDao;
import com.ksj.myboard.vo.UserVO;

public class UserService {

    public boolean singUp(UserVO userVO) {

        //이메일(아이디)중복체크
        if(UserDao.getUserDao().getUserByEmail(userVO.getEmail()) != null) {
            return false;
        }

        UserDao.getUserDao().insertUser(userVO);
        return true;
    }
}
