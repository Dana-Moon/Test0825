package org.example.testAugust.controller;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.entity.Brand;
import org.example.testAugust.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/brand")
@RequiredArgsConstructor
@Controller
public class brandController {

    private final BrandService brandService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Brand> brandList = this.brandService.getList();
        model.addAttribute("brandList", brandList);
        return "brandList";
    }
}
