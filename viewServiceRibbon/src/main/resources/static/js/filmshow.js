$(function () {
    $.ajax({
        type:"POST",
        url :"/getAllFilm",
        async:false,
        success:function (data) {
            var a=0;
            var b=0;
            var c=0;
            var d=0;
            // data = JSON.stringify(data);
            // data = JSON.parse(data).reverse();//为了反向输出，始终保持游览量最高在前面
            $.each(data,function (i,item) {
                    if(item.lvs!=null){
                        a++;
                        var html="<div class=\"tvshowpic\" onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")'  style=\"margin-left: 3px;cursor: pointer\"><div class=\"picBig\"><a href=\"#\">";
                        html+="<img src="+item.video_pic+" style=\" width: 200px; height: 280px;\"/>"
                        html+="<span class=\"badge\" style=\"float: right\">"+item.lvs.video_score+"</span>"
                        html+="</div><div class=\"simtxt\"><span>"+item.video_title+"</span></div></div>"
                        if(a==4){
                            $(".tvshowpic").attr("style","cursor: pointer");
                            $("#mosthot").prepend(html)
                            return false;
                        }
                        $("#mosthot").prepend(html)
                    }
            })
            $.each(data,function (i,item) {
                    if(item.lvs!=null){
                        b++;
                        if(item.lvs.video_videotype=="科幻类"){
                            var html="<div class=\"tvshowpic\" onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")' style=\"margin-left: 3px;cursor: pointer\"><div class=\"picBig\"><a href=\"#\">";
                            html+="<img src="+item.video_pic+" style=\" width: 200px; height: 280px;\"/>"
                            html+="<span class=\"badge\" style=\"float: right\">"+item.lvs.video_score+"</span>"
                            html+="</div><div class=\"simtxt\"><span>"+item.video_title+"</span></div></div>"
                            if(b==4){
                                $(".tvshowpic").attr("style","cursor: pointer");
                                $("#science").prepend(html)
                                return false;
                            }
                            $("#science").prepend(html)
                        }
                    }
            })
            $.each(data,function (i,item) {
                    if(item.lvs!=null){
                        c++;
                        if(item.lvs.video_videotype=="剧情类"){
                            var html="<div class=\"tvshowpic\" onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")' style=\"margin-left: 3px;cursor: pointer\"><div class=\"picBig\"><a href=\"#\">";
                            html+="<img src="+item.video_pic+" style=\" width: 200px; height: 280px;\"/>"
                            html+="<span class=\"badge\" style=\"float: right\">"+item.lvs.video_score+"</span>"
                            html+="</div><div class=\"simtxt\"><span>"+item.video_title+"</span></div></div>"
                            if(c==4){
                                $(".tvshowpic").attr("style","cursor: pointer");
                                $("#thestory").prepend(html)
                                return false;
                            }
                            $("#thestory").prepend(html)
                        }
                    }
            })
            $.each(data,function (i,item) {
                    if(item.lvs!=null){
                        d++;
                        if(item.lvs.video_videotype=="奇幻类"){
                            var html="<div class=\"tvshowpic\" onclick='intoPlayPage("+item.id+",\""+item.video_title+"\")' style=\"margin-left: 3px;cursor: pointer\"><div class=\"picBig\"><a href=\"#\">";
                            html+="<img src="+item.video_pic+" style=\" width: 200px; height: 280px;\"/>"
                            html+="<span class=\"badge\" style=\"float: right\">"+item.lvs.video_score+"</span>"
                            html+="</div><div class=\"simtxt\"><span>"+item.video_title+"</span></div></div>"
                            if(d==4){
                                $(".tvshowpic").attr("style","cursor: pointer");
                                $("#fantasy").prepend(html)
                                return false;
                            }
                            $("#fantasy").prepend(html)
                        }
                    }
            })
        }
    })
})
function intoPlayPage( id,name) {
    window.location.href="playbackpage?name="+name+"&id="+id;
}