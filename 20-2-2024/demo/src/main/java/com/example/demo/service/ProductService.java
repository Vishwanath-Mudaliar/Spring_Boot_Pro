package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ProductModel;
import com.example.demo.repositary.ProductRepositary;

@Service
public class ProductService {
    private ProductRepositary productRepositary;


    public ProductService(ProductRepositary productRepositary) {
        this.productRepositary = productRepositary;
    }
    
    public boolean saveProduct(ProductModel productModel)
    {
        try{

            productRepositary.save(productModel);
        }
        catch(Exception e)
        {
            return false;
        }

        return true;

    }
    
    public boolean updateProduct(int id, ProductModel productModel)
    {
        if(this.getByProductId(id) == null)
        {
            return false;
        }
        try
        {
            productRepositary.save(productModel);

        }
        catch(Exception e)
        {
            return false;
        }

        return true;

    }
    
    public ProductModel getByProductId(int id)
    {
        return productRepositary.findById(id).orElse(   null  );
    }

    public List<ProductModel> getProducts()
    {
        return productRepositary.findAll();
    }

    public boolean deleteProduct(int id)
    {
        if(this.getByProductId(id) == null)
        {
            return false;
        }

        productRepositary.deleteById(id);
        return true;

    }
    
    
}
