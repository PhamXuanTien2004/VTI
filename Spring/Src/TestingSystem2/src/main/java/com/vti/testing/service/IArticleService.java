package com.vti.testing.service;

import com.vti.testing.entity.Article;

import java.util.List;

public interface IArticleService {
    List<Article> getAllArticles();
}