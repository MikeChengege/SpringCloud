package com.stu.springcloud.controller;

import java.util.List;

import com.stu.springcloud.modle.Manager;
import com.stu.springcloud.modle.Product;
import com.stu.springcloud.modle.User;
import com.stu.springcloud.modle.Video;
import com.stu.springcloud.service.ProductService;
import com.stu.springcloud.service.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RefreshScope
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    VideoInfoService videoInfoService;
    @Value("${version}")
    String version;
    @RequestMapping("/products")
    public Object listProduct(Model m){
        List<Product> lp = productService.listProduct();
        m.addAttribute("version",version);
        m.addAttribute("ps",lp);
        return  "products";
    }
    @RequestMapping("/Mosttv/index")
    public String indexPag(HttpSession session, HttpServletRequest request){
        if(session.getAttribute("useInfo")!=null){
            User u = (User)session.getAttribute("useInfo");
            session.setAttribute("sessionUser",u);
        }else {
            session.setAttribute("sessionUser",null);
        }
        return  "index";
    }
    @RequestMapping("/Mosttv/mostsee")
    public String mostSee() {
        return "mostsee";
    }
    @RequestMapping("/Mosttv/rankingList")
    public String rankingList() {
        return "rankingList";
    }
    @RequestMapping("/Mosttv/tvshow")
    public String tvshow() {
        return "tvshow";
    }
    @RequestMapping("/Mosttv/filmshow")
    public String filmshow() {
        return "filmshow";
    }
    @RequestMapping("/Mosttv/musicshow")
    public String musicshow() {
        return "musicshow";
    }
    @RequestMapping("/Mosttv/hotnews")
    public String hotnews() {
        return "hotnews";
    }
    @RequestMapping("/Mosttv/sportshow")
    public String sportshow() {
        return "sportshow";
    }
    @RequestMapping("/Mosttv/gameshow")
    public String gameshow() {
        return "gameshow";
    }
    @RequestMapping("/Mosttv/userinformation")
    public String userinformation(HttpSession session) {
        if(session.getAttribute("useInfo")!=null){
            User u = (User)session.getAttribute("useInfo");
            session.setAttribute("sessionUser",u);
        }else {
            session.setAttribute("sessionUser",null);
        }
        return "userinformation";
    }
//    注销
    @RequestMapping("/Mosttv/Cancellation")
    public String Cancellation(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }
    @RequestMapping("/Mosttv/playbackpage")
    public String playbackpage(String name, int id,HttpSession session){
        if(session.getAttribute("useInfo")!=null){
            User u = (User)session.getAttribute("useInfo");
            session.setAttribute("sessionUser",u);
        }else {
            session.setAttribute("sessionUser",null);
        }
        if(id>=0){
            Video video =  videoInfoService.getVideoById(id);
            if(video.getVideo_hadvisit()>=0){
                int oldVis=video.getVideo_hadvisit();
                video.setVideo_hadvisit(++oldVis);
                try{
                    videoInfoService.updateHadVis(video);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }

        return "playbackpage";
    }
    @RequestMapping("/Mosttv/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/Mosttv/upload")
    public String upload(String name){
        return "upload";
    }

    @RequestMapping("/Mosttv/searchpage")
    public String searchVideo(String secont, Model m){
        m.addAttribute("searchtent",secont);
        return "searchpage";
    }
    @RequestMapping("/Mosttv/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/Mosttv/maglogin")
    public String maglogin(){
        return "maglogin";
    }

    @RequestMapping("/Mosttv/magindex")
    public String magindex(HttpSession session){
        if(session.getAttribute("maguser")!=null){
            Manager mg = (Manager)session.getAttribute("maguser");
            session.setAttribute("sessionMagUser",mg);
        }else {
            session.setAttribute("sessionMagUser",null);
        }
        return "magindex";
    }

    @RequestMapping("/Mosttv/examinevideo")
    public String examinevideo(HttpSession session){
        if(session.getAttribute("maguser")!=null){
            Manager mg = (Manager)session.getAttribute("maguser");
            session.setAttribute("sessionMagUser",mg);
        }else {
            session.setAttribute("sessionMagUser",null);
        }
        return "examinevideo";
    }

    @RequestMapping("/Mosttv/examineuser")
    public String examineuser(HttpSession session){
        if(session.getAttribute("maguser")!=null){
            Manager mg = (Manager)session.getAttribute("maguser");
            session.setAttribute("sessionMagUser",mg);
        }else {
            session.setAttribute("sessionMagUser",null);
        }
        return "examineuser";
    }

    @RequestMapping("/Mosttv/examinecomm")
    public String examinecomm(HttpSession session){
        if(session.getAttribute("maguser")!=null){
            Manager mg = (Manager)session.getAttribute("maguser");
            session.setAttribute("sessionMagUser",mg);
        }else {
            session.setAttribute("sessionMagUser",null);
        }
        return "examinecomm";
    }
    @RequestMapping("/Mosttv/maguseradv")
    public String maguseradv(HttpSession session){
        if(session.getAttribute("maguser")!=null){
            Manager mg = (Manager)session.getAttribute("maguser");
            session.setAttribute("sessionMagUser",mg);
        }else {
            session.setAttribute("sessionMagUser",null);
        }
        return "maguseradv";
    }
    @RequestMapping("/Mosttv/magquit")
    @ResponseBody
    public String Magquit(HttpServletRequest request){
        request.getSession().invalidate();
        return "maglogin";
    }
}
