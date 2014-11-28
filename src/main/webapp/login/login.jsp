<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="tiny idea">
<meta name="author" content="xiaoqing.liu">
<link rel="shortcut icon" href="img/garfield.ico">
<title>TI</title>
<jsp:include page="../head/baseSource.jsp"></jsp:include>
<jsp:include page="../head/navbar.jsp"></jsp:include>
<jsp:include page="../head/footer.jsp"></jsp:include>
<link rel="stylesheet" href="css/login.css">
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container" id="main-container">
    <div id="carousel-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators" id="carousel-indicators">
        <c:forEach var="i" begin="0" end="${pic_l}">
            <li data-target="#carousel-generic" data-slide-to="${i}"></li>
        </c:forEach>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox" id="carousel-inner">
        <c:forTokens items="${pics}" 
                     delims="," var="name">
            <div class="item">
                <img src="img/${name}" alt="dota2_2">
                <div class="carousel-caption">
                </div>
            </div>
        </c:forTokens>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>