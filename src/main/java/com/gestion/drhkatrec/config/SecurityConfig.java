package com.gestion.drhkatrec.config;

import com.gestion.drhkatrec.securityweb.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//            auth.inMemoryAuthentication()
//                    .withUser("user")
//                    .password(passwordEncoder()
//                            .encode("1234")).roles("USER");
//            auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder()
//                        .encode("2345")).roles("ADMIN","USER");

            auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.formLogin().loginPage("/login").permitAll().and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/registre").permitAll();
        http.authorizeRequests().antMatchers("/UserManagement/**","/rapport/**",
                "/deletes/**","/addroles/**","/addrole/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/index/**","/user/**",
                "/adduser/**","/addusers/**").hasAuthority("USER");
        http.authorizeRequests().anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/403");
        http.exceptionHandling().accessDeniedPage("/404");

    }
}
