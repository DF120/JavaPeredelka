package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutoAppController  {
    @Autowired
    private AutoService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Auto> autoList = service.listAll(keyword);
        model.addAttribute("autoList", autoList);
        model.addAttribute("keyword", keyword);
        return "index_auto";
    }
    @RequestMapping("/new")
    public String showNewAutoForm(Model model) {
        Auto auto = new Auto();
        model.addAttribute("auto", auto);
        return "new_auto";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAuto(@ModelAttribute("auto") Auto auto) {
        service.save(auto);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditAutoForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_auto");
        Auto auto = service.get(id);
        mav.addObject("auto", auto);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteAuto(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}