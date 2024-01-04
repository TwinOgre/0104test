package com.test0104.articleTest.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public void create(String title, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setCreateDate(LocalDateTime.now());

        this.articleRepository.save(article);
    }

    public List<Article> findAll() {
        return this.articleRepository.findAll();
    }

    public Article getArticle(Integer id) {
        Optional<Article> oa = this.articleRepository.findById(id);
        if(oa.isEmpty()){
            throw new RuntimeException();
        }
        return oa.get();
    }
}
