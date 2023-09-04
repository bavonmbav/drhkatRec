package com.gestion.drhkatrec;

import com.gestion.drhkatrec.securityweb.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gestion.drhkatrec")
public class DrhkatRecApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrhkatRecApplication.class, args);
    }

    //chager dans la base de donnees au lancement de l'application
  //  @Bean
//    CommandLineRunner saveUser(SecurityService service){
//        return args -> {
//
//            service.saveUser("gabriel", "4567", "4567");
//            service.saveUser("evelyne", "2345", "2345");
//            service.saveUser("passy", "2345", "2345");
//
////            service.saveRole("USER","");
////            service.saveRole("ADMIN","");
//
//
//            service.addRoletoUser("gabriel", "ADMIN");
//            service.addRoletoUser("evelyne", "USER");
//            service.addRoletoUser("passy", "USER");
//            service.addRoletoUser("bavon", "USER");
//            service.addRoletoUser("gabriel", "USER");
//
//
//
//        };
//    }
}
