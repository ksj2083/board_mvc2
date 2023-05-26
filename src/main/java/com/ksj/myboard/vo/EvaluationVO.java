package com.ksj.myboard.vo;

public class EvaluationVO {

    private int no;
    private int boardNo;
    private String userEmail;
    private String eval;

    public EvaluationVO(int no, int boardNo, String userEmail, String eval) {
        this.no = no;
        this.boardNo = boardNo;
        this.userEmail = userEmail;
        this.eval = eval;
    }

    public EvaluationVO(int boardNo, String userEmail, String eval) {
        this.boardNo = boardNo;
        this.userEmail = userEmail;
        this.eval = eval;
    }

    public EvaluationVO() {
    }

    public int getNo() {
        return no;
    }

    @Override
    public String toString() {
        return "EvaluationVO{" +
                "no=" + no +
                ", boardNo=" + boardNo +
                ", userEmail='" + userEmail + '\'' +
                ", eval='" + eval + '\'' +
                '}';
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getEval() {
        return eval;
    }

    public void setEval(String eval) {
        this.eval = eval;
    }
}
