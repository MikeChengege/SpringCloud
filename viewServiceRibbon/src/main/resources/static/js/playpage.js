
$(function () {
    $("#right").remove();
    $("#left").remove();
    var url = decodeURI(window.location.search);
    var indexofdeng = url.indexOf("=");
    var indexofend = url.indexOf("&");
    var name = url.substring(indexofdeng+1,indexofend);
    document.title=name;
    var newurl = url.substring(indexofend,url.length);
    var videoid = newurl.indexOf("=");
    videoid = newurl.substring(videoid+1,newurl.length);
    var videotype;
    $.ajax({
        type:"POST",
        url:"/getVideoById",
        data:{"id":videoid},
        async: false,
        success:function (data) {
            $("#descript").html(data.video_descript)
            $("#hadvisit").html(data.video_hadvisit)
            $("#like").html(" "+data.video_like)
            $("#dislike").html(" "+data.video_dislike)
            $("#talktitle").html(data.video_comment)
            $("#videoaddress").attr("src",data.video_address);
            $("#downloadvid").attr("href",data.video_address);
            // $("#playtxt > a[href]").attr("href",data.video_address);
            videotype = data.video_type;

        }
    })
    var userid= $("#userid").val();
    if(userid!=undefined){
        var visdata={
            "videoid":videoid,
            "userid":userid
        }
        $.ajax({
            type:"POST",
            url:"/addHadView",
            data:visdata,
            success:function (data) {
                if(data.msg!="success"){
                    alert(data.msg);
                }
            },
            error:function () {
                alert("游览记录插入失败");
            }

        })
    }


    var limit = 4;
    var data = {
        "videotype":videotype,
        "limit" : limit
    }
    var j=0;
    $.ajax({
        type:"POST",
        url:"/getNextVideo",
        data:data,
        async: false,
        success:function (nexfilm) {
            j = nexfilm.length-1;
            $.each(nexfilm,function(i,val) {
                if(val.id==videoid||val==null){
                    return true;
                }
                var html="<a href='/Mosttv/playbackpage?name="+val.video_title+"&id="+val.id+"'> <div class=\"thumeMostsee\"><div class=\"pic\">"
                html+="<img src="+val.video_pic+" style=\" width: 170px; height: 100px;\"/></div><div class=\"mostseeTxt\">"
                html+="<span class=\"txt1\" style=\"font-weight:bold\">"+val.video_title+"</span><br/>"
                html+="<span class=\"txt2\" style=\"color: #606060\">"+val.video_peop+"</span><br/>"
                html+="<span class=\"txt3\" style=\"color: #606060\">"+val.video_hadvisit+"</span>万 次观看</div></div></a>"
               if(i==j){
                   html+="<hr style=\"height:1px;border:none;border-top:1px solid  #dcdcdc;\" />"
               }
                $("#rightBottom").prepend(html);
            })
        }
    })
    function likeClick(){
        $("#like").click(function () {
            if($(this).attr("style")=="margin-left:30%;font-weight: bold; width: 80px;cursor:pointer"){
                var oldlike = $(this).text();
                var newlike = parseInt(oldlike)+1;
                $(this).html(" "+newlike);
                $("#dislike").unbind("click");
                $(this).attr("style","margin-left:30%;font-weight: bold; width: 80px;cursor:pointer;color: red");
            }else if($(this).attr("style")=="margin-left:30%;font-weight: bold; width: 80px;cursor:pointer;color: red"){
                var oldlike = $(this).text();
                var newlike = parseInt(oldlike)-1;
                $(this).html(" "+newlike);
                $("#dislike").bind("click",disLikeClick())
                $(this).attr("style","margin-left:30%;font-weight: bold; width: 80px;cursor:pointer");
            }
            updatelike($(this).text(),$("#dislike").text(),videoid);
        })
    }
    function disLikeClick(){
        $("#dislike").click(function () {
            if($(this).text()<=0){
                alert("差评失败")
            }else if($(this).attr("style")=="font-weight: bold;width: 80px;cursor:pointer"){
                var olddislike = $(this).text();
                var newdislike = parseInt(olddislike)-1;
                $(this).html(" "+newdislike);
                $("#like").unbind("click");
                $(this).attr("style","font-weight: bold;width: 80px;cursor:pointer;color: red");
            }else if($(this).attr("style")=="font-weight: bold;width: 80px;cursor:pointer;color: red"){
                var olddislike = $(this).text();
                var newdislike = parseInt(olddislike)+1;
                $(this).html(" "+newdislike);
                $("#like").bind("click",likeClick());
                $(this).attr("style","font-weight: bold;width: 80px;cursor:pointer");
            }
            updatelike($("#like").text(),$(this).text(),videoid);
        })
    }
    $("#like").click(function () {
            if($(this).attr("style")=="margin-left:30%;font-weight: bold; width: 80px;cursor:pointer"){
                    var oldlike = $(this).text();
                    var newlike = parseInt(oldlike)+1;
                    $(this).html(" "+newlike);
                $("#dislike").unbind("click");
                $(this).attr("style","margin-left:30%;font-weight: bold; width: 80px;cursor:pointer;color: red");
            }else if($(this).attr("style")=="margin-left:30%;font-weight: bold; width: 80px;cursor:pointer;color: red"){
                var oldlike = $(this).text();
                var newlike = parseInt(oldlike)-1;
                $(this).html(" "+newlike);
                $("#dislike").bind("click",disLikeClick())
                $(this).attr("style","margin-left:30%;font-weight: bold; width: 80px;cursor:pointer");
            }

        updatelike($(this).text(),$("#dislike").text(),videoid);
    })
    $("#dislike").click(function () {
            if($(this).text()<=0){
                alert("差评失败")
            }else if($(this).attr("style")=="font-weight: bold;width: 80px;cursor:pointer"){
                    var olddislike = $(this).text();
                    var newdislike = parseInt(olddislike)-1;
                    $(this).html(" "+newdislike);
                    $("#like").unbind("click");
                    $(this).attr("style","font-weight: bold;width: 80px;cursor:pointer;color: red");
            }else if($(this).attr("style")=="font-weight: bold;width: 80px;cursor:pointer;color: red"){
                var olddislike = $(this).text();
                var newdislike = parseInt(olddislike)+1;
                $(this).html(" "+newdislike);
                $("#like").bind("click",likeClick());
                $(this).attr("style","font-weight: bold;width: 80px;cursor:pointer");
            }
        updatelike($("#like").text(),$(this).text(),videoid);
    })
    function updatelike(like,dislike,videoid){
        like = parseInt(like);
        dislike = parseInt(dislike);
        videoid = parseInt(videoid);
        var data={
            "like":like,
            "dislike":dislike,
            "videoid":videoid
        }
        $.ajax({
            type:"post",
            url:"/updateLike",
            data:data,
            async:false,
            success:function (data) {
                if(data==false){
                    alert("点赞失败！")
                }
            },
            field:function () {
                alert("点赞失败！")
            }
        })
    }
    $("#share").click(function () {
        var content = "127.0.0.1:8012/Mosttv/playbackpage"+url;
        var clipboard = new Clipboard('#share', {
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
    $("#canDownload").click(function () {
    })
    $("#candnDownload").click(function () {
        var d = confirm("请先登录!")
        if(d==true){
            window.location.href = "/Mosttv/login"
        }
    })
    $("video").bind("contextmenu",function(){//取消右键事件
        return false;
    });
    // $("#canDownload").click(function () {
    //     // video.webkitRequestFullScreen();
    // })

        $(".comminps").click(function () {
            var d = confirm("请先登录!")
            if(d==true){
                window.location.href = "/Mosttv/login"
            }

        })
        if($(".comminp").val()==""){
            $("#cancelbtn").attr("class","btn btn-default disabled");
            $("#confirmbtn").attr("onclick","null");
        }
        if($(".comminps").val()==""){
            $("#cancelbtn").attr("class","btn btn-default disabled");
            $("#confirmbtn").attr("onclick","null");
        }
        $(".comminp").keyup(function () {
            if($(".comminp").val()!=""){
                $("#cancelbtn").attr("class","btn btn-default");
                $("#confirmbtn").attr("class","btn btn-default");
                $("#confirmbtn").attr("onclick","confirclick()");
            }else{
                $("#cancelbtn").attr("class","btn btn-default disabled");
                $("#confirmbtn").attr("class","btn btn-default disabled");
                $("#confirmbtn").attr("onclick","null");
            }
        })
    $("#cancelbtn").click(function () {
        $(".comminp").val("");
        $("#cancelbtn").attr("class","btn btn-default disabled");
        $("#confirmbtn").attr("class","btn btn-default disabled");
        $("#confirmbtn").attr("onclick","null");
    })

    $.ajax({
        type:"POST",
        url :"/getVideoComm",
        data:{"id":videoid},
        async:false,
        success:function (data) {
            $("#talktitle").html(data.length);
            if(data==""){
                    $("#nocomm").attr("style","height: 300px");
            }else{
                $("#nocomm").attr("style","display: none;height: 300px");
            }
            data = JSON.stringify(data);
            data = JSON.parse(data).reverse();//为了评论反向输出，始终保持最新评论在前
            $.each(data,function (i,data) {
                var now = getNowTime();
                var hadtime= GetDateDiff(data.comt_time,now,"hour");
                var html="";
                if(data.user==null){
                    return true;
                }
                html+="<div  class=\"othertalk\"><div class=\"otherpic\"><img src="+data.user.photo+" class=\"img-circle\" style=\"width: 40px;height: 40px\"></div>";
                html+="<div class=\"otherright\"><span class=\"talkname\" style=\"font-weight: bold\">"+data.user.username+"</span>"
                html+="<span class=\"talkname\" style=\"color: #606060\"> &nbsp;&nbsp;"+hadtime+" 小时前</span>"
                html+="<br><span class=\"talkname\">"+data.comt_content+"</span><br>"
                html+="<span id='comm"+i+"' onclick='commlike("+data.id+","+i+")' class=\"glyphicon glyphicon-thumbs-up\" style=\"color: #606060;font-weight: bold; width: 80px;margin-top: 10px;cursor:pointer\">  "+data.comt_liked+"</span>"
                // html+="<span class=\"glyphicon glyphicon-thumbs-down\" style=\"color: #606060;font-weight: bold;width: 80px\">  "+data.comt_dislike+"</span>"
                html+="<span class=\"talkname\" onclick='comrt("+i+")' id='comrt"+data.id+"' style=\"margin-top: 10px;color: #606060;cursor:pointer\">回复</span><br></div></div>";
                html+="<span  id='comrt"+i+"'>"
                $("#commcontent").prepend(html);
            })
        }
    })
    $("#subcomm").click(function () {
        var data={
            "video_id":videoid,
            "user_id":$("#userid").val(),
            "comt_content":$(".comminp").val(),
            "comt_time":getNowTime().toString()
        }
        $.ajax({
            type:"POST",
            url :"/addComment",
            data:data,
            async:false,
            success:function (data) {
                if(data.msg=="success"){
                    // $("#playtxt").load(location.href+" #playtxt");
                    // window.location.reload();
                    location.reload();
                }
            }
        })
    })
    var data = {
        "userid":$("#userid").val(),
        "videoid":videoid
    }
    $.ajax({
        type:"POST",
        url :"/findColled",
        async:false,
        data:data,
        success:function (data) {
            if(data.msg=="success"){
                $("#collection").attr("style","cursor:pointer;color: red")
            }else{
                $("#collection").attr("style","cursor:pointer;")
            }
        },
        error:function () {
            alert("凉凉");
        }
    })
    $("#collection").click(function () {
        var data = {
            "userid":$("#userid").val(),
            "videoid":videoid
        }
        if($(this).attr("style")=="cursor:pointer;"){
            $(this).attr("style","cursor:pointer;color: red");
            $.ajax({
                type:"POST",
                url :"/addCollect",
                async:false,
                data:data,
                success:function (data) {
                    if(data.msg!="success"){
                        alert(data.msg);
                    }
                },
                error:function () {
                    alert("凉凉");
                }
            })
        }else if($(this).attr("style")=="cursor:pointer;color: red"){
            $(this).attr("style","cursor:pointer;");
            $.ajax({
                type:"POST",
                url :"/deleteCollect",
                async:false,
                data:data,
                success:function (data) {
                    if(data.msg!="success"){
                        alert("取消失败啦");
                    }
                },
                error:function () {
                    alert("你是不是没得网");
                }
            })
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
function confirclick() {
    var commcontent = $(".comminps").val();

    if(commcontent!=""){
        $("#subcomm").click();
    }else{
        alert("请输入内容！");
    }
}
function commlike(id,i) {
    if($("#comm"+i).attr("style")=="color: #606060;font-weight: bold; width: 80px;margin-top: 10px;cursor:pointer"){
        var oldlike = $("#comm"+i).text();
        var newlike = parseInt(oldlike)+1;
        $("#comm"+i).html(" "+newlike);
        $("#comm"+i).attr("style","color: #606060;font-weight: bold; width: 80px;margin-top: 10px;cursor:pointer;color: red");
    }else if($("#comm"+i).attr("style")=="color: #606060;font-weight: bold; width: 80px;margin-top: 10px;cursor:pointer;color: red"){
        var oldlike = $("#comm"+i).text();
        var newlike = parseInt(oldlike)-1;
        $("#comm"+i).html(" "+newlike);
        $("#comm"+i).attr("style","color: #606060;font-weight: bold; width: 80px;margin-top: 10px;cursor:pointer");
    }
    var data = {
        "id":id,
        "comt_liked":$("#comm"+i).text()
    }
    $.ajax({
        type:"POST",
        url :"/updateHadLike",
        async:false,
        data:data,
        success:function (data) {
        },
        error:function () {
          alert("凉凉");
        }
    })
}

function comrt(id) {
    var html="<div id='subDiv' class=\"input-group\"><input type=\"text\" class=\"form-control\"placeholder=\"请输入。。。\"><span class=\"input-group-btn\"><button id='subBtn' class=\"btn btn-default\" type=\"button\">提交</button></span>";
    html+="</div>"
    $("#comrt"+id).prepend(html);

    $("#subBtn").click(function () {
        $("#subDiv").remove();  
    })
}
