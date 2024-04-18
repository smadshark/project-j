package com.sonbro.projectj.domain.blog.service;

import com.sonbro.projectj.domain.blog.dao.Article;
import com.sonbro.projectj.domain.blog.dto.AddArticleReq;
import com.sonbro.projectj.domain.blog.dto.UpdateArticleReq;
import com.sonbro.projectj.domain.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleReq req) {
        return blogRepository.save(req.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id + " article"));
    }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, UpdateArticleReq req) {
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(req.getTitle(), req.getContent());

        return article;
    }
}
