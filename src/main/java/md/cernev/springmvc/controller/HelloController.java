package md.cernev.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/helloworld")
    public String hello(@RequestParam(name = "fname", required = false) String fname, @RequestParam(name = "sname", required = false) String sname, Model model) {
//        System.out.println(fname+" "+sname);
        model.addAttribute("message", fname + " " + sname);
        return "first/hello";

    }

    @GetMapping("/calc")
    public String calc(@RequestParam("a") int a,
                       @RequestParam("b") int b,
                       @RequestParam("action") String action,
                       Model model) {
        int sum;
        switch (action) {
            case "mul":
                sum = a * b;
                break;
            case "add":
                sum = a + b;
                break;
            case "sub":
                sum = a - b;
                break;
            case "div":
                sum = a / b;
                break;
            default:
                sum = 0;
        }
        model.addAttribute("sum", sum);
        return "first/calculate";
    }
}
