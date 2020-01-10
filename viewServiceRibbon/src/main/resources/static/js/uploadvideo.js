$(function () {
    var userid = 0;
    if($("#userid").val()==undefined||$("#userid").val()<=0){
        window.location.href="/Mosttv/login";
    }else{
        userid= $("#userid").val();
    }
    $("#uploadvidinfo").click(function () {

        var spic = $("#spic").filebox('getValue');
        var svid = $("#svid").filebox('getValue');
        var svida = $("#svida").val();

        var vidtit=$("#videotit").val();
        var viddis=$("#videomessage").val();
        var getvtype = $("label[class ='btn btn-default active']").text();
        getvtype = getvtype.trim().replace(/\s/g,"");
        if(vidtit==""||viddis==""||getvtype==""||spic==""||(svid==""&&svida=="")){
            alert("请填写必填项目");
        }else{
            var type=0;
            switch (getvtype) {
                case "美剧":
                    type=2;
                    break;
                case "电影":
                    type=1;
                    break;
                case "学习":
                    type=6;
                    break;
                case "新闻":
                    type=3;
                    break;
                case "体育":
                    type=4;
                    break;
                case "游戏":
                    type=5;
                    break;
            }
            var data = {
                "video_title":vidtit,
                "video_descript":viddis,
                "video_type":type,
                "video_peop":userid
            }
            $.ajax({
                type:"post",
                data:data,
                enctype:"multipart/form-data",
                url:"/uploadvideoinfo",
                async:false,
                success:function (data) {
                    if(data.id>0){
                        $("input[name='vid']").val(data.id);
                        if(data.msg=="success"){
                            $("#updatevidandpic").click();
                            $("#uploadvidinfo").attr("class","btn disabled");
                            $("#uploadvidinfo").unbind("click");
                        }else{
                            alert(data.msg);
                        }
                    }else{
                        alert("上传失败");
                    }

                }
            })
        }
    })
})