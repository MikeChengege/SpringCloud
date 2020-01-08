$(function () {
    $.ajax({
        type:"POST",
        url:"/getRankinfo",
        async:false,
        success:function (data) {
            data = JSON.stringify(data);
            data = JSON.parse(data);
            /*data = JSON.parse(data).reverse();*/
            /*为了评论反向输出，始终保持最新评论在前*/
            var j=3;
            $.each(data,function (i,item) {
                var html="<div class=\"thume\" style=\"margin-left: 40px;cursor:pointer\" onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")'>"
                    html+="<span class=\"badge\">"+j+"</span>"
                    j--;
                    html+="<div class=\"thumeTop\"><img src="+item.video_pic+" style=\" width: 210px; height: 120px;\"/></div>"
                    html+="<div class=\"thumeCanent\"><span class=\"txt1\" style=\"font-weight:bold\">"+item.video_title+"</span></div><div class=\"thumeBelow\">"
                    html+="<span class=\"txt2\" style=\"color: #606060\">"+item.lvs.video_videotype+" /</span>"
                    html+="<span class=\"txt2\" style=\"color: #606060\"> "+item.lvs.video_playtype+" / </span>"
                    html+="<span class=\"txt2\" style=\"color: #606060\"> 更新日期："+item.lvs.video_updatetiem+"</span><br/>"
                    if(item.lvs.video_backtime==null||item.lvs.video_backtime==""){
                        html+="<span class=\"txt2\" style=\"color: #606060\">回归时间：暂无</span></div></div>"
                    }else{
                        html+="<span class=\"txt2\" style=\"color: #606060\">回归时间："+item.lvs.video_backtime+"</span></div></div>"
                    }
                    $("#rightTop").prepend(html);
            })
        }
    })
    var start = 1;
    $.ajax({
        type:"POST",
        url:"/getvideoPage",
        data:{"start":start},
        async:false,
        success:function (data) {
            var bottomHtml="<table class=\"table table-striped\" style=\"font-size: 12px\"><thead><th>排名</th><th>剧名</th><th>分类</th><th>状态</th><th>更新日期</th><th>回归时间</th></thead><tbody>";
            $.each(data.list,function (i,item) {
                var now = getNowTime();
                var hadtime= GetDateDiff(item.video_time,now,"day");
                if(i>2){
                    var x=parseInt(i)+1;
                    bottomHtml+="<tr style='cursor:pointer' onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")'><td>"+x+"</td><td>"+item.video_title+"</td>";
                    bottomHtml+="<td>"+item.lvs.video_videotype+"</td><td>"+item.lvs.video_playtype+"</td><td>"+item.lvs.video_updatetiem+"</td>";
                    if(item.lvs.video_backtime==null||item.lvs.video_backtime==""){
                        bottomHtml+="<td>暂无</td></tr>";
                    }else{
                        bottomHtml+="<td>"+hadtime+"天</td></tr>";
                    }
                    if(i>10){
                        return false;
                    }
                }
            })
            bottomHtml+="</tbody></table>";
            if(data.list==null||data.list==""){
                var  islast=false;
            }else {
                var  islast=true;
            }
            bottomHtml+="<nav><ul class=\"pager\"><li id='btnback' onclick='backaftpg("+start+")'><a href=\"#\">上一页</a></li><li id='btnaft' onclick='nextpg("+start+","+islast+")'><a href=\"#\">下一页</a></li></ul></nav>";

            $("#rightBottom").prepend(bottomHtml);
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
function intoPlayPage( id,name) {
    window.location.href="playbackpage?name="+name+"&id="+id;
}
function backaftpg(start) {
    $("#right").empty();
    start = parseInt(start);
    if(start>10){
        if(start==11){
            window.location.reload()
        }else{
            start = start-10;
            pagechange(start);
        }
    }else{
        $("#btnback").attr("class","disabled")
    }
}
function nextpg(start,data) {
    if(data){
        $("#rightTop").remove();
        $("#rightBottom").remove();
        $("#right").empty();
        var newst = parseInt(start)+10;
        pagechange(newst);
    }else{
        $("#btnaft").attr("class","disabled")
    }
}
function pagechange(start) {
    $.ajax({
        type:"POST",
        url:"/getvideoPage",
        data:{"start":start},
        async:false,
        success:function (data) {
            var x = start;
            var bottomHtml="<table class=\"table table-striped\" style=\"font-size: 12px\"><thead><th>排名</th><th>剧名</th><th>分类</th><th>状态</th><th>更新日期</th><th>回归时间</th></thead><tbody>";
            $.each(data.list,function (i,item) {
                var now = getNowTime();
                var hadtime= GetDateDiff(item.video_time,now,"day");
                    bottomHtml+="<tr onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")'  style='cursor:pointer'><td>"+x+"</td><td>"+item.video_title+"</td>";
                    bottomHtml+="<td>"+item.lvs.video_videotype+"</td><td>"+item.lvs.video_playtype+"</td><td>"+item.lvs.video_updatetiem+"</td>";
                    if(item.lvs.video_backtime==null||item.lvs.video_backtime==""){
                        bottomHtml+="<td>暂无</td></tr>";
                    }else{
                        bottomHtml+="<td>"+hadtime+"天</td></tr>";
                    }
                    if(i>10){
                    return false;
                    }
                x++;
                }
            )
            bottomHtml+="</tbody></table>";
            if(data.list==null||data.list==""){
                var  islast=false;
            }else {
                var  islast=true;
            }
            bottomHtml+="<nav><ul class=\"pager\"><li id='btnback' onclick='backaftpg("+start+")'><a href=\"#\">上一页</a></li><li id='btnaft' onclick='nextpg("+start+","+islast+")'><a href=\"#\">下一页</a></li></ul></nav>";
            $("#right").prepend(bottomHtml);
        }
    })
}