<%@ page language="java" contentType="text/html; charset=EUC-KR"
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
		<div class="list-group">
			<div class="list-group-item board-title">
				<div class="board-title">
					<span class="board-category">[JAVASCRIPT]</span><a href="#">
						스크립트 태그를 마지막에 쓰는 이유 </a> 
				</div>
				<div class="board-meta"
					style="font-weight: 400; font-size: 1.2rem; color: #404040">
					<p>
						<i class="glyphicon glyphicon-user"></i> 미립 님 
						<i class="glyphicon glyphicon-comment"></i> 0
						<i class="glyphicon glyphicon-ok"></i> 20 
						<i class="glyphicon glyphicon-time"></i> 2016.03.31 21:55
					    <i class="glyphicon glyphicon-thumbs-up"></i> 0
						<i class="glyphicon glyphicon-thumbs-down"></i> 0
					</p>
				</div>
				<div class="clear"></div>
			</div>
			<div class="list-group-item">
				<span class="board-contents"> 브라우저가 HTML 문서를 해석(Parsing) 할 때
					script 태그를 만나면 HTML의 해석을 멈추고 JavaScript 를 처리하게 됩니다. 이때 사용자 입장에서는
					페이지가 화면에 다 그려지기까지 더 큰 시간을 요구 하므로 CSS와 HTML 해석이 먼저 완료되고 나서
					JavaScript 가 수행되는 것이 더 빠르게 느껴질 수 있습니다. 따라서 스크립트 태그를 가장 나중에(body
					직전)에 작성하는 것을 권장합니다. </span>
				<p style="text-align: center; margin-top: 30px">
					<button class="btn btn-success">
						<i class="glyphicon glyphicon-thumbs-up"></i>공감
					</button>
					<button class="btn btn-warning">
						<i class="glyphicon glyphicon-thumbs-down"></i>비공감
					</button>
				</p>
			</div>
			<div class="bottom" style="margin: 10px;margin-top: 20px; text-align: right">
				<a href="#" class="btn btn-default btn-xs pull-left">목록으로</a> 
				<a href="#" class="btn btn-default btn-xs">수정</a> 
				<a href="#" target="_action_frame_bbs" class="btn btn-default btn-xs" onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a> 
				<a href="#" class="btn btn-default btn-xs">답변</a>
				<a href="#" class="btn btn-default btn-xs">스크랩</a> 
			</div>
			<div class="clear"></div>
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
