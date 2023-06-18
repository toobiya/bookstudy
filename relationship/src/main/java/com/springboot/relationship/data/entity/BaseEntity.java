package com.springboot.relationship.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass   //  JPA 엔티티 클래스가 상속받을 경우 자식 클래스에게 매핑 정보 전달
@EntityListeners(AuditingEntityListener.class)  // 엔티티를 DB에 적용하기 전후로 콜백을 요청
public class BaseEntity {

    @CreatedDate    // 데이터 생성 날짜를 자동으로 주입
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate   // 데이터 수정 날짜를 자동으로 주입
    private LocalDateTime updatedAt;
}
