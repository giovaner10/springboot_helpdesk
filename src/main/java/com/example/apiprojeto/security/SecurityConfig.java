package com.example.apiprojeto.security;

import com.example.apiprojeto.bean.JWTUtil;
import com.example.apiprojeto.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService service;
    private JWTUtil jwtUtil;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, service));
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**/admin/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                .formLogin()
                .and()
                .httpBasic();



    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {



        auth.inMemoryAuthentication()
                .withUser("giovane")
                .password(bCryptPasswordEncoder().encode("8718"))
                .roles("USER", "ADMIN");
        auth.inMemoryAuthentication()
                .withUser("rizia")
                .password(bCryptPasswordEncoder().encode("pim"))
                .roles("USER" );

       auth.userDetailsService(this.service).passwordEncoder(bCryptPasswordEncoder());
       log.info(bCryptPasswordEncoder().encode("apache"));

    }

    /*@Bean
    CorsConfigurationSource corsConfigurationSource (){
        CorsConfiguration corsConfiguration  = new CorsConfiguration().applyPermitDefaultValues();
        corsConfiguration.setAllowedMethods(Arrays.asList("POST", "PUT", "DELETE", "OPTIONS"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }*/

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder (){
        return new BCryptPasswordEncoder();
    }



}
