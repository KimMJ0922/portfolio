package com.kmj.portfolio.domain.repository

import com.kmj.portfolio.domain.constant.SkillType
import com.kmj.portfolio.domain.entity.Link
import com.kmj.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface SkillRepository: JpaRepository<Skill, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Skill>

    fun findByNameIgnoreCaseAndType(name: String, type: SkillType): Optional<Skill>


}