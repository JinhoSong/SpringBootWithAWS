package com.jojoldu.Book.springboot.domain.posts;

import com.jojoldu.Book.springboot.domain.BaseTimeEntity;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }

    // 주요어노테이션은 가깝게
    // 나중에 롬복을 제거하게 될 경우 쉽게 제거 하려고
}
