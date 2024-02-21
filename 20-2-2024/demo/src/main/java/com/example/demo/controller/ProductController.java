package com.example.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductModel;
import com.example.demo.service.ProductService;





@RestController
public class ProductController {
    
    private ProductService productService;

    

    public ProductController(ProductService productService) 
    {
        this.productService = productService;
    }


     @GetMapping("/test")
    public ResponseEntity<String> test( )

    {

        return new ResponseEntity<String>("", HttpStatus.OK);
    }


    @PostMapping("/product")
    public ResponseEntity<ProductModel> postproduct(@RequestBody ProductModel productModel)
    {
        if( productService.saveProduct(productModel) == true)
        {
            return new ResponseEntity<>(productModel ,HttpStatus.CREATED);
        }

        return new ResponseEntity<>(productModel ,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<ProductModel> getByProductId(@PathVariable("id") int id )
    {
        ProductModel p = productService.getByProductId(id);
        if( p == null)
        {
            return new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(p, HttpStatus.OK);
    }


    @GetMapping("/products")
    public ResponseEntity<List<ProductModel> > getProducts()
    {
        System.out.println("At Get");
        List<ProductModel> b = productService.getProducts();
        if(b.size() == 0)
        {
            return  new ResponseEntity<>(Collections.EMPTY_LIST, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductModel> putMethodName(@PathVariable("id") int id, @RequestBody ProductModel productModel) 
    {
        if( productService.updateProduct(id, productModel) == true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductModel> delete(@PathVariable int id)
    {
        if( productService.deleteProduct(id) == true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
