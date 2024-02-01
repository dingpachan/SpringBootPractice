package com.example.test.controller;

// 載入兩個Library
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.test.model.Product;
import com.example.test.service.ProductService;
import com.example.test.util.ResponseBody;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Optional;

// @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    Boolean result = false;
    String message = "error";
    List<Object> data = new ArrayList<>();
    int totalCount = 0;

    @GetMapping
    public ResponseBody getAll() {
        List<Product> data = productService.getAll();
        List<Object> dataAsObjects = new ArrayList<>(data);

        totalCount = data.size();

        return new ResponseBody(true, "OK", dataAsObjects, totalCount);
    }

    @GetMapping("/{id}")
    public ResponseBody getById(@PathVariable Long id) {
        List<Object> dList = new ArrayList<>();

        if (id != 0) {
            Optional<Product> data = productService.getById(id);

            if (data.isPresent()) {
                result = true;
                message = "OK";
                dList = Arrays.asList(data.get());
            } else {
                result = false;
                message = "error";
                dList = new ArrayList<>();
            }

            totalCount = dList.size();
        }

        return new ResponseBody(result, message, dList, totalCount);
    }

    @PostMapping
    public ResponseBody save(@RequestBody Product product) {
        Product data = productService.save(product);
        List<Object> dataAsObjects = Arrays.asList((Object) data);

        List<Object> dList;
        if (dataAsObjects.size() > 0) {
            result = true;
            message = "OK";
            dList = dataAsObjects;
        } else {
            dList = new ArrayList<>();
        }

        totalCount = dList.size();

        return new ResponseBody(result, message, dList, totalCount);
    }

    @PatchMapping("/{id}")
    public ResponseBody update(@PathVariable Long id, @RequestBody Product updatedProduct) {
        List<Object> dList = new ArrayList<>();

        if (id > 0) {
            result = productService.patch(id, updatedProduct);

            if (result) {
                return this.getById(id);
            }
        }

        return new ResponseBody(result, message, dList, totalCount);
    }

    @DeleteMapping("/{id}")
    public ResponseBody delete(@PathVariable Long id) {
        List<Object> dList = new ArrayList<>();

        if (id > 0) {
            result = productService.delete(id);

            if (result) {
                message = "OK";
            } else {
                message = "THIS_ITEM_DOES_NOT_EXIST";
            }
        }

        return new ResponseBody(result, message, dList, totalCount);
    }
}