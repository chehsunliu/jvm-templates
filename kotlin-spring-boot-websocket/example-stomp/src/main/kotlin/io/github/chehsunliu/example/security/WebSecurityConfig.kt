package io.github.chehsunliu.example.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebSecurityConfig {
    @Bean
    @Order(5)
    fun noAuthChain(http: HttpSecurity): SecurityFilterChain {
        return configure(http)
            .securityMatcher("/")
            .authorizeHttpRequests { it.anyRequest().permitAll() }
            .build()
    }

    @Bean
    @Order(10)
    fun wsChain(http: HttpSecurity): SecurityFilterChain {
        return configure(http)
            .securityMatcher("/ws")
            .authorizeHttpRequests { it.anyRequest().permitAll() }
            .build()
    }

    @Bean
    @Order
    fun denyChain(http: HttpSecurity): SecurityFilterChain {
        return configure(http).authorizeHttpRequests { it.anyRequest().denyAll() }.build()
    }

    private fun configure(http: HttpSecurity): HttpSecurity {
        return http
            .csrf { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .logout { it.disable() }
    }
}
