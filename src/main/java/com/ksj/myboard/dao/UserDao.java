package com.ksj.myboard.dao;

import com.ksj.myboard.conf.SqlSessionManager;
import com.ksj.myboard.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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




}
