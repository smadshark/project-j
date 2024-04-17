package com.sonbro.projectj.domain.blog.service;

import com.sonbro.projectj.domain.blog.dao.Article;
import com.sonbro.projectj.domain.blog.dto.AddArticleReq;
import com.sonbro.projectj.domain.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
