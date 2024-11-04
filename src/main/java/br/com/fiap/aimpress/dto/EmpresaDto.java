package br.com.fiap.aimpress.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDto {

    private Long id;
    private String nome;
    private String cnpj;
    private String descricao;
    private String email;
    private String telefone;

}
