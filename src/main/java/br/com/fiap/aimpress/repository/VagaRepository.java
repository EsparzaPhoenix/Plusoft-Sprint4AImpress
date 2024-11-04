package br.com.fiap.aimpress.repository;

import br.com.fiap.aimpress.model.vaga.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
