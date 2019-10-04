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
    @GeneratedValue // PK 생성규칙, 기본값은 AUTO로 MySQL의 a
    // uto_increment와 같이 자동증가하는 정수형 값이 된다.
    private Long id;

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