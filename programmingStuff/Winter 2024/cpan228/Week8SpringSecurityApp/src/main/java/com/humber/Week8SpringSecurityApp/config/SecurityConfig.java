package com.humber.Week8SpringSecurityApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService){
        this.userDetailsService=userDetailsService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/library/home/**","/register/**").permitAll()
                        .requestMatchers("/library/catalogue/**").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/library/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                ).formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer.loginPage("/login").permitAll();
                })
                .logout(logout->logout.logoutUrl("/logout").logoutSuccessUrl("/library/home/").permitAll());

                //formLogin(Customizer.withDefaults());
        //for custom login
        //(form->form.loginPage("/login").permitAll());



        //comment out next 2 lines for custom login
        //http.formLogin(Customizer.withDefaults());
       // http.httpBasic(Customizer.withDefaults());
        return http.build();
}
@Bean
public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService);
    provider.setPasswordEncoder(passwordEncoder());

    return provider;

}



//@Bean
//public UserDetailsService userDetailsService(){
//
//        UserDetails admin1 = User.withUsername("Jeppy")
//                .password(passwordEncoder().encode("password"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user1 = User.withUsername("guest")
//            .password(passwordEncoder().encode("password"))
//            .roles("USER")
//            .build();
//
//    return new InMemoryUserDetailsManager(admin1,user1);
//
//}

@Bean
public WebSecurityCustomizer ignoreResources(){
        return (webSecurity)-> webSecurity.ignoring().requestMatchers("/css/**","/h2-console/**");
}

@Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
}

}
