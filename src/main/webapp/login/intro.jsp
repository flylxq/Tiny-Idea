<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="tiny idea">
<meta name="author" content="xiaoqing.liu">
<link rel="shortcut icon" href="img/garfield.ico">
<jsp:include page="../head/baseSource.jsp"></jsp:include>
<jsp:include page="../head/navbar.jsp"></jsp:include>
<jsp:include page="../head/footer.jsp"></jsp:include>
<link rel="stylesheet" href="css/intro.css">
<title>TI</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container" id="main-container">
    <div class="jumbotron" id="intro-jumbotron">
        <h1>最早玩的游戏</h1>
        <p class="text-primary">这就是我最早真正开始玩的游戏~可是现在却不玩了，都已经退出WCG了。</p>
        <h3>一些抱怨</h3>
        <p class="lead text-warning">哎~老婆不让玩游戏，好痛苦好痛苦啊~真的好想好想玩Halo, Diabllo还有Starcraft啊~<br />
        				老婆还不让看电影的说，想看个《星际穿越》都不让，可是她自己倒是去看得挺欢，而且还总是自己想要什么就给自己买什么，想做什么就让自己做什么，并且义正言辞的说：“我那些都是必须，你哪些不是的！你看《星际穿越》可以现在不看，以后随便找个便宜的电影看了满足一下就成了~”</p>
        <button type="button" class="btn transparent">进入</button>
    </div>
    <div id="roll-box">
    	<div id="wrap">
    		<div id="cube">
    			<!-- <div id="front">前</div>
    			<div id="back">后</div>
    			<div id="top">上</div>
    			<div id="bottom">下</div>-->
    			<div id="left">左</div> 
    			<div id="right">右</div>
    		</div>
    	</div>
    </div>
    
    <div id="transform-test">
        <div id="testDiv"></div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>