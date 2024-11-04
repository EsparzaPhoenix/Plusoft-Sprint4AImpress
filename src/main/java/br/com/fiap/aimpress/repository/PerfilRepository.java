package br.com.fiap.aimpress.repository;

import br.com.fiap.aimpress.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Perfil findByName(String name);

}
