package com.enhakkore.webservice.web;

import com.enhakkore.webservice.dto.posts.PostsSaveRequestDto;
import com.enhakkore.webservice.dto.user.MemberSaveRequestDto;
import com.enhakkore.webservice.service.PostsService;
import com.enhakkore.webservice.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    private MemberService memberService;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld!!";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }

    @PostMapping("/createMember")
    public Long createMember(@RequestBody MemberSaveRequestDto dto){
        return memberService.save(dto);
    }
}
