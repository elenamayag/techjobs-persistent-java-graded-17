package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Skill");
            model.addAttribute("skill", new Skill());
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }

    @GetMapping("view/{skillID}")
    public String displayViewSkill(Model model, @PathVariable int skillID) {

        Optional optSkill = skillRepository.findById(skillID);
        if (optSkill.isPresent()) {
            Skill skill = (Skill) optSkill.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            return "redirect:../";
        }

    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }
}