package br.com.fiap.aimpress.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Desabilita CSRF para simplificação; remova em produção
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/users/register", "/webjars/**").permitAll() // Permite acesso sem autenticação à home e registro
                        .anyRequest().authenticated() // Exige autenticação para todas as outras rotas
                )
                .formLogin(form -> form
                        .loginPage("/login") // Define a página de login personalizada
                        .defaultSuccessUrl("/", true) // Redireciona para a página inicial após login bem-sucedido
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
