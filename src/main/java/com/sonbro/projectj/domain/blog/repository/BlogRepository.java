package com.sonbro.projectj.domain.blog.repository;

import com.sonbro.projectj.domain.blog.dao.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
