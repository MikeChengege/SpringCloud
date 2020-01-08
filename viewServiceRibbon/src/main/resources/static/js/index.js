
$(function () {
    $("#shouye").click(function () {
        window.location.href="/Mosttv/index";
    })
    $("#hadlogintext").click(function () {
        window.location.href="/Mosttv/login?name="+$("#userid").val();
    })
    $(function () {
        $("#left").mouseover(function(){
            $("#left").attr("style","overflow:auto;overflow-y:auto;position: absolute;height: 100%;");
        });

        $("#left").mouseleave(function(){
            $("#left").attr("style","overflow:auto;");
        });
        $("[data-toggle='tooltip']").tooltip();
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
        $.ajax({
            type:"post",
            url:"/getVideoInf",
            data:"",
            async: false,
            success:function (data) {
                var a=0;
                var b=0;
                $.each(data,function (i,data) {
                    if(data.lvs==null){
                        return true;
                    }
                    if(data.lvs.video_hot==1){
                        var now = getNowTime();
                        var hadtime= GetDateDiff(data.video_time,now,"hour");
                        a++;
                        var html="<div class=\"thume\" onclick='intoPlayPage("+data.id+",\""+data.video_title+"\")' style=\"cursor: pointer\"><div class=\"thumeTop\">";
                        html+="<img src="+data.video_pic+"  style=\"width: 210px; height: 120px;\"/></div><div class=\"thumeCanent\">"
                        html+="<span class=\"txt1\" style=\"font-weight:bold\">"+data.video_title+"</span></div><div class=\"thumeBelow\">"
                        html+="<span class=\"txt2\" style=\"color: #606060\">"+data.video_peop+"</span><br/>"
                        html+="<span class=\"txt2\" style=\"color: #606060\">"+data.video_hadvisit+" 次观看,"+hadtime+" 小时前</span></div></div>"
                        if(a==4){
                            $("#indexmostsee").prepend(html)
                            return false;
                        }
                        $("#indexmostsee").prepend(html)
                    }
                })
                $.each(data,function (i,data) {
                    if(data.lvs==null){
                        return true;
                    }
                    if(data.lvs.video_hot==2&&data.video_type==2){
                        var now = getNowTime();
                        var hadtime= GetDateDiff(data.video_time,now,"hour");
                        b++;
                        var html="<div class=\"thume\" onclick='intoPlayPage("+data.id+",\""+data.video_title+"\")' style=\"cursor: pointer\"><div class=\"thumeTop\">";
                        html+="<img src="+data.video_pic+" style=\"width: 210px; height: 120px;\"/></div><div class=\"thumeCanent\">"
                        html+="<span class=\"txt1\" style=\"font-weight:bold\">"+data.video_title+"</span></div><div class=\"thumeBelow\">"
                        html+="<span class=\"txt2\" style=\"color: #606060\">"+data.video_peop+"</span><br/>"
                        html+="<span class=\"txt2\" style=\"color: #606060\">"+data.video_hadvisit+" 次观看,"+hadtime+" 小时前</span></div></div>"
                        if(b==4){
                            $("#indexustvv").prepend(html)
                            return false;
                        }
                        $("#indexustvv").prepend(html)
                    }
                })
            }
        })
    })
    var url = decodeURI(window.location.search);
    $("#sharehap").click(function () {
        var content = "http://106.13.77.233:8080/MostTV/playbackpage"+url;
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
    $("#searchbtn").click(function () {
        if($("#searchinp").val()==""){
            alert("请输入搜索内容")
        }else {
            window.location.href="searchpage?secont="+$("#searchinp").val();
        }
    })
})
$(function () {
    $("#submit").click(function(){
        var uid = $("#userid").val();
        var data={
            "advtext":$("#advtext").val(),
            "user_id":uid
        }
        if(uid==undefined){
            alert("请登录后再反馈！")
        }else{
            $.ajax({
                type:"POST",
                url:"/submitAdvice",
                data:data,
                async: false,
                success:function (data) {
                    if(data.msg=="success"){
                        alert("反馈成功！");
                    }else {
                        alert(data.msg);
                    }
                }
            })
        }




        $("#myModal").modal('hide');
        window.location.reload();
    });
})
function intoPlayPage( id,name) {
    window.location.href="playbackpage?name="+name+"&id="+id;
}