package com.gestion.drhkatrec.securityweb.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserNotFoundException extends UsernameNotFoundException {
    public CustomUserNotFoundException(String s) {
        super(s);
    }
}
