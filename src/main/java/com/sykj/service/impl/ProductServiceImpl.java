package com.sykj.service.impl;

import com.sykj.domain.Product;
import com.sykj.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
@Service
public class ProductServiceImpl implements ProductService {
    private static final Map<Integer,Product> daoMap=new HashMap<>();
    static{
        Product p1 = new Product("1", "小米", "12.5");
        Product p2 = new Product("2", "华为", "33.5");
        Product p3 = new Product("3", "联想", "33.5");
        Product p4 = new Product("4", "苹果", "15.5");
        Product p5 = new Product("5", "vivo", "62.5");
        daoMap.put(Integer.parseInt(p1.getProductId()),p1);
        daoMap.put(Integer.parseInt(p2.getProductId()),p2);
        daoMap.put(Integer.parseInt(p3.getProductId()),p3);
        daoMap.put(Integer.parseInt(p4.getProductId()),p4);
        daoMap.put(Integer.parseInt(p5.getProductId()),p5);
    }
    @Override
    public List<Product> ProductList() {
        Collection<Product> values = daoMap.values();
        List productList=new ArrayList(values);
        return productList;
    }

    @Override
    public Object findId(@RequestParam("id")int Id) {
        Product product = daoMap.get(Id);
        return product;
    }
}
