package com.gestion.drhkatrec.securityweb.service;

import com.gestion.drhkatrec.entity.Users;
import com.gestion.drhkatrec.securityweb.entity.Roles;
import com.gestion.drhkatrec.securityweb.entity.Useres;
import com.gestion.drhkatrec.securityweb.repository.AppRoleRepository;
import com.gestion.drhkatrec.securityweb.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl implements SecurityService {
    @Autowired
   private AppRoleRepository appRoleRepository;
    @Autowired
   private AppUserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Useres saveUser(String username, String password, String stpassword) {
        if (!password.equals(stpassword)) throw new RuntimeException("mot de passe incorect");
        String haspass = passwordEncoder.encode(password);
        Useres users = new Useres();
        users.setUsername(username);
        users.setUsername_Id(UUID.randomUUID().toString());
        users.setPassword(haspass);
        users.setActive(true);
     Useres useresave =  userRepository.save(users);
        return useresave;
    }

    @Override
    public Roles saveRole(String rolename, String description) {
        Roles roles = appRoleRepository.findByRolename(rolename);
        if (roles != null) throw new RuntimeException("role " + rolename + "ar");

         roles = new Roles();
        roles.setRolename(rolename);
        roles.setDescription(description);
       Roles role =  appRoleRepository.save(roles);

        return role;
    }

    @Override
    public void addRoletoUser(String username, String rolename) {

        Useres use = userRepository.findByUsername(username);
        if (use == null) throw new RuntimeException("utilisateur n'existe pas ");

        Roles roles = appRoleRepository.findByRolename(rolename);
        if (roles == null) throw new RuntimeException("utilisateur n'existe pas ");

        use.getAppRoles().add(roles);


    }

    @Override
    public void removeRoleforUser(String username, String rolename) {

        Useres use = userRepository.findByUsername(username);
        if (use == null) throw new RuntimeException("utilisateur n'existe pas ");

        Roles roles = appRoleRepository.findByRolename(rolename);
        if (roles == null) throw new RuntimeException("utilisateur n'existe pas ");

        use.getAppRoles().remove(roles);

    }

    @Override
    public Useres loadUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
