package com.gestion.drhkatrec.controllor;

import com.gestion.drhkatrec.entity.Automobile;
import com.gestion.drhkatrec.entity.TaxationIRV;
import com.gestion.drhkatrec.repositiry.TaxationIrvRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaxationIrvController {
    @Autowired
    private TaxationIrvRepo repo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/taxationirv")
    String automobileshow(){
        return "component/taxationIrv";
    }

    @PostMapping("/addTaxe")
    String addautomobile(@ModelAttribute TaxationIRV taxe, BindingResult result){
        if (result.hasErrors()){
            return "component/taxationIrv";
        }
        repo.save(taxe);
        return "component/taxationIrv";
    }

    @GetMapping("/index")
    public String getTaxationSum(Model model) {
        String query = "SELECT SUM(montant) FROM taxationirv WHERE devise = 'FC'";
        Double sum = jdbcTemplate.queryForObject(query, Double.class);
        model.addAttribute("sum", sum);
        String querys = "SELECT SUM(montant) FROM taxationirv WHERE devise = 'USD'";
        Double sume = jdbcTemplate.queryForObject(querys, Double.class);
        model.addAttribute("sume", sume);
        return "/index"; // Le nom de votre template Thymeleaf
    }
}
