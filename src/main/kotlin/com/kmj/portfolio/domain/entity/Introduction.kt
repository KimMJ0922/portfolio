package com.kmj.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Introduction: BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "introducction_id")
    var id: Long? = null

    
}