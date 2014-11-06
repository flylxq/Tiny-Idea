/**
 * 
 */
$(function(){
    $("#logoutLink").confirm({
        text: "确定要退出么？",
        title: "确认",
        confirm: function(button){
            alert("confirm");
        },
        cancel: function(button){
            alert("cancel");
        },
        confirmButton: "退出",
        cancelButton: "取消",
        post: true
    });
});