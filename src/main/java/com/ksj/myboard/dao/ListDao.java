package com.ksj.myboard.dao;

import com.ksj.myboard.conf.SqlSessionManager;
import com.ksj.myboard.vo.BoardAppVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.*;


public class ListDao {

    private static ListDao listDao = new ListDao();
    private SqlSessionFactory sessionFactory= SqlSessionManager.getSqlSessionFactory();

    public static ListDao getListDao() {
        return listDao;
    }

    public List<BoardAppVO> getListByTitle(Hashtable<String, Object> hashtable) {
        // TODO Auto-generated method stub
        SqlSession sqlSession=sessionFactory.openSession();
        List<BoardAppVO> list = null;
        try {
            list = sqlSession.selectList("com.ksj.myboard.selectListByTitle", hashtable);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;
    }

    public Integer getTotalCount(String keyword) {
        // TODO Auto-generated method stub
        SqlSession sqlSession=sessionFactory.openSession();
        Integer total = -1;

        try {
            total = sqlSession.selectOne("com.ksj.myboard.selectTotal", keyword);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return total;
    }


    public void insertBoard(BoardAppVO vo) {
        SqlSession sqlSession=sessionFactory.openSession();

        try {
            sqlSession.insert("com.ksj.myboard.insertBoard", vo);
            sqlSession.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }
//
//    public void updateHit(int no) {
//        // TODO Auto-generated method stub
//        SqlSession sqlSession=sessionFactory.openSession();
//        try {
//            sqlSession.update("com.bit.vo.updateHit",no);
//            sqlSession.commit();
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//            sqlSession.rollback();
//        }finally {
//            sqlSession.close();
//        }
//    }
//
//
//    public BoardAppVO selectDetail(int no) {
//
//        return sessionFactory.openSession().selectOne("com.bit.vo.selectDetail",no);
//    }
}