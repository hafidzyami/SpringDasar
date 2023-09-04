package hafidz.demo.service;

import hafidz.demo.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component itu langsung otomatis dijadiin bean
@Component
public class ProductService {

    @Getter
    private ProductRepository productRepository;

    // Constructor-based depedency injection itu pakai constructor aja

    // kalau mau ada dua atau lebih constructor, pake @autowired
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public ProductService(ProductRepository productRepository, String name){
        this.productRepository = productRepository;
    }


}
