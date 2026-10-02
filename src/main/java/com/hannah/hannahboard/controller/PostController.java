package com.hannah.hannahboard.controller;

import com.hannah.hannahboard.dto.PostRequest;
import com.hannah.hannahboard.dto.PostResponse;
import com.hannah.hannahboard.entity.Post;
import com.hannah.hannahboard.exception.PostNotFoundException;
import com.hannah.hannahboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/write")
    public String boardWriteForm(Model model) {
        model.addAttribute("post", new Post());
        return "write";
    }

    @PostMapping("/save")
    public String post(PostRequest request) throws Exception {
        postService.write(request);
        return "redirect:/board/list";
    }

    @GetMapping("/{id}")
    public String getPost(@PathVariable Long id, Model model) throws PostNotFoundException {
        PostResponse post = postService.getPost(id);
        model.addAttribute("post", post);
        return "post";
    }
}
