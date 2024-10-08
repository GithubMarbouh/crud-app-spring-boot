//package com.crudapp.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//
//
//import static com.crudapp.entity.Permission.*;
//import static com.crudapp.entity.Role.ADMIN;
//import static com.crudapp.entity.Role.MANAGER;
//import static org.springframework.http.HttpMethod.*;
//import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableMethodSecurity
//public class SecurityConfiguration {
//
//
//    private static final String[] WHITE_LIST_URL = {
//            "/api/v1/auth/**",
//            "/swagger-resources",
//            "/swagger-resources/**",
//            "/configuration/ui",
//            "/configuration/security",
//            "/swagger-ui/**",
//            "/webjars/**",
//            "/login",
//            "/authenticate",
////            "/new",
////            "/",
////            "/users"
//
//    };
//    private final JwtAuthenticationFilter jwtAuthFilter;
//    private final AuthenticationProvider authenticationProvider;
//    private final LogoutHandler logoutHandler;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(req ->
//                        req.requestMatchers(WHITE_LIST_URL).permitAll()
//                                .anyRequest().authenticated()
//                )
//                .formLogin(loginConfigurer -> loginConfigurer
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/", true)
//                )
//                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .logout(logout ->
//                        logout.logoutUrl("/api/v1/auth/logout")
//                                .addLogoutHandler(logoutHandler)
//                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
//                );
////        http
////                .csrf(AbstractHttpConfigurer::disable)
////                .authorizeHttpRequests(req ->
////                        req.requestMatchers(WHITE_LIST_URL)
//////                                .permitAll()
//////                                .requestMatchers("/api/v1/management/**").hasAnyRole(ADMIN.name(), MANAGER.name())
//////                                .requestMatchers(GET, "/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
//////                                .requestMatchers(POST, "/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
//////                                .requestMatchers(PUT, "/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
//////                                .requestMatchers(DELETE, "/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
//////                                .anyRequest()
////                                .authenticated()
////                ).formLogin(loginConfigurer -> loginConfigurer
////                .loginPage("/login")
////        )
////                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
////                .authenticationProvider(authenticationProvider)
////                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
////                .logout(logout ->
////                        logout.logoutUrl("/api/v1/auth/logout")
////                                .addLogoutHandler(logoutHandler)
////                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
////                )
////        ;
//
//        return http.build();
//
//    }
//
//
//
//
//}
