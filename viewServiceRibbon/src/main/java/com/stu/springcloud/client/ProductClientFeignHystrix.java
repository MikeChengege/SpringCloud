package com.stu.springcloud.client;

import com.stu.springcloud.modle.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductClientFeignHystrix  implements ProductClientRibbon{
    public List<Product> listProduct() {
        List<Product> lp = new ArrayList<>();
        lp.add(new Product(0,"产品不可用",0));
        return lp;
    }
}
