//////package com.example.springbootb.config;
//////
//////import org.springframework.beans.factory.annotation.Autowired;
//////import org.springframework.context.annotation.Bean;
//////import org.springframework.context.annotation.Configuration;
//////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//////import org.springframework.security.core.userdetails.UserDetailsService;
//////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//////import org.springframework.security.crypto.password.PasswordEncoder;
//////import org.springframework.security.web.SecurityFilterChain;
//////import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//////
//////@Configuration
//////@EnableWebSecurity
//////public class WebSpringSecurity {
//////    private UserDetailsService userDetailsService;
//////
//////    public WebSpringSecurity(UserDetailsService userDetailsService) {
//////        this.userDetailsService = userDetailsService;
//////    }
//////
//////    @Bean
//////    public static PasswordEncoder passwordEncoder() {
//////        return new BCryptPasswordEncoder();
//////    }
//////
//////    @Bean
//////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//////        http.csrf()
//////                .disable()
//////                .authorizeHttpRequests()
//////                .requestMatchers("/").permitAll()
//////                .requestMatchers("/register/**").permitAll()
//////                .requestMatchers("/post/**").permitAll()
//////                .requestMatchers("/admin/**").hasAnyRole("ADMIN", "GUEST")
//////                .anyRequest().authenticated()
//////        .and()
//////                .formLogin()
//////                .loginPage("/login")
//////                .loginProcessingUrl("/login")
//////                .defaultSuccessUrl("/admin/posts")
//////                .permitAll()
//////        .and()
//////                .logout()
//////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//////                .permitAll();
//////        return http.build();
//////    }
//////
//////    @Autowired
//////    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
//////        builder.userDetailsService(userDetailsService)
//////                .passwordEncoder(passwordEncoder());
//////    }
//////
//////}
////package com.example.springbootb.config;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
////
////@Configuration
////@EnableWebSecurity
////public class WebSpringSecurity {
////    private UserDetailsService userDetailsService;
////
////    public WebSpringSecurity(UserDetailsService userDetailsService) {
////        this.userDetailsService = userDetailsService;
////    }
////
////    @Bean
////    public static PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http.csrf().disable()
////                .authorizeHttpRequests()
////                .requestMatchers("/").permitAll()
////                .requestMatchers("/register/**").permitAll()
////                .requestMatchers("/post/**").permitAll()
////                .requestMatchers("/admin/**").authenticated()
////                .anyRequest().permitAll()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .loginProcessingUrl("/login")
////                .defaultSuccessUrl("/admin/posts")
////                .permitAll()
////                .and()
////                .logout()
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                .permitAll();
////        return http.build();
////    }
////
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
////        builder.userDetailsService(userDetailsService)
////                .passwordEncoder(passwordEncoder());
////    }
////}
//package com.example.springbootb.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
////@ComponentScan(basePackages = {"com.example.springbootb"})
//public class WebSpringSecurity {
//    private UserDetailsService userDetailsService;
//
//    public WebSpringSecurity(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/page/search").permitAll()
//                .requestMatchers("/feedback").permitAll()
//                .requestMatchers("/submitFeedback").permitAll()
//                .requestMatchers("/").permitAll()
//                .requestMatchers("/register/**").permitAll()
//                .requestMatchers("/post/**").permitAll()
//                .requestMatchers("/admin/**").hasAnyRole("ADMIN", "GUEST")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/admin/posts")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .permitAll();
//        return http.build();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
//        builder.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
//
//}
//


package com.example.springbootb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSpringSecurity {
    private final UserDetailsService userDetailsService;

    public WebSpringSecurity(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/page/search").permitAll()
                .antMatchers("/feedback").permitAll()
                .antMatchers("/submitFeedback").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/post/**").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN", "GUEST")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/admin/posts")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll();
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

}
