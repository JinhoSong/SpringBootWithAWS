package com.jojoldu.Book.springboot.web;

import com.jojoldu.Book.springboot.config.auth.LoginUser;

import com.jojoldu.Book.springboot.service.posts.PostsService;
import com.jojoldu.Book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;
import com.jojoldu.Book.springboot.config.auth.dto.SessionUser;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    //private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());

        //SessionUser user = (SessionUser) httpSession.getAttribute("user");
        // 기존에 세션을 가져오는 방식에서 @LoginUser 어노테이션을 통해 가져오는 방식으로 바꿈
        if(user != null){
            //System.out.println(user.getName());
            //userName을 쓰는경우 window의 환경변수 이름을 넣어버린다. 뭔지 모를 충돌.
            model.addAttribute("loginName",user.getName());
        }
        return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts", dto);

        return "posts-update";
    }

}
