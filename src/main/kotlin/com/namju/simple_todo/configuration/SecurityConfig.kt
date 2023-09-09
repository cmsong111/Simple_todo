package com.namju.simple_todo.configuration

import com.namju.simple_todo.user.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableMethodSecurity
class SecurityConfig(
    private val userService: UserService
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        http
            .csrf().disable()
            .userDetailsService(userService)
            .authorizeHttpRequests()
            .anyRequest().permitAll()
            .and()
            .formLogin()
            .loginPage("/")
            .loginProcessingUrl("/login_proc")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/todo")
            .failureUrl("/?error=true")
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .deleteCookies("JSESSIONID")

        return http.build()
    }
}

