package br.com.fiap.aimpress.model.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.fiap.aimpress.model.curriculo.Curriculo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "JV_AIMPRESS_USUARIO")
@SequenceGenerator(name="seq_usuario", sequenceName="seq_JV_usuario", allocationSize=1, initialValue = 1)
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_usuario")
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nm_usuario", nullable = false, length = 50)
    private String name;

    @Column(name = "email_usuario", nullable = false, length = 70)
    private String email;

    @Column(name = "cpf_usuario", nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(name = "nr_telefone", nullable = false, length = 11)
    private String telefone;
    //Ex: 11936620738

    @Column(name="dt_nascimento")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Curriculo> curriculos = new ArrayList<>();

    public Usuario(String name, String email, String cpf, String telefone, LocalDate dataNascimento) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }
}