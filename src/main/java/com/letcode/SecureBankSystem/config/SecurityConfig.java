package com.letcode.SecureBankSystem.config;

import com.letcode.SecureBankSystem.service.auth.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@EnableWebSecurity
@Configuration   ///put all the settings

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String AUTH_PATH = "/api/v1/auth/**";
    public static final String USER_PATH = "/api/v1/user/**";

    public static final String ADMIN_PATH = "/api/v1/user/**";

    private static final List<String> ALLOWED_METHODS = Arrays.asList("GET", "PUT", "POST", "DELETE", "OPTION", "PATCH"); //PUT update the whole entity PATCH can update one thing
    private static final List<String> ALLOWED_HEADERS = Arrays.asList("x-request-with", "authorization", "Content-Type", "Authorization", "credential", "X-XSRF-TOKEN", "X-Refresh-Token", "X-Client-Id", "x-clinet-id");


    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling()
                .and()
                .httpBasic().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .configurationSource(request -> getCorsConfiguration())
                .and()
                .authorizeRequests()
                .antMatchers(AUTH_PATH).permitAll()
                .antMatchers(USER_PATH).hasAuthority("user")
                .antMatchers(ADMIN_PATH).hasAuthority("admin")
                .anyRequest().authenticated();
        http.addFilterBefore(new JWTAuthFillter(jwtUtil,userDetailsService), UsernamePasswordAuthenticationFilter.class);
    }

    private CorsConfiguration getCorsConfiguration(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(ALLOWED_HEADERS);
        corsConfiguration.setAllowedHeaders(ALLOWED_METHODS);
        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }


    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }




}
