package com.sonbro.projectj.domain.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonbro.projectj.domain.blog.dao.Article;
import com.sonbro.projectj.domain.blog.dto.AddArticleReq;
import com.sonbro.projectj.domain.blog.dto.UpdateArticleReq;
import com.sonbro.projectj.domain.blog.repository.BlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BlogControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private BlogRepository blogRepository;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        blogRepository.deleteAll();
    }

    @DisplayName("addArticle: add blog content success")
    @Test
    public void addArticle() throws Exception {
        // given
        final String url = "/api/article";
        final String title = "게시글 제목";
        final String content = "게시글 내용";
        final AddArticleReq req = new AddArticleReq(title, content);

        // json serialize
        final String reqBody = objectMapper.writeValueAsString(req);

        // when
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(reqBody));

        // then
        result.andExpect(status().isCreated());

        List<Article> articleList = blogRepository.findAll();

        assertThat(articleList.size()).isEqualTo(1);
        assertThat(articleList.get(0).getTitle()).isEqualTo(title);
        assertThat(articleList.get(0).getContent()).isEqualTo(content);
    }

    @DisplayName("findAllArticles: select all article success")
    @Test
    public void findAllArticles() throws Exception {
        // given
        final String url = "/api/articles";
        final String title = "title";
        final String content = "content";

        blogRepository.save(Article.builder()
                .title(title)
                .content(content)
                .build());

        // when
        final ResultActions result = mockMvc.perform(get(url)
                .accept(MediaType.APPLICATION_JSON));

        // then
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].content").value(content))
                .andExpect(jsonPath("$[0].title").value(title));
    }

    @DisplayName("findArticle: select article success")
    @Test
    public void findArticleTest() throws Exception {
        // given
        final String url = "/api/article/{id}";
        final String title = "hello";
        final String content = "hello content";

        Article savedArticle = blogRepository.save(Article.builder()
                .title(title)
                .content(content)
                .build());

        // when
        final ResultActions result = mockMvc.perform(get(url, savedArticle.getId()));

        // then
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(content))
                .andExpect(jsonPath("$.title").value(title));
    }

    @DisplayName("delete")
    @Test
    public void deleteTest() throws Exception {
        // given
        final String url = "/api/article/{id}";
        final String title = "hello";
        final String content = "hello content";

        Article savedArticle = blogRepository.save(Article.builder()
                .title(title)
                .content(content)
                .build());

        // when
        final ResultActions result = mockMvc.perform(get(url, savedArticle.getId()));

        // then
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(content))
                .andExpect(jsonPath("$.title").value(title));

        // when
        final ResultActions deleteResult = mockMvc.perform(delete(url, savedArticle.getId())).andExpect(status().isOk());

        // then
        List<Article> articleList = blogRepository.findAll();

        assertThat(articleList).isEmpty();
    }

    @DisplayName("article update")
    @Test
    public void updateTest() throws Exception {
        // given
        final String url = "/api/article/{id}";
        final String title = "hello";
        final String content = "hello content";

        Article savedArticle = blogRepository.save(Article.builder()
                .title(title)
                .content(content)
                .build());

        final String newTitle = "OMZ";
        final String newContent = "Welcome to the developer hell";

        UpdateArticleReq req = new UpdateArticleReq(newTitle, newContent);

        // when
        ResultActions result = mockMvc.perform(put(url, savedArticle.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)));

        // then
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(newTitle))
                .andExpect(jsonPath("$.content").value(newContent));

        Article updatedArticle = blogRepository.findById(savedArticle.getId()).get();

        assertThat(updatedArticle.getTitle()).isEqualTo(newTitle);
        assertThat(updatedArticle.getContent()).isEqualTo(newContent);

    }
}