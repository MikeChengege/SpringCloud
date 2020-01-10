$(function () {
    $.ajax({
        type:"post",
        url:"/getBaseinfomation",
        data:{"username":$("#nickname").val()},
        async:false,
        dataType : "json",
        success:function (us) {
            $.each(us,function (i,item) {
                if(("nickname")==i){
                    $("#nickname").val(item);
                }else if(("telephone")==i){
                    $("#telephone").val(item);
                }else if(i==("email")){
                    $("#email").val(item);
                }else if(i==("regdate")){
                    $("#registerdate").val(item);
                }else if(i==("id")){
                    $("#numbervip").html(item);
                }else if(i==("password")){
                    $("#password").val(item);
                }else if(i==("photo")){
                    $("#infpic img").attr("src",item);
                }
            })
        }
    })

    $("#sharehap").click(function () {
        var content = "http://127.0.0.1:8012/Mosttv/index";
        var clipboard = new Clipboard('#sharehap', {
            text: function() {
                return content;
            }
        });
        clipboard.on('success', function(e) {
            alert("已经复制到剪切板，请自由分享！");
        });
        clipboard.on('error', function(e) {
            console.log(e);
        });
    })
    $("#mycollection").show();
    $("#personalinformation_left").hide();
    $("#userhadseediv").hide()
    $("#myvideo").hide()


    $("#mycollectionlist").click(function () {
        $("#mycollection").show();
        $("#personalinformation_left").hide();
        $("#myvideo").hide()
        $("#userhadseediv").hide();
    })
    $("#personalinformationlist").click(function () {
        $("#mycollection").hide();
        $("#personalinformation_left").show();
        $("#myvideo").hide()
        $("#userhadseediv").hide();
    })
    $("#userhadsee").click(function () {
        $("#mycollection").hide();
        $("#personalinformation_left").hide();
        $("#myvideo").hide();
        $("#userhadseediv").show();
    })
    $("#myvideolist").click(function () {
        $("#mycollection").hide();
        $("#personalinformation_left").hide();
        $("#myvideo").show();
        $("#userhadseediv").hide();
    })

    $("#nickname").keyup(function(){
        if( $("#nickname").val() == ""){
            $("#namespan").html("用户名不能为空");
            return;
        }else {
            $.ajax({
                type : "POST",
                url  : "/loginVerification/Verification",
                data : {username : $("#nickname").val()},
                success : function(data){
                    for (var key in data)
                    {
                        if(data[key]=="success"){
                            $("#namespan").html("可以使用");
                        }else if(data[key]=="error"){
                            $("#namespan").html("不能使用");
                        }
                    }
                },
                error : function() {
                    alert("出问题啦");
                },
            });
        }

    });


    $("#subinfo").click(function () {
      var data={
          "id" :$("#numbervip").text(),
          "username" :$("#nickname").val(),
          "password" :$("#password").val(),
          "telephone": $("#telephone").val(),
          "email":  $("#email").val()
      }
      $.ajax({
          type:"post",
          url:"/updateUserInfo",
          data:data,
          async:false,
          success:function (data) {
              if(data.msg=="success"){
                  alert("修改成功")
                  window.location.href="/Mosttv/Cancellation";
              }else {
                  alert(data.msg);
              }
          }
      })
        $("#nickname").val( $("#udanickname").val());
        $("#telephone").val( $("#uptelephone").val());
        $("#email").val( $("#upemail").val());
        $("#myModal").modal('hide');
    })
    $("[data-toggle='tooltip']").tooltip();
    $("#btnnickname").click(function () {
        $("#subinfo").attr("style","");
        $("#cancelinfo").attr("style","");
        $("#nickname").removeAttr("readonly")
        $("#nickname").attr("style","");
        $("#password").removeAttr("readonly")
        $("#password").attr("style","");
        $("#telephone").removeAttr("readonly")
        $("#telephone").attr("style","");
        $("#email").removeAttr("readonly")
        $("#email").attr("style","");
    })
    $("#cancelinfo").click(function () {
        $("#subinfo").attr("style","display: none;");
        $("#cancelinfo").attr("style","display: none;");
        $("#nickname").attr("readonly","readonly");
        $("#nickname").attr("style","border: 0px;outline:none;cursor: pointer;");
        $("#password").attr("readonly","readonly");
        $("#password").attr("style","border: 0px;outline:none;cursor: pointer;");
        $("#telephone").attr("readonly","readonly");
        $("#telephone").attr("style","border: 0px;outline:none;cursor: pointer;");
        $("#email").attr("readonly","readonly");
        $("#email").attr("style","border: 0px;outline:none;cursor: pointer;");
    })
    $("#changePic").click(function () {
        $("#leftinfo").hide();
        $("#imglist").attr("style","width: 800px;cursor: pointer");
        $("#infpic").attr("style","width: 800px");
        $("#changePic").hide();
        $("#changePics").attr("style","float: bottom");
    })
    $("#changePics").click(function () {
        var data={
            "photo":$("#infpic img").attr("src"),
            "id":$("#numbervip").text()
        }
        $.ajax({
            type:"post",
            url:"/updateUserPhoto",
            data:data,
            async:false,
            success:function (data) {
                if(data.msg=="success"){
                    window.location.reload()
                }else {
                    alert(data.msg);
                }
            }
        })
    })
    if($("#numbervip").text()==""){
        window.location.href="/Mosttv/index";
    }
    $.ajax({
        type:"POST",
        url :"/userCollection",
        data:{"id":$("#numbervip").text()},
        async:false,
        success:function (data) {
            if(data.msg!=null&&data.msg!="error"){
                var a=0;
                $.each(data.msg,function (i,item) {
                    var now = getNowTime();
                    var hadtime= GetDateDiff(item.video_time,now,"hour");
                            a++;
                            var html="<div class=\"thume\" onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")' style=\"cursor: pointer\"><div class=\"thumeTop\">";
                            html+="<img src="+item.video_pic+" style=\"width: 210px; height: 120px;\"/></div><div class=\"thumeCanent\">"
                            html+="<span class=\"txt1\" style=\"font-weight:bold\">"+item.video_descript+"</span></div><div class=\"thumeBelow\">"
                            html+="<span class=\"txt2\" style=\"color: #606060\">"+item.video_peop+"</span><br/>"
                            html+="<span class=\"txt2\" style=\"color: #606060\">"+item.video_hadvisit+" 次观看,"+hadtime+" 小时前</span></div></div>"
                            if(a==4){
                                $("#collect").prepend(html)
                                return false;
                            }
                            $("#collect").prepend(html)
                })
            }
        }
    })
    $.ajax({
        type:"POST",
        url :"/userUpdateVideo",
        data:{"id":$("#numbervip").text()},
        async:false,
        success:function (data) {
            // alert(JSON.stringify(data));
            if(data.msg!=null&&data.msg!="error"){
                var a=0;
                $.each(data.msg,function (i,item) {
                    var now = getNowTime();
                    var video_time= item.video_time.substring(0,9);
                            a++;
                            var html="<div class=\"thume\"style=\"cursor: pointer\"><div onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")' class=\"thumeTop\">";
                            html+="<img src="+item.video_pic+" style=\"width: 210px; height: 120px;\"/></div><div class=\"thumeCanent\">"

                            // html+="<span class=\"txt1\" id=\"title"+a+"\" style=\"font-weight:bold\">"+item.video_title+"</span></div><div class=\"thumeBelow\">"
                            html+="<input onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")' class=\"txt1\" readonly='readonly'  id=\"title"+a+"\" style=\"font-weight:bold;border: 0;cursor:pointer\" value=\""+item.video_title+"\" /></div><div onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")'  class=\"thumeBelow\">"

                            html+="<span class=\"txt2\" style=\"color: #606060\">发布于 "+video_time+"</span><br/>"
                            html+="<span class=\"txt2\" style=\"color: #606060\">"+item.video_hadvisit+" 次观看</span></div>"
                            html+="<button type=\"button\" onclick='updateVideoTitle("+item.id+","+a+")' class=\"btn btn-warning btn-xs\">修改</button>&nbsp"
                            html+="<button type=\"button\" onclick='deleteUploadVideo("+item.id+")' class=\"btn btn-danger btn-xs\">删除</button></div>"
                            $("#userupload").prepend(html)
                })
            }
        }
    })
    $.ajax({
        type:"POST",
        url :"/getHadView",
        data:{"id":$("#numbervip").text()},
        async:false,
        success:function (data) {
            if(data.msg!=null&&data.msg!="error"&&data.msg!="null"){
                $.each(data.msg,function (i,item) {
                    var now = getNowTime();
                    var hadtime= GetDateDiff(item.video_time,now,"hour");
                    var html="<div class=\"thume\" onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")' style=\"cursor: pointer\"><div class=\"thumeTop\">";
                    html+="<img src="+item.video_pic+" style=\"width: 210px; height: 120px;\"/></div><div class=\"thumeCanent\">"
                    html+="<span class=\"txt1\" style=\"font-weight:bold\">"+item.video_descript+"</span></div><div class=\"thumeBelow\">"
                    html+="<span class=\"txt2\" style=\"color: #606060\">"+item.video_peop+"</span><br/>"
                    html+="<span class=\"txt2\" style=\"color: #606060\">"+item.video_hadvisit+" 次观看,"+hadtime+" 小时前</span></div></div>"
                    $("#userhadseedivs").prepend(html)
                })
            }
        }
    })
    function GetDateDiff(startTime, endTime, diffType) {
        //将xxxx-xx-xx的时间格式，转换为 xxxx/xx/xx的格式
        startTime = startTime.replace(/\-/g, "/");
        endTime = endTime.replace(/\-/g, "/");
        //将计算间隔类性字符转换为小写
        diffType = diffType.toLowerCase();
        var sTime =new Date(startTime); //开始时间
        var eTime =new Date(endTime); //结束时间
        //作为除数的数字
        var timeType =1;
        switch (diffType) {
            case"second":
                timeType =1000;
                break;
            case"minute":
                timeType =1000*60;
                break;
            case"hour":
                timeType =1000*3600;
                break;
            case"day":
                timeType =1000*3600*24;
                break;
            default:
                break;
        }
        return parseInt((eTime.getTime() - sTime.getTime()) / parseInt(timeType));
    }
    function getNow(s) {
        return s < 10 ? '0' + s: s;
    }
    function getNowTime(){
        var myDate = new Date();
        var year=myDate.getFullYear();
        var month=myDate.getMonth()+1;
        var date=myDate.getDate();
        var h=myDate.getHours();       //获取当前小时数(0-23)
        var m=myDate.getMinutes();     //获取当前分钟数(0-59)
        var s=myDate.getSeconds();
        var now=year+'-'+getNow(month)+"-"+getNow(date)+" "+getNow(h)+':'+getNow(m)+":"+getNow(s);
        return now;
    }
})
function changePic(id) {
        var ids = "#"+id;
        $("#infpic img").attr("src",$(ids).attr("src"));
}
function intoPlayPage( id,name) {
    window.location.href="playbackpage?name="+name+"&id="+id;
}
function updateVideoTitle(id,a) {
    var idin = "title"+a;
    $("#"+idin+"").attr("style","font-weight:bold;border: 1;")
    $("#"+idin+"").removeAttr("readonly")
    $("#"+idin+"").attr("onclick","");
    $("#"+idin+"").blur(function(){
        $("#"+idin+"").attr("onclick","intoPlayPage("+id+",'"+$("#"+idin+"").val()+"')")
        $("#"+idin+"").attr("readonly","readonly");
        $("#"+idin+"").attr("style","font-weight:bold;border: 0;cursor:pointer")
        var data={
            "id":id,
            "video_title":$("#"+idin+"").val()
        }
        $.ajax({
            type:"POST",
            url:"/updateVideo",
            data:data,
            success:function (data) {
                if(data.msg=="success"){
                    window.location.reload();
                }else {
                    alert(data.msg);
                }
            },
            error:function () {
                alert("修改失败")
            }
        })

    });
}
function deleteUploadVideo(id) {
    var d = confirm("确定删除吗？")
    if(d==true){
        $.ajax({
            type:"post",
            url:"/deleteVideo",
            data:{"id":id},
            success:function (data) {
                if(data.msg=="success"){
                    window.location.reload();
                }else{
                    alert(data.msg);
                }
            }
        })
    }
}
