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
public class WarehouseAppController {
    @Autowired
    private WarehouseService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Warehouse> warehouseList = service.listAll(keyword);
        model.addAttribute("warehouseList", warehouseList);
        model.addAttribute("keyword", keyword);
        return "index_warehouse";
    }
    @RequestMapping("/new")
    public String showNewWarehouseForm(Model model) {
        Warehouse warehouse = new Warehouse();
        model.addAttribute("warehouse", warehouse);
        return "new_warehouse";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveWarehouse(@ModelAttribute("warehouse") Warehouse warehouse) {
        service.save(warehouse);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditWarehouseForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_warehouse");
        Warehouse warehouse = service.get(id);
        mav.addObject("warehouse", warehouse);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteWarehouse(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
