package com.jojoldu.Book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>{
    //Jpa로 이미 CRUD는 가능
}