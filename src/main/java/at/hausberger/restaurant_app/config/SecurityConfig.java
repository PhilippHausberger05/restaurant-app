package at.hausberger.restaurant_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/gerichte/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/kunden").permitAll()
                        .requestMatchers(HttpMethod.GET, "/kunden").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/gerichte").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/gerichte/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/gerichte/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/bestellungen/*/status").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}