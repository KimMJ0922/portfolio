package com.kmj.portfolio.presentation.controller

import com.kmj.portfolio.domain.constant.SkillType
import com.kmj.portfolio.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PresentationViewController(
    private val presentationService: PresentationService,
) {

    @GetMapping("/test")
    fun test(): String {
        return "test"
    }

    @GetMapping("/")
    fun index(model: Model): String {
        val introductions = presentationService.getIntroductions()

        val links = presentationService.getLinks()
        model.addAttribute("introductions", introductions)
        model.addAttribute("links", links)
        return "presentation/page/index"
    }

    @GetMapping("/resume")
    fun resume(model: Model): String {
        val resume = presentationService.getResume()
        model.addAttribute("resume", resume)
        model.addAttribute("skillTypes", SkillType.entries.toTypedArray())
        return "presentation/page/resume"
    }

    @GetMapping("/projects")
    fun projects(model: Model): String {
        val projects = presentationService.getProjects()
        model.addAttribute("projects", projects)

        return "presentation/page/projects"
    }
}