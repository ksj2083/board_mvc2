package com.ksj.myboard.service;

import com.ksj.myboard.dao.ListDao;
import com.ksj.myboard.vo.BoardAppVO;

import java.util.Hashtable;
import java.util.List;

public class BoardService {

    public Integer getTotalCount(String keyword) {
        return ListDao.getListDao().getTotalCount(keyword);
    }

    public List<BoardAppVO> getListByTitle(Hashtable<String, Object> hashtable) {
        return ListDao.getListDao().getListByTitle(hashtable);
    }
//
    public void insertBoard(BoardAppVO vo) {
        ListDao.getListDao().insertBoard(vo);
    }
//
//    public void updateHit(int no) {
//        ListDao.getListDao().updateHit(no);
//
//    }
//
    public BoardAppVO selectInfo(int no) {
        return ListDao.getListDao().selectInfo(no);
    }

}
