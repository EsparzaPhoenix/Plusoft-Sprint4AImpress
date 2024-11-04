package br.com.fiap.aimpress.model.curriculo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.fiap.aimpress.model.enums.Carreira;
import br.com.fiap.aimpress.model.enums.NivelEscolaridade;
import br.com.fiap.aimpress.model.usuario.Usuario;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "JV_AIMPRESS_CURRICULO")
@SequenceGenerator(name ="seq_curriculo", sequenceName="seq_JV_curriculo", allocationSize=1, initialValue = 1)
public class Curriculo {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_curriculo")
    @Column(name = "id_curriculo")
    private Long id;

    @Column(name = "nm_nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "nr_telefone", length = 11, nullable = false)
    private String numeroTelefone;
    //Ex: 11936620738

    @Column(name = "ds_resumo", nullable = false, length = 300)
    private String resumo;

    @Column(name = "ds_experiencia", nullable = false, length = 300)
    private String experiencia;

    @Column(name = "nvl_escolaridade", nullable = false)
    @Enumerated(EnumType.STRING)
    private NivelEscolaridade nivelEscolaridade;

    @Column(name = "ds_carreira", nullable = false)
    @Enumerated(EnumType.STRING)
    private Carreira carreira;

    @Column(name = "ds_cursos", nullable = false, length = 300)
    private String cursos;

    @Column(name = "ds_idiomas", nullable = false, length = 300)
    private String idiomas;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Curriculo(String nome, String numeroTelefone, String resumo, String experiencia, NivelEscolaridade nivelEscolaridade, Carreira carreira, String cursos, String idiomas, Usuario usuario) {
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.resumo = resumo;
        this.experiencia = experiencia;
        this.nivelEscolaridade = nivelEscolaridade;
        this.carreira = carreira;
        this.cursos = cursos;
        this.idiomas = idiomas;
        this.usuario = usuario;
    }

}