<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC >
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Start Simple Web</title>
    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/clean-blog.css" rel="stylesheet">
    <link href="resources/css/board.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link
            href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
            rel="stylesheet" type="text/css">
    <link
            href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
            rel='stylesheet' type='text/css'>
    <link
            href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
            rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <![endif]-->

</head>
<body>


<jsp:include page="header.jsp"></jsp:include>

<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="intro-header"
        style="background-image: url('resources/img/about-bg.jpg'); height: 200px">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="site-heading"
                     style="margin-top: 10px; padding-top: 35px; padding-bottom: 35px">
                    <h2>SAMPLE</h2>
                    <span class="subheading">BULLETIN BOARD</span>
                </div>
            </div>
        </div>
    </div>
</header>
<div class="board-field">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <div class="board-toolbar" style="text-align: right; margin-bottom: 20px">

            <a href="${pageContext.request.contextPath}/write.jsp" class="btn btn-primary btn-sm"><i
                    class="glyphicon glyphicon-pencil" style="margin-right: 15px"></i>쓰기</a>
        </div>
        <div class="list-group">

            <%--				<a href="info.jsp" class="list-group-item">--%>
            <%--					<div class="board-title">--%>
            <%--							버블정렬  <span class="badge">New</span>--%>
            <%--					</div>--%>
            <%--					<div class="board-meta"--%>
            <%--						style="font-weight: 400; font-size: 1.2rem; color: #404040">--%>
            <%--						<p>--%>
            <%--							<i class="glyphicon glyphicon-user"></i> 미립 님 <i--%>
            <%--								class="glyphicon glyphicon-comment"></i> 0 <i--%>
            <%--								class="glyphicon glyphicon-ok"></i> 20 <i--%>
            <%--								class="glyphicon glyphicon-time"></i> 2016.03.31 21:55--%>
            <%--						</p>--%>
            <%--					</div>--%>
            <%--				</a>--%>

            <c:forEach var="i" items="${list}">
                <a href="${pageContext.request.contextPath}/info.do?cmd=board&method=info&no=${i.no}" class="list-group-item">
                    <div class="board-title">
                            ${i.title}
                    </div>

                    <div class="board-meta"
                         style="font-weight: 400; font-size: 1.2rem; color: #404040">
                        <p>
                            <i class="glyphicon glyphicon-user"></i> ${i.writer} 님 <i
                                class="glyphicon glyphicon-comment"></i> 댓글수 <i
                                class="glyphicon glyphicon-ok"></i> 좋아요수 <i
                                class="glyphicon glyphicon-time"></i> ${i.regdate}
                        </p>
                    </div>
                </a>
            </c:forEach>


        </div>
        <div class="col-md-2"></div>

        <div class="col-md-8">
            <ul class="pagination">

                <c:choose>
                    <c:when test="${pageBean.currentPage>1}">
                        <li>
                            <a href="${pageContext.request.contextPath}/list.do?cmd=board&method=select&curPage=${pageBean.currentPage-1}">
                                이전
                            </a>
                        </li>
                    </c:when>
                </c:choose>


                <c:forEach var="num" begin="${pageBean.startPage}" end="${pageBean.endPage}" step="1">
                    <li>
                        <c:choose>
                            <c:when test="${num eq pageBean.currentPage}">
                                <a href="${pageContext.request.contextPath}/list.do?cmd=board&method=select&curPage=${num}"
                                   id="pagenum"><font color="red">${num}</font></a>
                            </c:when>
                            <c:otherwise>
                                <a href="${pageContext.request.contextPath}/list.do?cmd=board&method=select&curPage=${num}"
                                   id="pagenum">${num}</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </c:forEach>


                <c:choose>
                    <c:when test="${pageBean.totalPage>pageBean.currentPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/list.do?cmd=board&method=select&curPage=${pageBean.currentPage+1}">
                                다음
                            </a>
                        </li>
                    </c:when>
                </c:choose>


            </ul>


        </div>

    </div>
</div>
<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <ul class="list-inline text-center">
                    <li><a href="#"> <span class="fa-stack fa-lg"> <i
                            class="fa fa-circle fa-stack-2x"></i> <i
                            class="fa fa-envelope-o fa-stack-1x fa-inverse"></i>
							</span>
                    </a></li>
                    <li><a href="#"> <span class="fa-stack fa-lg"> <i
                            class="fa fa-circle fa-stack-2x"></i> <i
                            class="fa fa-home fa-stack-1x fa-inverse"></i>
							</span>
                    </a></li>
                    <li><a href="#"> <span class="fa-stack fa-lg"> <i
                            class="fa fa-circle fa-stack-2x"></i> <i
                            class="fa fa-github fa-stack-1x fa-inverse"></i>
							</span>
                    </a></li>
                </ul>
                <p class="copyright text-muted">Copyright &copy;2016 SIST. All
                    rights reserved | code by milib</p>
            </div>
        </div>
    </div>
</footer>
<!-- jQuery -->
<script src="resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="resources/js/clean-blog.min.js"></script>

</body>

</html>
