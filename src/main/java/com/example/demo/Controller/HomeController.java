package com.example.demo.Controller;

import com.example.demo.Domain.English;
import com.example.demo.Domain.Test;
import com.example.demo.Service.EnglishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class HomeController {

    //ArrayList<English> e = new ArrayList<>();

    private EnglishService englishService;
    @Autowired
    public void setHomeService(EnglishService englishService) {
        this.englishService = englishService;
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index(Model model) throws Exception {
        System.out.println("index");
        return "index";
    }
    @RequestMapping(value = "/content.html", method = RequestMethod.GET)
    public String content(Model model) throws Exception {
        model.addAttribute("english", englishService.getEnglish());
        System.out.println("content");
        return "content";
    }
    @RequestMapping(value = "/statistics.html", method = RequestMethod.GET)
    public String statistics(Model model) throws Exception {
        model.addAttribute("test", englishService.getTest());
        System.out.println("statistics");
        return "statistics";
    }
    @RequestMapping(value = "/success.html", method = RequestMethod.GET)
    public String success(Model model) throws Exception {
        model.addAttribute("english", englishService.getEnglish());
        model.addAttribute("currentTest", EnglishService.currenrtTest);
        model.addAttribute("currentCorrect", EnglishService.currenrtCorrect);
        System.out.println("success");
        return "success";
    }


        @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(@RequestParam String tipp, @RequestParam String name) throws IOException {
            System.out.println(tipp);
            englishService.getTipp(tipp,name);
        return "redirect:/success.html";
    }




}
