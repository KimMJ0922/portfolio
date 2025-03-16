package com.kmj.portfolio.presentation.dto

import com.kmj.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content: String
){
    constructor(introduction: Introduction) : this(
        content = introduction.content
    )
}