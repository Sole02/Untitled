package com.example.backoffice.Product.controller;

import com.example.backoffice.Product.dto.request.ProductCreateRequestDto;
import com.example.backoffice.Product.dto.request.ProductUpdateRequestDto;
import com.example.backoffice.Product.dto.response.ProductCreateResponseDto;
import com.example.backoffice.Product.dto.response.ProductReadAllResponseDto;
import com.example.backoffice.Product.dto.response.ProductReadResponseDto;
import com.example.backoffice.Product.dto.response.ProductUpdateResponseDto;
import com.example.backoffice.Product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 상품 등록
    @PostMapping("/products")
    public ResponseEntity<ProductCreateResponseDto> productCreate(@RequestBody ProductCreateRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(request));
    }

    // 상품 조회 (다건)
    @GetMapping("/products")
    public ResponseEntity<List<ProductReadAllResponseDto>> productGetAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    // 상품 조회 (단건)
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductReadResponseDto> productGetOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findOne(id));
    }

    // 상품 수정
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductUpdateResponseDto> productUpdate(@PathVariable Long id, @RequestBody ProductUpdateRequestDto request) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(id, request));
    }

    // 상품 삭제
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> productDelete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
