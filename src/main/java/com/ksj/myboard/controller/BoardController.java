package com.ksj.myboard.controller;

import com.ksj.myboard.service.BoardService;
import com.ksj.myboard.type.PageMovement;
import com.ksj.myboard.type.PageMovementType;
import com.ksj.myboard.util.PagingUtil;
import com.ksj.myboard.vo.BoardAppVO;
import com.ksj.myboard.vo.PageBean;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

//localhost:8080/web/list.do?cmd=board&method=select
public class BoardController implements Controller {

    private final BoardService boardService = new BoardService();

    private final int PAGING_SCALE = 10;

    @Override
    public PageMovement execute(HttpServletRequest request, HttpServletResponse response) {

        String method = request.getParameter("method");

        if("select".equalsIgnoreCase(method)) {
            return select(request, response);
        }

        if("write".equalsIgnoreCase(method)) {
            return write(request, response);
        }

        if("info".equalsIgnoreCase(method)) {
            return info(request,response);
        }


        throw new RuntimeException();
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
    private PageMovement write(HttpServletRequest request, HttpServletResponse response) {

        int size=10*1024*1024;

        String uploadPath = "C:\\thezone-bit\\java\\eclipse-workspace-tmp\\MyBoard\\MyBoard\\src\\main\\webapp\\file";

        try {
            MultipartRequest multi=new MultipartRequest(
                    request,//원래 요청객체
                    uploadPath,//upload경로
                    size,//MaxSize
                    "UTF-8",//한글문제 해결
                    new DefaultFileRenamePolicy());//똑같은 파일 업로드시 자동으로 변환

            Enumeration e=multi.getFileNames();
            String file=(String)e.nextElement();
            BoardAppVO vo=new BoardAppVO(multi.getParameter("title"),
                    multi.getParameter("writer"),
                    multi.getParameter("password"),
                    multi.getParameter("contents"),
                    "myId", //임시
                    //multi.getParameter("id"),
                    multi.getOriginalFileName(file));
            System.out.println(vo);

            boardService.insertBoard(vo);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return new PageMovement("board.do?cmd=board&method=select", PageMovementType.REDIRECT);
    }

    private PageMovement info(HttpServletRequest request, HttpServletResponse response) {

        int no=Integer.parseInt(request.getParameter("no"));
        request.setAttribute("info", boardService.selectInfo(no));
        return new PageMovement("info.jsp", PageMovementType.FORWARD);
    }
}
