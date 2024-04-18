package com.sonbro.projectj.domain.blog.controller;

import com.sonbro.projectj.domain.blog.dao.Article;
import com.sonbro.projectj.domain.blog.dto.AddArticleReq;
import com.sonbro.projectj.domain.blog.dto.ArticleRes;
import com.sonbro.projectj.domain.blog.dto.UpdateArticleReq;
import com.sonbro.projectj.domain.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/article/{id}")
    public ResponseEntity<ArticleRes> findArticle(@PathVariable Long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok(new ArticleRes(article));
    }

    @DeleteMapping("/api/article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        blogService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/article/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleReq req) {
        Article updatedArticle = blogService.update(id, req);

        return ResponseEntity.ok(updatedArticle);
    }
}
