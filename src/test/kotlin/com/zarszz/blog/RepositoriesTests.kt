package com.zarszz.blog

import com.zarszz.blog.persistence.entity.Article
import com.zarszz.blog.persistence.entity.User
import com.zarszz.blog.persistence.repository.ArticleRepository
import com.zarszz.blog.persistence.repository.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    var userRepository: UserRepository,
    val articleRepository: ArticleRepository
) {
    @Test
    fun `When findByIdOrNull then return Article`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)

        val article = Article(
            "Spring framework with kotlin",
            "Hello world",
            "Lorep Ipsum",
            author = juergen
        )
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {
        val user = User("asd", "asd", "asd")
        entityManager.persist(user)
        entityManager.flush()
        val found = userRepository.findByLogin(user.login)
        assertThat(found).isEqualTo(user)
    }
}
