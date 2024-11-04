package br.com.fiap.aimpress.dto;

import br.com.fiap.aimpress.model.enums.Carreira;
import br.com.fiap.aimpress.model.enums.NivelEscolaridade;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurriculoDto {

    private Long id;
    private String nome;
    private String numeroTelefone;
    private String resumo;
    private String experiencia;
    private NivelEscolaridade nivelEscolaridade;
    private Carreira carreira;
    private String cursos;
    private String idiomas;
    private Long usuarioId;

}