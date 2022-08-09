package com.zarszz.blog

import com.zarszz.blog.persistence.entity.Article
import com.zarszz.blog.persistence.repository.ArticleRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/article")
class ArticleController(private val articleRepository: ArticleRepository) {
    @GetMapping("/")
    fun findAll() = articleRepository.findAllByOrderByAddedAtDesc()

    @GetMapping("/{slug}")
    fun findOne(@PathVariable slug: String): Article =
        articleRepository.findBySlug(slug) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "This article does not exist"
        )
}
