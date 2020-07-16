package com.jojoldu.Book.springboot.web.dto;

import com.jojoldu.Book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
    // Entity는 변경시키기에 너무 중요하다
    // 하지만 얘는 view에게 줄때 자주 변경시켜도 상관없다.
    // 그래서 이걸 만든거다.
    // View Layer와 DB Layer를 철저하게 분리하는게 좋다.
}
