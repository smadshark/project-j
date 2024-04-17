package com.sonbro.projectj.domain.blog.dto;

import com.sonbro.projectj.domain.blog.dao.Article;
import lombok.Getter;

@Getter
public class ArticleRes {
    private final String title;
    private final String content;

    public ArticleRes(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
