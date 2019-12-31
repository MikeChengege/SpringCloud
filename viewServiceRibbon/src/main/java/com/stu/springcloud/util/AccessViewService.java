package com.stu.springcloud.util;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;

public class AccessViewService {
    public static void main(String[] args) {
        int i = 0;
        while (true){
            i++;
            System.out.println("第"+i+"遍");
            ThreadUtil.sleep(1000);
            String html = HttpUtil.get("http://127.0.0.1:8012/products");
            System.out.println("html1 length "+html.length());
            String html1 = HttpUtil.get("http://127.0.0.1:8013/products");
            System.out.println("html2 length "+html1.length());
        }
    }
}
