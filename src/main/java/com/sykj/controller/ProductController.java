package com.sykj.controller;

import com.sykj.domain.Product;
import com.sykj.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/product/")
public class ProductController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private ProductService productService;
    @GetMapping("productList")
    public List<Product> ProductList(){
        return productService.ProductList();
    }
    @GetMapping("findId")
    public Object findId(int Id){
        Product prod = (Product)productService.findId(Id);
        Product product = new Product();
        BeanUtils.copyProperties(prod,product);
        product.setProductName(prod.getProductName()+"=>ip:"+port);
        return product;
    }
}
