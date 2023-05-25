package com.ksj.myboard.dao;

import com.ksj.myboard.conf.SqlSessionManager;
import com.ksj.myboard.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static UserDao userDao = new UserDao();
    private SqlSessionFactory sessionFactory= SqlSessionManager.getSqlSessionFactory();

    public static UserDao getUserDao() {
        return userDao;
    }

    public UserVO getUserByEmail(String email) {

        SqlSession sqlSession = sessionFactory.openSession();
        UserVO userVO = null;

        try {
            userVO = sqlSession.selectOne("com.ksj.myboard.user.selectUserByEmail", email);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }

        return userVO;
    }

    public void insertUser(UserVO userVO) {

        SqlSession sqlSession = sessionFactory.openSession();

        try {
            sqlSession.selectOne("com.ksj.myboard.user.insertUser", userVO);
            sqlSession.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    public UserVO getUserByEmailAndPassword(String email, String password) {
        SqlSession sqlSession = sessionFactory.openSession();

        HashMap<String, String> map = new HashMap<>();
        map.put("email", email);
        System.out.println(email);
        System.out.println(password);
        map.put("password", password);

        UserVO userVO = null;
        try {
            userVO = sqlSession.selectOne("com.ksj.myboard.user.selectByEmailAndPassword", map);
            System.out.println("userVO = " + userVO);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return userVO;
    }
}
