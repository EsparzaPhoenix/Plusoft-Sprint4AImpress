package br.com.fiap.aimpress.repository;

import br.com.fiap.aimpress.model.curriculo.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
}
