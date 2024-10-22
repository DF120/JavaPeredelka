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
public class KonfAppController {
    @Autowired
    private KonfService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Konf> konfList = service.listAll(keyword);
        model.addAttribute("konfList", konfList);
        model.addAttribute("keyword", keyword);
        return "index_konf";
    }
    @RequestMapping("/new")
    public String showNewBookForm(Model model) {
        Konf konf = new Konf();
        model.addAttribute("konf", konf);
        return "new_konf";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("konf") Konf konf) {
        service.save(konf);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBookForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_konf");
        Konf konf = service.get(id);
        mav.addObject("konf", konf);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
