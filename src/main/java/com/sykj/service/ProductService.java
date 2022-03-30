package com.sykj.service;

import com.sykj.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ProductService {
    List<Product> ProductList();
    Object findId(int Id);
}
