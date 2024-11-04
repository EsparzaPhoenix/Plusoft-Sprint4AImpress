package br.com.fiap.aimpress.repository;

import br.com.fiap.aimpress.model.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByUsername(String username);

}
