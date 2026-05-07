package com.example.backoffice.product.service;

import com.example.backoffice.admin.entity.Admin;
import com.example.backoffice.admin.repository.AdminRepository;
import com.example.backoffice.product.dto.request.ProductCreateRequestDto;
import com.example.backoffice.product.dto.response.ProductCreateResponseDto;
import com.example.backoffice.product.dto.response.ProductReadAllResponseDto;
import com.example.backoffice.product.dto.response.ProductReadResponseDto;
import com.example.backoffice.product.entity.Product;
import com.example.backoffice.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final AdminRepository adminRepository;

    public ProductService(ProductRepository productRepository, AdminRepository adminRepository) {
        this.productRepository = productRepository;
        this.adminRepository = adminRepository;
    }

    /**
     * 상품 생성
     * 1. 컨트롤러 @PostMapping, 임시 void, 메서드, @RequestBody 설정
     * 2. 요청 dto 만들기
     * 3. 엔티티 만들기
     * 4. 레포지토리 만들기
     * 4.1 엔티티에 레포시토리 연결
     * 5. 서비스 만들기
     * 5.1 서비스에 레포지토리 연결
     * 5.2 @Transactional, 임시 void, 메서드 설정 파라미터에 요청dto, 변수 기입
     * 5.3 dto 데이터 꺼내기 ※ex) String name = 요청dto 변수.getName();
     * 5.4 엔티티 생성, 꺼낸 값 넣고
     * 5.5 DB에 저장
     * 5.6 응답 dto 만들기
     * 5.7 엔티티에서 데이터를 꺼내 응답 dto에 담기
     * 5.8 응답 dto 반환
     * 5.9 임시 void를 응답 dto로 수정
     * 6. 컨트롤러 임시 void를 ResponseEntity<응답 dto>로 수정
     * 6.1 메서드 파라미터에 요청 Dto, 변수 기입
     * 6.2 ResponseEntity.status(HttpStatus.CREATED).body(서비스.서비스 메서드(요청 dto 변수)) 기입
     */

    // 상품 등록
    @Transactional
    public ProductCreateResponseDto productCreate(ProductCreateRequestDto request) {
        // 요청 데이터 받아오기
        String foundName = request.getName();
        int foundPrice = request.getPrice();
        Long foundAdminId = request.getAdminId();
        // 어드민 FK값 DB조회 후 일치한 id가 있다면 Admin엔티티 객체로 변환
        // 일치하는 id가 없다면 예외 처리, 없을 시 메시지 출력
        Admin admin = adminRepository.findById(foundAdminId)
                .orElseThrow(() -> new IllegalStateException("없는 관리자입니다."));
        // 상품 엔티티 생성, 상품 엔티티 + admin FK
        Product product = new Product(foundName, foundPrice, admin);
        // DB에 저장
        Product savedProduct = productRepository.save(product);
        // 저장된 데이터 꺼내서 변수 지정
        Long savedId = savedProduct.getId();
        String savedName = savedProduct.getName();
        int savedPrice = savedProduct.getPrice();
        // 어드민 데이터 꺼내서 변수 지정
        Admin savedProductAdmin = savedProduct.getAdmin();
        String savedProductAdminName = savedProductAdmin.getName();
        // 응답 dto 생성
        ProductCreateResponseDto response = new ProductCreateResponseDto(savedId, savedName, savedPrice, savedProductAdminName);
        // 반환
        return response;
    }

    // 상품 조회 (다건)
    @Transactional(readOnly = true)
    public List<ProductReadAllResponseDto> productReadAll() {
        // Repository를 통해 전체 목록을 조회 후 productList에 담기
        List<Product> productList = productRepository.findAll();
        // productList를 stream 방식으로 꺼내기
        return productList.stream()
                // 꺼낸 product를 ResponseDto에 넘겨서 dto 생성
                .map(ProductReadAllResponseDto::new)
                // 생성된 dto들을 List로 만들고 return
                .toList();
    }

    /**
     * 상품 단건 조회
     * 1. 컨트롤러 @GetMapping 임시 void, 메서드, (@PathVariable Long id) {}설정
     * 2. 서비스 @Transactional(readOnly = true), 임시 void, 메서드 (Long id) {} 설정
     * 3. 사용자가 id값의 데이터를 조회하기 위해 id값을 요청, 레포지토리를 통해서 DB에 있는 id가 있는지 확인
     * 3.1  repository.findById(id)  ※ repository를 통해 findById, 찾다 요청 받은 id를
     * 4. id값으로 찾은 데이터를 엔티티 객체로 담기
     * 4. Product product = repository.findById(id)
     * / 4.1 요청 id와 일치하지 않는 다면, 예외 처리
     * 5. 응답 dto 생성
     * 5.1 응답 dto에 데이터 담기
     * 5.2 responseDto response = new ResponseDto(product.getName, product.getPrice)
     * (Product엔티티 안에 getName, getPrice가 있다는걸 이해 했기 때문에 이번에는 한번 데이터를 따로 꺼내어 변수로 이름 붙여 사용하지 않아봤니다)
     * 6. 응답 dto 반환
     * 6.1 return responseDto
     * 7. 서비스 임시 void를 반환 데이터인 응답 dto로 교체 responseDto
     * 8. 컨트롤러에 서비스 연결
     * 8.1 멋진 응답 만들기
     */

    // 상품 조회 (단건)
    @Transactional(readOnly = true)
    public ProductReadResponseDto productRead(Long productId) {
        // 요청 받은 id값을 DB에서 확인 후 데이터를 객체에 담음
        // 예외 처리, id값이 DB에서 확인되지 않는다면 메시지 출력
        Product foundProduct = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("없는 상품입니다."));
        // 응답 dto 생성 후
        // 응답 dto에 객체 데이터 담기
        ProductReadResponseDto response = new ProductReadResponseDto(foundProduct.getId(), foundProduct.getName(), foundProduct.getPrice(), foundProduct.getAdmin().getName());
        return response;
    }



}