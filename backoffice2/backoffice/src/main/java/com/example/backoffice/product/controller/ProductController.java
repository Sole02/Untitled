package com.example.backoffice.product.controller;

import com.example.backoffice.product.dto.request.ProductCreateRequestDto;
import com.example.backoffice.product.dto.response.ProductCreateResponseDto;
import com.example.backoffice.product.dto.response.ProductReadAllResponseDto;
import com.example.backoffice.product.dto.response.ProductReadResponseDto;
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
        return ResponseEntity.status(HttpStatus.OK).body(productService.productReadAll());
    }

    // 상품 조회 (단건), 생성자 방식
    @GetMapping("/{productId}")
    public ResponseEntity<ProductReadResponseDto> productRead(@PathVariable Long productId) {

        // 1. 반환 방법
        // 1. 서비스에 id값을 조회 요청
        // 2. 조회 된 데이터를 반환 받아 객체에 담기
        ProductReadResponseDto responseDto = productService.productRead(productId);
        // 3.HTTP응답 객체를 새로 만들어
        //   응답 Dto 데이터와, HTTP 응답 설정 한걸
        //   상품 응답 Dto를 담은 HTTP 응답 객체의 response 객체에 담아
        ResponseEntity<ProductReadResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        // 4. 반환
        return response;
    }

//    // 상품 조회 (단건) 체이닝 방식
//    @GetMapping("/{productId}")
//    public ResponseEntity<ProductReadResponseDto> productRead(@PathVariable Long productId) {
//        // 2. 반환 방법
//        // ResponseEntity, HTTP 응답을 담는 객체에
//        // .status(HttpStatus.OK), 상태코드(설정) 후
//        // .body(service.create(request), 요청 데이터를 처리 후 담아서
//        // 반환
//        return ResponseEntity.status(HttpStatus.OK).body(productService.productRead(productId));
//    }
}
