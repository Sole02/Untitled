package com.example.backoffice.product.controller;

import com.example.backoffice.product.dto.request.ProductCreateRequestDto;
import com.example.backoffice.product.dto.response.ProductCreateResponseDto;
import com.example.backoffice.product.dto.response.ProductReadAllResponseDto;
import com.example.backoffice.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // 상품 등록
    @PostMapping
    public ResponseEntity<ProductCreateResponseDto> productCreate(@RequestBody ProductCreateRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.productCreate(request));
    }

    // 상품 조회 (다건)
    @GetMapping
    public ResponseEntity<List<ProductReadAllResponseDto>> productReadAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.productReadAllService());
    }

    // 상품 조회 (단건)
}
