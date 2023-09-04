package com.gestion.drhkatrec.securityweb.service;

import com.gestion.drhkatrec.securityweb.entity.Useres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SecurityService service;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Useres user = service.loadUserByUserName(username);
        Collection<GrantedAuthority>authorities = user.getAppRoles().stream().map(
                roles -> new SimpleGrantedAuthority(roles.getRolename())
        ).collect(Collectors.toList());
        User user1 = new User(user.getUsername(), user.getPassword(), authorities);
        return user1;
    }
}
