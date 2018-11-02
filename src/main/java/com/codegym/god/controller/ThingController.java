package com.codegym.god.controller;

import com.codegym.god.model.Thing;
import com.codegym.god.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThingController {

    @Autowired
    private ThingService thingService;

    @GetMapping("/thing/s")
    public ModelAndView listThings(){
        Iterable<Thing> things = thingService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("things", things);
        return modelAndView;
    }

    @GetMapping("/thing")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("thing", new Thing());
        return modelAndView;
    }

    @PostMapping("/thing")
    public ModelAndView saveThing(@ModelAttribute("thing") Thing thing) {
        thingService.save(thing);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("thing", new Thing());
        modelAndView.addObject("message", "New thing created successfully");
        return modelAndView;
    }

    @GetMapping("/thing/{id}")
    public ModelAndView viewCreateForm(@PathVariable Long id){
        Thing thing = thingService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/view");
            modelAndView.addObject("thing", thing);
            return modelAndView;
    }
}
