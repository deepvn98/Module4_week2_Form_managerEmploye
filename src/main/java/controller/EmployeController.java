package controller;

import model.Employe;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Configuration
@RequestMapping("employe/")
public class EmployeController {

    @RequestMapping(value = "showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employe());
        return "employe/create";
    }

    @RequestMapping(value = "addEmploye", method = RequestMethod.POST)
    public String submit(@ModelAttribute("employe") Employe employe, ModelMap model) {
        model.addAttribute("name", employe.getName());
        model.addAttribute("contactNumber", employe.getPhone());
        model.addAttribute("id", employe.getId());
        return "employe/info";
    }
}