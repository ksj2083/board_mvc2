package com.ksj.myboard.service;

import com.ksj.myboard.dao.EvaluationDao;
import com.ksj.myboard.dao.UserDao;
import com.ksj.myboard.vo.EvaluationVO;
import com.ksj.myboard.vo.UserVO;

public class EvaluationService {

    public String evaluation(EvaluationVO evaluationVO) {

        if(!checkDup(evaluationVO.getUserEmail(), evaluationVO.getNo())) {
            System.out.println("dup");
            return "dup";
        }

        System.out.println("ok");
        return "ok";
    }

    private boolean checkDup(String email, int boardNo) {
        EvaluationVO vo = EvaluationDao.getEvaluationDao().getEvaluationByEmailAndBoardNo(email, boardNo);
        if(vo != null) return false;
        return true;
    }
}
