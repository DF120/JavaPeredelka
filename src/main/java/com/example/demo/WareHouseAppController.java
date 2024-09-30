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
public class WareHouseAppController {
    @Autowired
    private WareHouseService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<WareHouse> wareHouseList = service.listAll(keyword);
        model.addAttribute("wareHouseList", wareHouseList);
        model.addAttribute("keyword", keyword);
        return "index_wareHouse";
    }
    @RequestMapping("/new")
    public String showNewWareHouseForm(Model model) {
        WareHouse wareHouse = new WareHouse();
        model.addAttribute("wareHouse", wareHouse);
        return "new_wareHouse";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveWareHouse(@ModelAttribute("wareHouse") WareHouse wareHouse) {
        service.save(wareHouse);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditWareHouseForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_wareHouse");
        WareHouse wareHouse = service.get(id);
        mav.addObject("wareHouse", wareHouse);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteWareHouse(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
