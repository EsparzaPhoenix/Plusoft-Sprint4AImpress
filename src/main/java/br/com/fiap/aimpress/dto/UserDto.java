package br.com.fiap.aimpress.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String password;
    private Set<String> perfis; // Lista de perfis por nome
}

