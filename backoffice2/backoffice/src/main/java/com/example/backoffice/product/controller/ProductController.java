package com.example.backoffice.product.controller;

import com.example.backoffice.product.dto.request.ProductCreateRequestDto;
import com.example.backoffice.product.dto.request.ProductUpdateRequestDto;
import com.example.backoffice.product.dto.response.ProductCreateResponseDto;
import com.example.backoffice.product.dto.response.ProductReadAllResponseDto;
import com.example.backoffice.product.dto.response.ProductReadResponseDto;
import com.example.backoffice.product.dto.response.ProductUpdateResponseDto;
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
        // 서비스에 있는 생성 메서드를 호출 하여 요청 데이터를 responseDto 객체에 담음
        ProductCreateResponseDto createResponseDto = productService.productCreate(request);
        // Dto객체와 응답 설정을 넣은 HTTP응답 객체를 생성하고 createResponse 객체에 다시 담아
        ResponseEntity<ProductCreateResponseDto> createResponse = new ResponseEntity<>(createResponseDto, HttpStatus.CREATED);
        // 반환
        return createResponse;
    }

    // 상품 조회 (다건)
    @GetMapping
    public ResponseEntity<List<ProductReadAllResponseDto>> productReadAll() {
        // 서비스 다건 조회 메서드를 호출, 여러개의 데이터를 꺼내서 줘야 하기 때문에 List<응답dto> 하여 객체 생성
        List<ProductReadAllResponseDto> readAllResponseDto = productService.productReadAll();
        //  Dto객체와 응답 설정을 넣은 HTTP응답 객체를 생성 후 readAllResponse 객체에 담아
        ResponseEntity<List<ProductReadAllResponseDto>> readAllResponse = new ResponseEntity<>(readAllResponseDto, HttpStatus.OK);
        // 반환
        return readAllResponse;
    }

    // 상품 조회 (단건), 생성자 방식
    @GetMapping("/{productId}")
    public ResponseEntity<ProductReadResponseDto> productRead(@PathVariable Long productId) {

        // 1. 반환 방법
        // 1. 서비스에 id값을 조회 요청
        // 2. 조회 된 데이터를 반환 받아 응답 객체에 담기
        ProductReadResponseDto readResponseDto = productService.productRead(productId);
        // 3.HTTP응답 객체를 만들고
        //   응답 Dto 데이터와, HTTP 응답 설정 한걸
        //   상품 응답 Dto를 담은 HTTP 응답 객체의 readResponse 객체에 담아
        ResponseEntity<ProductReadResponseDto> readResponse = new ResponseEntity<>(readResponseDto, HttpStatus.OK);
        // 4. 반환
        return readResponse;
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

    // 상품 수정
    @PutMapping("/{productId}")
    public ResponseEntity<ProductUpdateResponseDto> productUpdate(@PathVariable Long productId, @RequestBody ProductUpdateRequestDto request) {
        // 서비스 수정 메서드에서 상품id, 요청 값을 응답 Dto에 담기
        ProductUpdateResponseDto updateResponseDto = productService.productUpdate(productId, request);
        // HTTP응답 객체에 응답 dto, 응답 설정을 담아 객체에 담기
        ResponseEntity<ProductUpdateResponseDto> updateResponse = new ResponseEntity<>(updateResponseDto, HttpStatus.OK);
        // 반환
        return updateResponse;
    }
}
