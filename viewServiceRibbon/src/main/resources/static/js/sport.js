$(function () {
    $.ajax({
        type:"POST",
        url :"/getAllSport",
        async:false,
        success:function (data) {
            var a=0;
            var b=0;
            var c=0;
            // data = JSON.stringify(data);
            // data = JSON.parse(data).reverse();//为了反向输出，始终保持游览量最高在前面
            $.each(data,function (i,item) {
                var now = getNowTime();
                var hadtime= GetDateDiff(item.video_time,now,"hour");
                    if(item.lvs!=null){
                        a++;
                        if(item.lvs.video_videotype=="最新"){

                            var html="<div class=\"thume\" onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")' style=\"cursor: pointer\"><div class=\"thumeTop\">";
                            html+="<img src="+item.video_pic+" style=\"width: 210px; height: 120px;\"/></div><div class=\"thumeCanent\">"
                            html+="<span class=\"txt1\" style=\"font-weight:bold\">"+item.video_descript+"</span></div><div class=\"thumeBelow\">"
                            html+="<span class=\"txt2\" style=\"color: #606060\">"+item.video_peop+"</span><br/>"
                            html+="<span class=\"txt2\" style=\"color: #606060\">"+item.video_hadvisit+" 次观看,"+hadtime+" 小时前</span></div></div>"
                            if(a==4){
                                $("#thenew").prepend(html)
                                return false;
                            }
                            $("#thenew").prepend(html)
                        }
                    }
            })
            $.each(data,function (i,item) {
                var now = getNowTime();
                var hadtime= GetDateDiff(item.video_time,now,"hour");
                    if(item.lvs!=null){
                        b++;
                        if(item.lvs.video_videotype=="热门"){
                            var html="<div class=\"thume\" onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")' style=\"cursor: pointer\"><div class=\"thumeTop\">";
                            html+="<img src="+item.video_pic+" style=\"width: 210px; height: 120px;\"/></div><div class=\"thumeCanent\">"
                            html+="<span class=\"txt1\" style=\"font-weight:bold\">"+item.video_descript+"</span></div><div class=\"thumeBelow\">"
                            html+="<span class=\"txt2\" style=\"color: #606060\">"+item.video_peop+"</span><br/>"
                            html+="<span class=\"txt2\" style=\"color: #606060\">"+item.video_hadvisit+" 次观看,"+hadtime+" 小时前</span></div></div>"
                            if(b==4){
                                $("#hotsee").prepend(html)
                                return false;
                            }
                            $("#hotsee").prepend(html)
                        }
                    }
            })
            $.each(data,function (i,item) {
                var now = getNowTime();
                var hadtime= GetDateDiff(item.video_time,now,"hour");
                    if(item.lvs!=null){
                        c++;
                        if(item.lvs.video_videotype=="高点击"){
                            var html="<div class=\"thume\" onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")' style=\"cursor: pointer\"><div class=\"thumeTop\">";
                            html+="<img src="+item.video_pic+" style=\"width: 210px; height: 120px;\"/></div><div class=\"thumeCanent\">"
                            html+="<span class=\"txt1\" style=\"font-weight:bold\">"+item.video_descript+"</span></div><div class=\"thumeBelow\">"
                            html+="<span class=\"txt2\" style=\"color: #606060\">"+item.video_peop+"</span><br/>"
                            html+="<span class=\"txt2\" style=\"color: #606060\">"+item.video_hadvisit+" 次观看,"+hadtime+" 小时前</span></div></div>"
                            if(c==4){
                                $("#muchclick").prepend(html)
                                return false;
                            }
                            $("#muchclick").prepend(html)
                        }
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
function intoPlayPage( id,name) {
    name = name.replace("]","");
    name = name.replace("[","");
    window.location.href="playbackpage?name="+name+"&id="+id;
}