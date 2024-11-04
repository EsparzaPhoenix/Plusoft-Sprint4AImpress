package br.com.fiap.aimpress.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String telefone;
    private LocalDate dataNascimento;
    private List<Long> curriculosIds;
}
