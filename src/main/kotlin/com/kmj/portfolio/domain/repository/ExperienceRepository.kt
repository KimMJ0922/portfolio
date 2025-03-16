package com.kmj.portfolio.domain.repository

import com.kmj.portfolio.domain.entity.Experience
import com.kmj.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ExperienceRepository: JpaRepository<Experience, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Experience>

}