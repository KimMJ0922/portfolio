package com.kmj.portfolio.domain.repository

import com.kmj.portfolio.domain.entity.Achievement
import com.kmj.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository: JpaRepository<Link, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Link>

}