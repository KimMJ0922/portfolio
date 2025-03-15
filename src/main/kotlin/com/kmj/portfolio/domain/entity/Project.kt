package com.kmj.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Project(
    name: String,
    description: String,
    startYear: Int,
    endYear: Int,
    startMonth: Int,
    endMonth: Int,
    isActive: Boolean
): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    var id: Long? = null

    var name: String? = null

    var description: String? = null

    var startYear: Int? = null

    var endYear: Int? = null

    var startMonth: Int? = null

    var endMonth: Int? = null

    var isActive: Boolean? = null

    @OneToMany(targetEntity = ProjectDetail::class
        , mappedBy = "project"
        , fetch = FetchType.LAZY
        , cascade = [CascadeType.ALL])
    @JoinColumn(name = "project_detail_id")
    var details: MutableList<ProjectDetail> = mutableListOf()

    @OneToMany(targetEntity = ProjectSkill::class
        , mappedBy = "project"
        , fetch = FetchType.LAZY
        , cascade = [CascadeType.ALL])
    @JoinColumn(name = "project_skill_id")
    var skills: MutableList<ProjectSkill> = mutableListOf()

    fun getEndYearMonth(): String{
        if(endYear == null || endMonth == null){
            return "Present"
        }

        return "${endYear}.${endMonth}" // 2020.01
    }

    fun update(
        name: String,
        description: String,
        startYear: Int,
        endYear: Int,
        startMonth: Int,
        endMonth: Int,
        isActive: Boolean
    ){
        this.name = name
        this.description = description
        this.startYear = startYear
        this.endYear = endYear
        this.startMonth = startMonth
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(detail: MutableList<ProjectDetail>){
        if(detail != null){
            this.details.addAll(detail)
        }
    }

    fun addSkills(skills: MutableList<ProjectSkill>){
        if(skills != null){
            this.skills.addAll(skills)
        }
    }
}