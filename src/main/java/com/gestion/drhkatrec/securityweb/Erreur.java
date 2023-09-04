package com.gestion.drhkatrec.securityweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Erreur {

    @GetMapping("/403")
    public String error403(){
        return "erreur/403";
    }

    @GetMapping("/404")
    public String error404(){
        return "erreur/403";
    }
    @GetMapping("/405")
    public String error405(){
        return "erreur/403";
    }


}
