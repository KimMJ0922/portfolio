package com.kmj.portfolio.presentation.dto

import com.kmj.portfolio.domain.entity.Skill

data class SkillDTO(
    val name: String,
    val type: String
){
    constructor(skill: Skill) : this(
        name = skill.name,
        type = skill.type.name
    )
}
