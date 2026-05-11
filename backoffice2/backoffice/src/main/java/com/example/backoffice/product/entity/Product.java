package com.example.backoffice.product.entity;

import com.example.backoffice.admin.entity.Admin;
import jakarta.persistence.*;
import org.hibernate.annotations.SoftDelete;

@Entity
@Table(name = "products")
@SoftDelete
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY) // 다대일 관계
    @JoinColumn(name = "admin_id") // FK이름 설정
    private Admin admin;

    public Product() {}

    public Product(String name, int price, Admin admin) {
        this.name = name;
        this.price = price;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public Admin getAdmin() {
        return admin;
    }

    /**
     * 상품 수정 기능, 객체 반환 방법
     * 1. 반환 타입 엔티티
     * 2. (수정 데이터)
     * 3. this.로 데이터 집어주기
     * 4. 반환 값 정하기 .this로 = 엔티티로 반환
     * 장점 : 객체를 바로 활용 할 수 있고, 코드를 간결하게 할 수 있음
     */
    public Product productUpdate(String name, int price, Admin admin) {
        this.name = name;
        this.price = price;
        this.admin = admin;
        return this;
    }

    /**
     * 상품 수정 기능 void 방법
     * 1. 반환 타입 void
     * 2. 수정 데이터
     * 3. this.로 데이터 집어주기
     * 장점 : 코드가 단순해, 읽기 쉬움
     * 단점 : 다른곳에서 객체를 활용할 때 추가 코드 필요
     */
//    public void productUpdatevoid(String name, int price) {
//        this.name = name;
//        this.price = price;
//    }

//    // 소프트 딜리트
//    // 기능으로 데이터 값을 true, false 값으로 수정하여 데이터를
//    // 완전히 삭제 시키지 않고 서버에 남기는 구현 방법
//    public void productDelete() {
//        this.isDeleted = true;
//    }
}
