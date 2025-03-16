package com.kmj.portfolio.domain.repository

import com.kmj.portfolio.domain.entity.Experience
import com.kmj.portfolio.domain.entity.ExperienceDetail
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest(
    @Autowired val experienceRepository: ExperienceRepository
) {
    val DATA_SIZE = 10

    private fun createExperience(n: Int): Experience {
        var experience = Experience(
            title = "$n",
            description = "테스트 설명${n}",
            startYear = 2018,
            startMonth = 9,
            endYear = 2022,
            endMonth = 8,
            isActive = true
        )

        val details = mutableListOf<ExperienceDetail>()

        for(i in 1..n){
            val experienceDetail = ExperienceDetail(
                content = "테스트${i}",
                isActive = true
            )

            details.add(experienceDetail)
        }

        experience.addDetails(details)

        return experience
    }

    @BeforeAll
    fun beforeAll() {
        println("--- 데이터 초기화 이전 조회 시작 ---")
        val beforeInitialize = experienceRepository.findAll()
        assertThat(beforeInitialize).hasSize(0)
        println("--- 데이터 초기화 이전 조회 종료 ---")

        println("--- 데이터 초기화 시작 ---")
        val experiences = mutableListOf<Experience>()

        for(i in 1..DATA_SIZE){
            var experience = createExperience(i)
            experiences.add(experience)
        }

        experienceRepository.saveAll(experiences)
        println("--- 데이터 초기화 종료 ---")
    }

    @Test
    fun testFindAll(){
        println("--- findAll 테스트 시작 ---")

        var experiences = experienceRepository.findAll()
        assertThat(experiences).hasSize(DATA_SIZE)

        println("experiences.size=${experiences.size}")

        for (experience in experiences) {
            assertThat(experience.details).hasSize(experience.title.toInt())
            println("experience.details.size=${experience.details.size}")
        }
        println("--- findAll 테스트 종료 ---")
    }

    @Test
    fun testFindAllByIsActive(){
        println("--- testFindAllByIsActive 테스트 시작 ---")

        var experiences = experienceRepository.findAllByIsActive(true)
        assertThat(experiences).hasSize(DATA_SIZE)

        println("experiences.size=${experiences.size}")

        for (experience in experiences) {
            assertThat(experience.details).hasSize(experience.title.toInt())
            println("experience.details.size=${experience.details.size}")
        }
        println("--- testFindAllByIsActive 테스트 종료 ---")
    }
}