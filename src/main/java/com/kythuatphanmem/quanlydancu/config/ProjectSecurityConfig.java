package com.kythuatphanmem.quanlydancu.config;

import com.kythuatphanmem.quanlydancu.filter.JwtTokenGeneratorFilter;
import com.kythuatphanmem.quanlydancu.filter.JwtTokenValidatorFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                })
                .and()
                .csrf().disable()
                .addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers("/api/**").authenticated()
                .requestMatchers("/register").permitAll()
                        .and().formLogin()
                        .and().httpBasic();
        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsServices() {
//        // Approach 1
////        UserDetails admin = User.withDefaultPasswordEncoder()
////                .username("admin")
////                .password("juniper@123")
////                .authorities("admin")
////                .build();
////        UserDetails user = User.withDefaultPasswordEncoder()
////                .username("user")
////                .password("juniper@123")
////                .authorities("user")
////                .build();
//        // Approach 2
//        UserDetails admin = User.withUsername("admin")
//                .password("juniper@123")
//                .authorities("admin")
//                .build();
//        UserDetails user = User.withUsername("user")
//                .password("juniper@123")
//                .authorities("user")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
