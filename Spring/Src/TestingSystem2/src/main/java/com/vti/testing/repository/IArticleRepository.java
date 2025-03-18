package com.vti.testing.repository;

import com.vti.testing.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticleRepository extends JpaRepository<Article, Integer> {
}