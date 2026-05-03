package com.example.backoffice.Product.service;

import com.example.backoffice.Admin.entity.Admin;
import com.example.backoffice.Admin.repository.AdminRepository;
import com.example.backoffice.Product.dto.request.ProductCreateRequestDto;
import com.example.backoffice.Product.dto.request.ProductUpdateRequestDto;
import com.example.backoffice.Product.dto.response.ProductCreateResponseDto;
import com.example.backoffice.Product.dto.response.ProductReadAllResponseDto;
import com.example.backoffice.Product.dto.response.ProductReadResponseDto;
import com.example.backoffice.Product.dto.response.ProductUpdateResponseDto;
import com.example.backoffice.Product.entity.Product;
import com.example.backoffice.Product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final AdminRepository adminRepository;

    // 상품 등록
    @Transactional
    public ProductCreateResponseDto save(ProductCreateRequestDto request) {
        Admin admin = adminRepository.findById(request.getAdminId())
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 관리자입니다."));
        Product product = new Product(request.getName(), request.getPrice(), admin);
        Product savedProduct = productRepository.save(product);
        return new ProductCreateResponseDto(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice()
        );
    }

    // 상품 조회 (다건)
    @Transactional(readOnly = true)
    public List<ProductReadAllResponseDto> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductReadAllResponseDto> dtos = new ArrayList<>();
        for (Product product : products) {
            ProductReadAllResponseDto dto = new ProductReadAllResponseDto(
                    product.getId(),
                    product.getName(),
                    product.getPrice()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    // 상품 조회 (단건)
    @Transactional(readOnly = true)
    public ProductReadResponseDto findOne(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 상품입니다.")
        );
        return new ProductReadResponseDto(
                product.getId(),
                product.getAdmin().getName(),
                product.getName(),
                product.getPrice()
        );
    }

    // 상품 수정
    @Transactional
    public ProductUpdateResponseDto update(Long productId, ProductUpdateRequestDto request) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 상품입니다.")
        );
        product.productUpdate(request.getName(), request.getPrice());
        return new ProductUpdateResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

    // 상품 삭제
    @Transactional
    public void delete(Long id) {
        boolean existence = productRepository.existsById(id);
        if (!existence) {
            throw new IllegalStateException("존재하지 않는 상품입니다.");
        }
        productRepository.deleteById(id);
    }
}
