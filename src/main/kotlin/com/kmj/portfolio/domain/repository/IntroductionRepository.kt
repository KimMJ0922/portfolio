package com.kmj.portfolio.domain.repository

import com.kmj.portfolio.domain.entity.Achievement
import com.kmj.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository: JpaRepository<Introduction, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Introduction>

}