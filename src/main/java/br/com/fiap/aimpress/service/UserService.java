package br.com.fiap.aimpress.service;

import br.com.fiap.aimpress.model.user.User;
import br.com.fiap.aimpress.model.Perfil;
import br.com.fiap.aimpress.repository.UserRepository;
import br.com.fiap.aimpress.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Injeção do PasswordEncoder

    public void saveUser(String username, String password, String email, Set<String> perfilNames) {
        Set<Perfil> perfis = new HashSet<>();
        for (String perfilName : perfilNames) {
            Perfil perfil = perfilRepository.findByName(perfilName);
            if (perfil != null) {
                perfis.add(perfil);
            }
        }

        // Criptografa a senha antes de salvar
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(username, encodedPassword, email, perfis);

        userRepository.save(user);
    }
}