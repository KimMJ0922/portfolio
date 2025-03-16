package com.kmj.portfolio.domain.repository

import com.kmj.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface HttpInterfaceRepository: JpaRepository<HttpInterface, Long> {

    fun countAllByRegDateBetween(start: LocalDateTime, end: LocalDateTime): Long
}