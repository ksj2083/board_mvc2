package com.ksj.myboard.util;

import com.ksj.myboard.vo.PageBean;

public class PagingUtil {

	private static PagingUtil pagingUtil = new PagingUtil();

	public static PagingUtil getPagingUtil() {
		return pagingUtil;
	}

	public Integer getOffset(Integer curPage, Integer pageScale) {
		return (curPage-1)*pageScale;
	}

	public PageBean pagingCreate(Integer totalRow, Integer currentPage, Integer pageScale) {
		int totalPage=totalRow%pageScale==0?(totalRow/pageScale):(totalRow/pageScale)+1;
	    totalPage=totalPage==0?1:totalPage;

	    int start=1+(currentPage-1)*pageScale;
	    int end=pageScale+(currentPage-1)*pageScale;
	    int currentBlock=currentPage%pageScale==0?(currentPage/pageScale):(currentPage/pageScale)+1;
	    int startPage=1+(currentBlock-1)*pageScale;
	    //int endPage=(pageScale+(currentBlock-1)*pageScale)>totalPage?totalPage:(pageScale+(currentBlock-1)*pageScale);
	    int endPage=(pageScale+(currentBlock-1)*pageScale);
	    if(endPage>totalPage)endPage=totalPage;

		return new PageBean(currentBlock, currentPage, totalPage, startPage, endPage);
	}
}


//currentPage = 1----> start=1    end=10
//currentPage = 2----> start=11   end=20

//처음페이지 이전 1 2 3 4 5 6 7 8 9  10 다음 마지막페이지
//11 12 13 14 15 16 17 18 19  20
//21 22 23 24 25
//currentBlock=1   startPage=1   endPage=10
//currentBlock=2   startPage=11   endPage=20
//currentBlock=3   startPage=21   endPage=30















