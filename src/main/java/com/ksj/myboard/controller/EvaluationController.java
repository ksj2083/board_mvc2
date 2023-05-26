package com.ksj.myboard.controller;

import com.ksj.myboard.service.EvaluationService;
import com.ksj.myboard.type.PageMovement;
import com.ksj.myboard.vo.EvaluationVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EvaluationController implements Controller {

    EvaluationService evaluationService = new EvaluationService();
    @Override
    public PageMovement execute(HttpServletRequest request, HttpServletResponse response) {

        int boardNo = Integer.parseInt(request.getParameter("no"));
        String email = (String) request.getSession().getAttribute("email");
        String eval = request.getParameter("eval");

        EvaluationVO evaluationVO = new EvaluationVO(boardNo, email, eval);

        String evaluation = evaluationService.evaluation(evaluationVO);

        System.out.println(evaluation);

        return null;
    }
}
