package controller;


import model.Employe;
import model.EmployeFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.IEmployeService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class EmployeController {


    @Autowired
    private IEmployeService employeService;
    @Autowired
    Environment environment;
//    @Value("${fileUpload}")
//    private String fileUpload;


    @GetMapping("Show")
    public ModelAndView showAllEmploye(){
        ModelAndView modelAndView = new ModelAndView("Lists");
        List<Employe> employes = employeService.findAll();
        modelAndView.addObject("E",employes);
        return modelAndView;
    }

    @GetMapping("Create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("employe",new EmployeFileUpload());
        return modelAndView;
    }

    @PostMapping("Create")
    public String create(EmployeFileUpload employeFileUpload){
//   coppy file
        MultipartFile multipartFile = employeFileUpload.getImg();
        String nameFile = multipartFile.getOriginalFilename();
        String localFile = environment.getProperty("fileUpload");

        try {
            FileCopyUtils.copy(multipartFile.getBytes(),new File(localFile+nameFile));
//            FileCopyUtils.copy(multipartFile.getBytes(),new File((fileUpload +nameFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Employe employe = new Employe();
        employe.setId((int) (Math.random()*1000));
        employe.setName(employeFileUpload.getName());
        employe.setPhone(employeFileUpload.getPhone());
        employe.setImg(nameFile);
        employeService.save(employe);
        return "redirect:Show";

    }

}
