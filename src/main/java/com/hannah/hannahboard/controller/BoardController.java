package com.hannah.hannahboard.controller;

import com.hannah.hannahboard.service.PostService;
import dto.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final int PAGE_BLCOK = 10;
    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public String getPosts(final Pageable pageable, Model model) {
        Page<PostResponse> page = postService.getList(pageable);

        int pageNumber = page.getPageable().getPageNumber();
        int totalPages = page.getTotalPages();
        int startBlockPage = ((pageNumber)/PAGE_BLCOK)*PAGE_BLCOK+1;
        int endBlockPage = Math.min(totalPages, startBlockPage + PAGE_BLCOK - 1);
//        because page starts from 1, adjust endblock if it has only page.
        endBlockPage = (endBlockPage == 0 ? 1: endBlockPage);

        model.addAttribute("page", page);
        model.addAttribute("startBlockPage", startBlockPage);
        model.addAttribute("endBlockPage", endBlockPage);
        return "board";
    }
}
