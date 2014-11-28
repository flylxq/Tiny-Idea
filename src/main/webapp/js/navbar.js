/**
 * 
 */
$(function(){
    userInfo['username'] = $.cookie("username");
    userInfo['userId'] = $.cookie("userId");
    if(userInfo['userId']){
        loginedObject.init();
    } else {
        unloginedObject.init();
    }
});

var userInfo = {}

var unloginedObject = {
    init: function(){
        $("#navbar_login_ul").html($("#temple_none").text());
        
        $("#login-confirm").click(function(){
            var username = $("#login-username").val();
            if(null == username || username.length < 5){
                $("#login-danger-alert").html("请输入正确的<strong>用户名</strong>!");
                $("#login-username").focus();
                $("#login-danger-alert").css("display", "block");
                return;
            }
            
            var password = $("#login-password").val();
            if(null == password || password.length < 5){
                $("#login-danger-alert").html("请输入正确的<strong>密码</strong>！");
                $("#login-password").focus();
                $("#login-danger-alert").css("display", "block");
                return;
            }
            
            var remember = false;
            if($("#login-remember").is(":checked")){
                remember = true;
            }
            
            password = md5(password);
            $.ajax({
                url: "http://localhost:8080/TinyIdea/login.do?action=login",
                method: "POST",
                dataType: "json",
                data: {username: username, password: password, remember: remember},
                success: function(data){
                    if(data['status'] == "OK"){
                        userInfo['username'] = data['data']['username'];
                        userInfo['userId'] = data['data']['userId'];
                        
                        loginedObject.init();
                        $("#loginModal").modal("hide");
                    } else {
                        var msg = data['msg'];
                        if(msg == 'The username does not already exist!'){
                            $("#login-danger-alert").html("<strong>用户名</strong>不存在！");
                        } else if(msg == 'The username or password is not correct!'){
                            $("#login-danger-alert").html("<strong>用户名</strong>或<strong>密码</strong>错误！");
                        } else {
                            $("#login-danger-alert").html("未知错误！");
                        }
                        $("#login-username").focus();
                        $("#login-danger-alert").css("display", "block");
                    }
                },
                error: function(jqXHR, status, errorThrown){
                    alert(status + ":" + errorThrown);
                    swal("Error", status + ":" + errorThrown, "error");
                }
            });
        });
        
        $("#sign-btn").click(function(){
            var username = $("#sign-username").val();
            if(null == username || username.length < 5){
                swal("错误！", "用户名长度不得小于5个字符", "error");
                return;
            }
            
            var password = $("#sign-password").val();
            if(null == password || password.length < 5){
                swal("错误", "密码长度不得少于5个字符.", "error");
                return;
            }
            password = md5(password);
            $.ajax({
                url: "http://localhost:8080/TinyIdea/login.do?action=sign",
                method: "POST",
                dataType: "json",
                data: {password: password, username: username},
                success: function(data){
                    if(data['status'] != "OK"){
                        swal("错误！", data['msg'], "error");
                        return;
                    } else {
                        $("#navbar_login_ul").html($("#temple_author").text());
                        
                    }
                    $("#signModal").modal("hide");
                },
                error:function(jqXHR, status, errorThrow){
                    alert(status + ":" + errorThrow);
                }
            });
        });
        
        $("#login-username, #login-password").change(function(){
            $("#login-danger-alert").html("");
            $("#login-danger-alert").css("display", "none");
        });
        
        $("#loginModal").on("hidden.bs.modal", function(e){
            $("#login-username").val("");
            $("#login-password").val("");
            $("#login-remember").prop("checked", false);
        });
        
        $("#loginModal").on("shown.bs.modal", function(e){
            $(document).keydown(function(event){
                if(event.keyCode == 13){
                    $("#login-confirm").trigger("click");
                }
            });
        });
        
        $("#signModal").on("hidden.bs.modal", function(e){
            $("#sign-username").val("");
            $("#sign-password").val("");
        });
        
    }
}

var loginedObject = {
    init: function(){
        $("#navbar_login_ul").html($("#temple_author").text());
        
        $("#username-link").html(userInfo['username'] + "<span class='caret'></span>");
        
        $("#logoutLink").click(function(){
            swal({
                title: "警告",
                text: "确定注销？",   
                type: "warning",   
                showCancelButton: true,   
                confirmButtonColor: "#DD6B55",   
                confirmButtonText: "注销",   
                cancelButtonText: "取消",   
                closeOnConfirm: true,   
                closeOnCancel: true 
                }, 
                function(isConfirm){   
                    if (isConfirm) {     
                        $.removeCookie("username");
                        $.removeCookie("userId");
                        
                        unloginedObject.init();
                    }
             });
        });
    }
};