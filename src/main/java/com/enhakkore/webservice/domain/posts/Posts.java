package com.enhakkore.webservice.domain.posts;

import com.enhakkore.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본생성자 자동 추가, 기본 생성자의 접근 권한을 protected로 제한,
@Getter
@Entity // 테이블과 링크될 클래스임을 나타냄(언더스코어 네이밍으로 이름을 매칭함, SalesManager.java -> sales_manager
public class Posts extends BaseTimeEntity { // 실제 DB의 테이블과 매칭될 클래스이며 보통 Entitiy 클래스

    @Id // PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성규칙, 기본값은 AUTO로 MySQL의 auto_increment와 같이 자동증가하는 정수형 값이 된다.
    private Long id;
    //스프링 부트에는 hibernate의 id 생성전략을 따를지를 결정하는 useNewIdGeneratorMappings가 있다. 1.5에서는 기본값이 false, 2.0부터는 true 이다.
    //따라서 hibernate 5.0부터는 GenerationType.AUTO는 사용하는 DB의 IDENTITY가 아닌 TABLE을 기본 시퀀스 전략으로 선택한다.
    //스프링 부트 1.5에서는 hibernate 5.x를 사용하더라도 hibernate의 전략을 따라가지 않기때문에(기본값을 변경하지 않았다면) GenerationType.AUTO로 설정해도 IDENTITY가 선택되지만,
    //스프링 부트 2.0d에서는 기본값이 true이기 때문에 hibernate를 사용하면 TABLEd이 기본 시퀀스 전략으로 선택된다.
    //해결전략 1. application.yml에서 spring: jpa: hibernate: 에서 use-new-id-generator-mappings: false 로 설정
    // or 해결전략 2. @GeneratedValue의 전략을 GenerationType.IDENTITY로 설정

    @Column(length = 500, nullable = false) // @Column을 다 선언하지 않더라도 필드로 다 인식되며, 선언하는 이유는 기본 설정값 이외에 추가로 변경하고 싶을 때 선언하게 된다, lnegth는 250이 기본값.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

// JPA를 사용하면 DB데이터에 직접 쿼리를 보내기 보다는, 이 Entity 클래스의 수정을 통해 작업합니다.