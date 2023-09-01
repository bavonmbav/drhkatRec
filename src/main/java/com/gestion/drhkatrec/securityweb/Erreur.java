package com.gestion.drhkatrec.securityweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Erreur {

    @GetMapping("/403")
    public String error403(){
        return "erreur/403";
    }



}
