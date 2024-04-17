package com.sonbro.projectj.domain.blog.controller;

import com.sonbro.projectj.domain.blog.dao.Article;
import com.sonbro.projectj.domain.blog.dto.AddArticleReq;
import com.sonbro.projectj.domain.blog.dto.ArticleRes;
import com.sonbro.projectj.domain.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogController {
    private final BlogService blogService;

    @PostMapping("/api/article")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleReq req) {
        Article savedArticle = blogService.save(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleRes>> findAllArticles() {
        List<ArticleRes> articleResList = blogService.findAll()
                .stream()
                .map(ArticleRes::new)
                .toList();
        return ResponseEntity.ok(articleResList);
    }
}
