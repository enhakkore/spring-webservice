package com.enhakkore.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
    //SpringDataJpa에서 제공하는 기본 메서드만으로 해결할 수 있지만,
    //SpringDataJpa에서 제공하지 않는 메서드는 위처럼 쿼리로 작성해도 된다는 것을 보여줌
}
