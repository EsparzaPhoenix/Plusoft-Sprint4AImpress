package br.com.fiap.aimpress.repository;

import br.com.fiap.aimpress.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
