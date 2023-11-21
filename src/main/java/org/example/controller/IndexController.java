package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    public IndexController() {
        System.out.println("IndexController");
    }

    // GET /index
    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String index() {
        System.out.println("HTTP -> GET: /index");
        return "index";
    }

    // GET /sum?n1=10&n2=10
    @GetMapping("/sum")
    public String sum(@RequestParam("n1") int n1, @RequestParam("n2") int n2, Model model) {
        model.addAttribute("message",
                String.format("Sum of %d and %d = %d", n1, n2, (n1 + n2)));
        return "result";
    }

    @GetMapping("/prod")
    public ModelAndView prod(@RequestParam("n1") int n1, @RequestParam("n2") int n2) {
        ModelAndView mv = new ModelAndView("result");
        mv.addObject("message",
                String.format("Product of %d and %d = %d", n1, n2, (n1 * n2))
        );
        return mv;
    }
}
