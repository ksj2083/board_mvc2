package com.ksj.myboard.dao;

import com.ksj.myboard.conf.SqlSessionManager;
import com.ksj.myboard.vo.EvaluationVO;
import com.ksj.myboard.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;

public class EvaluationDao {

    private static EvaluationDao evaluationDao = new EvaluationDao();
    private SqlSessionFactory sessionFactory= SqlSessionManager.getSqlSessionFactory();

    public static EvaluationDao getEvaluationDao() {
        return evaluationDao;
    }

    public EvaluationVO getEvaluationByEmailAndBoardNo(String email, int boardNo) {
        SqlSession sqlSession = sessionFactory.openSession();

        HashMap<String, String> map = new HashMap<>();
        map.put("email", email);;
        map.put("boardNo", String.valueOf(boardNo));

        EvaluationVO evaluationVO = null;
        try {
            evaluationVO = sqlSession.selectOne("com.ksj.myboard.evaluation.selectEvaluationByBoardNoAndEmail"
            , map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return evaluationVO;
    }
}
