package com.ksj.myboard.controller;

import com.ksj.myboard.service.BoardService;
import com.ksj.myboard.type.PageMovement;
import com.ksj.myboard.type.PageMovementType;
import com.ksj.myboard.util.PagingUtil;
import com.ksj.myboard.vo.BoardAppVO;
import com.ksj.myboard.vo.PageBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Hashtable;
import java.util.List;

//localhost:8080/web/list.do?cmd=list&method=select
public class ListController implements Controller {

    private final BoardService boardService = new BoardService();

    private final int PAGING_SCALE = 10;

    @Override
    public PageMovement execute(HttpServletRequest request, HttpServletResponse response) {

        String method = request.getParameter("method");

        if(method.equalsIgnoreCase("select")) {
            return select(request, response);
        }

        return null;
    }

    private PageMovement select(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("keyword") == null ? "" : request.getParameter("keyword");
        Integer curPage =  Integer.parseInt(
                request.getParameter("curPage") == null? "1" : request.getParameter("curPage"));

        Hashtable<String, Object> pagingValue = new Hashtable<>();
        pagingValue.put("keyword", keyword);
        pagingValue.put("offset", PagingUtil.getPagingUtil().getOffset(curPage, PAGING_SCALE));
        pagingValue.put("limit", PAGING_SCALE);

        List<BoardAppVO> list = boardService.getListByTitle(pagingValue);
        PageBean pageBean = PagingUtil.getPagingUtil().pagingCreate(boardService.getTotalCount(keyword),
                curPage, PAGING_SCALE
        );

        request.setAttribute("list", list);
        request.setAttribute("pageBean", pageBean);
//        return new PageMovement("upload/list_c.jsp", PageMovementType.FORWARD);
        return new PageMovement("board.jsp", PageMovementType.FORWARD);
    }
}
