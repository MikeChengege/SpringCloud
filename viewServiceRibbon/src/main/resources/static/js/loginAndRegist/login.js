$(function(){
    $("#btn_login").click(function(){
        $.ajax({
            type : "POST",
            url : "/Verification",
            async : false,
            data : { username :$("#username").val(),password : $("#password").val()},
            beforeSend : function() {
            },
            success : function(data) {
                for (var key in data)
                {
                    if(data[key]=="success"){
                        $("#namespan").html("密码正确");
                        window.location.href = "/MostTV/index"
                    }else if(data[key]=="error"){
                        $("#namespan").html("密码错误");
                    }else if(data[key]=="NoUser"){
                        $("#namespan").html("不存在该用户");
                    }
                }
            },
            error : function(data) {
            },
            dataType : "json"
        });
        return false;
    });
    $("#btn_register").click(function(){
        window.location.href="/MostTV/register";
        return false;
    });
    $("#btn_back").click(function(){
        window.location.href="/MostTV/index";
        return false;
    });
});