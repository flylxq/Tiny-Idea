<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">TinyIdea</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">TinyIdea</a>
        </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="#">资讯</a></li>
                <li><a href="http://localhost:8080/TinyIdea/intro.html" target="_blank">我们</a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right" id="navbar_login_ul">
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</div>

<textarea id="temple_author" style="display:none">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="username-link"></a>
        <ul class="dropdown-menu" role="menu">
            <li><a href="#">用户中心</a></li>
            <li><a href="#">我的收藏</a></li>
            <li><a href="#">帮助</a></li>
            <li class="divider"></li>
            <li><a href="#" id="logoutLink" class="confirm">注销</a></li>
        </ul>
    </li>
</textarea>
<textarea id="temple_none" style="display:none">
    <li><a href="#" data-toggle="modal" data-target="#loginModal">登录</a></li>
    <li><a href="#" data-toggle="modal" data-target="#signModal">注册</a></li>
</textarea>

<!-- Login Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-md">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">登录</h4>
            </div>
            <div class="modal-body">
                <div class="form-horizontal">
                    <div class="form-group">
                        <div class="col-sm-12 alert alert-danger" id="login-danger-alert" style="display:none">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="login-username" class="col-sm-3 control-label">用户名:</label>
                        <div class="col-sm-9">
                            <input type="email" class="form-control" id="login-username" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="login-password" class="col-sm-3 control-label">密码:</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="login-password" placeholder="Password" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class='col-sm-offset-3 col-sm-9'>
                            <label>
                                <input id="login-remember" type="checkbox" />&nbsp记住我一个月
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="login-confirm">登录</button>
            </div>
        </div>
    </div>
</div>

<!-- Sign Modal -->
<div class="modal fade" id="signModal" tabindex="-1" role="dialog" aria-labelledby="signLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">注册</h4>
            </div>
            <div class="modal-body form-horizontal">
                <div class="form-group">
                    <label for="username" class="col-sm-3 control-label">用户名:</label>
                        <div class="col-sm-9">
                            <input type="email" class="form-control" id="sign-username" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-3 control-label">密码:</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="sign-password" placeholder="Password" />
                        </div>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="sign-btn">注册</button>
            </div>
        </div>
    </div>
</div>

