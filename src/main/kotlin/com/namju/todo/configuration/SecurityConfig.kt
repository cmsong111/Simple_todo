package com.namju.todo.configuration

import com.namju.todo.auth.AuthenticationService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableMethodSecurity
class SecurityConfig(
    private val userService: AuthenticationService
) {

    private val WHITELIST: List<String> = listOf(
        "/",
        "/auth/**",
        "/favicon.ico",
    )

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        http
            .csrf { csrf -> csrf.disable() }
            .userDetailsService(userService)
            .formLogin { login ->
                login
                    .loginPage("/")
                    .loginProcessingUrl("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/todo", true)
                    .failureUrl("/")
                    .permitAll()
            }
            .logout { logout ->
                logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .permitAll()
                    .invalidateHttpSession(true)
            }
            .authorizeHttpRequests { req ->
                req
                    .requestMatchers(*WHITELIST.toTypedArray()).permitAll()
                    .anyRequest().authenticated()
            }

        return http.build()
    }
}

