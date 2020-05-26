package com.mk.Controller;

import com.mk.Entity.City;
import com.mk.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/City")
public class WorldController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/all")
    public String getAllCity(Model model){
        List<City> cityList = cityService.getAllCity();
        model.addAttribute("cityList",cityList);
        return "city";
    }
    @RequestMapping("/id")
    public String getCityById(@RequestParam("cityId") String id,Model model){
        if (id.trim().equals("")) return "index";
        List<City> cityList = cityService.getCityById(Integer.parseInt(id));
        model.addAttribute("cityList",cityList);
        return "city";
    }



}
