package com.kmj.portfolio.domain.repository

import com.kmj.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository: JpaRepository<Skill, Long> {
}