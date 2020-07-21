package com.jojoldu.Book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long>{
    //Jpa로 이미 CRUD는 가능

    @Query("select p from Posts p order by p.id DESC ")
    List<Posts> findAllDesc();
}