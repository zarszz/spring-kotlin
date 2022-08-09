package com.zarszz.blog.dto.response

import com.zarszz.blog.persistence.entity.User

data class RenderedArticle(
    val slug: String,
    val title: String,
    val headline: String,
    val content: String,
    val author: User,
    val addedAt: String
)
