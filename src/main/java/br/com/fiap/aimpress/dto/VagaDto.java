package br.com.fiap.aimpress.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VagaDto {
    private Long id;
    private String titulo;
    private String descricao;
    private String requisitos;
    private Long empresaId; // ID da empresa associada

    public VagaDto(long id, String titulo, String descricao, String requisitos, Long idEmpresa) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.requisitos = requisitos;
        this.empresaId = idEmpresa;
    }
}
