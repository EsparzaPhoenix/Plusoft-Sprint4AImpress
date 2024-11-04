package br.com.fiap.aimpress.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/**") // Configura a aplicação para interceptar todas as requisições
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/users/register").permitAll() // Permite acesso a login e registro
                        .anyRequest().authenticated() // Exige autenticação para todas as outras requisições
                )
                .formLogin(form -> form
                        .loginPage("/login") // Define a página de login personalizada
                        .defaultSuccessUrl("/", true) // Redireciona para a página inicial após login bem-sucedido
                        .permitAll() // Permite acesso ao formulário de login
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Define o endpoint de logout
                        .logoutSuccessUrl("/login") // Redireciona para a página de login após logout
                        .permitAll() // Permite acesso ao logout
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
