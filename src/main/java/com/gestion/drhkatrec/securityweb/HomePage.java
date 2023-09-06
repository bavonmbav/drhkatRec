package com.gestion.drhkatrec.securityweb;

import com.gestion.drhkatrec.entity.Users;
import com.gestion.drhkatrec.securityweb.entity.Roles;
import com.gestion.drhkatrec.securityweb.entity.Useres;
import com.gestion.drhkatrec.securityweb.service.SecurityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomePage {
@Autowired
private SecurityServiceImpl service;
    @GetMapping("/")
    public String home(){
        return "/home";
    }

    @GetMapping("/login")
    public String login(){
        User user = getprincipale();
        if (user != null){
            return "/index";
        }
        return "securityweb/login";
    }
    private  User getprincipale(){
        User user = null;
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User)
        {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        return user;
    }

    @GetMapping("/registre")
    public String registre(){
        return "securityweb/register";
    }

    @PostMapping("/registre")
    public String saveUser(@ModelAttribute Useres useres, BindingResult result){
        if (result.hasErrors()){
            return "securityweb/login";
        }
        String stpasse = useres.getPassword();
        service.saveUser(useres.getUsername(), useres.getPassword(), useres.getEmail(), stpasse);
        service.addRoletoUser(useres.getUsername(), "USER");
        return "securityweb/login";
    }
    public ArrayList<Useres> useres;
    @GetMapping("/UserManagement")
    public String index(Model model) {
        useres = service.findAll();
        model.addAttribute("users", useres);
        return "securityweb/UserManagement";
    }


    @PostMapping("/deletes/{id}")
    public String deletes(@PathVariable String id) {
        Optional<Useres> student = service.findById(id);
        if (student.isEmpty()) {
            return "redirect:/UserManagement";
        }
        service.delete(student.get());
        return "redirect:/UserManagement";
    }

    //ajouter un role a un utilisateur

    @PostMapping("/addroles")
    public String addrole(@ModelAttribute Useres useres, BindingResult result){
        Roles roles = new Roles();
        useres = new Useres();
        if (result.hasErrors()){
            return "redirect:/UserManagement";
        }
        service.addRoletoUser(useres.getUsername(), roles.getRolename());
        return "redirect:/UserManagement";
    }
    @GetMapping("/addrole")
    public String addrol(Model model)
    {
        List<Useres> usersList = service.findAll();
        model.addAttribute("users", usersList);
        List<Roles> RoleList = service.findAlls();
        model.addAttribute("rol", RoleList);

        return "securityweb/addrole";
    }


}
