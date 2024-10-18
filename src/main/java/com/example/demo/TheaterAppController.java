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
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class TheaterAppController {
    @Autowired
    private TheaterService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Theater> theaterList = service.listAll(keyword);
        model.addAttribute("theaterList", theaterList);
        model.addAttribute("keyword", keyword);
        return "index_theater";
    }
    @RequestMapping("/new")
    public String showNewTheaterForm(Model model) {
        Theater theater = new Theater();
        model.addAttribute("theater", theater);
        return "new_theater";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTheater(@ModelAttribute("theater") Theater theater) {
        service.save(theater);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTheaterForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_theater");
        Theater theater = service.get(id);
        mav.addObject("theater", theater);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteTheater(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
    @RequestMapping("/countByDate")
    public String countByDate(Model model, @Param("date") String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date);  // Преобразуем строку в LocalDateTime
        int count = service.countByDate(dateTime);
        model.addAttribute("count", count);
        return "index_theater";  // Или нужная страница для отображения
    }


}
