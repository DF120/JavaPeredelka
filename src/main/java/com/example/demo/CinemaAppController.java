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
public class CinemaAppController {
    @Autowired
    private CinemaService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Cinema> cinemaList = service.listAll(keyword);
        model.addAttribute("cinemaList", cinemaList);
        model.addAttribute("keyword", keyword);
        return "index_cinema";
    }
    @RequestMapping("/new")
    public String showNewCinemaForm(Model model) {
        Cinema cinema = new Cinema();
        model.addAttribute("cinema", cinema);
        return "new_cinema";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAuto(@ModelAttribute("cinema") Cinema cinema) {
        service.save(cinema);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditAutoForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_cinema");
        Cinema cinema = service.get(id);
        mav.addObject("cinema", cinema);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteAuto(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}