package org.mvc.controller;

import org.mvc.entity.AdditionalMaterial;
import org.mvc.service.AdditionalMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdditionalMaterialController {
    private final AdditionalMaterialService materialService;

    @Autowired
    public AdditionalMaterialController(AdditionalMaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping("/add")
    public String addAddMaterial(@RequestParam String name,
                                 @RequestParam Integer lectureId) {
        AdditionalMaterial material = new AdditionalMaterial();
        material.setName(name);
        material.setLectureId(lectureId);
        materialService.save(name, lectureId);
        return "redirect:/all-students";
    }
}
