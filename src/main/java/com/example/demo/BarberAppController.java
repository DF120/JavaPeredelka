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
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Controller
public class BarberAppController {
    @Autowired
    private BarberService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Barber> barberList = service.listAll(keyword);
        model.addAttribute("barberList", barberList);
        model.addAttribute("keyword", keyword);
        return "index_barber";
    }
    @RequestMapping("/new")
    public String showNewTheaterForm(Model model) {
        Barber barber = new Barber();
        model.addAttribute("barber", barber);
        return "new_theater";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTheater(@ModelAttribute("barber") Barber barber) {
        service.save(barber);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTheaterForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_barber");
        Barber barber = service.get(id);
        mav.addObject("barber", barber);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteTheater(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
