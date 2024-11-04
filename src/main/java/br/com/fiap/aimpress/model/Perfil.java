package br.com.fiap.aimpress.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Table(name = "JV_AIMPRESS_PERFIL")
@Getter @Setter
public class Perfil {

    @Id
    @GeneratedValue
    @Column(name = "cd_role")
    private Long id;

    @Column(name = "nm_perfil", nullable = false, unique = true)
    private String name;

    @Column(name = "ds_label", nullable = false)
    private String label;

}