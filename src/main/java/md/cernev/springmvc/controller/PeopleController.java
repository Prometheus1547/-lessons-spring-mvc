package md.cernev.springmvc.controller;

import md.cernev.springmvc.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PersonDao personDao;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDao.getAllPeople());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDao.getPerson(id));
        return "people/show";
    }
}
