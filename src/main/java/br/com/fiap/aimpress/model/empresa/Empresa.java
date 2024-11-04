package br.com.fiap.aimpress.model.empresa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "JV_AIMPRESS_EMPRESA")
@SequenceGenerator(name="seq_empresa", sequenceName="seq_JV_empresa", allocationSize=1, initialValue = 1)
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empresa")
    @Column(name = "id_empresa")
    private Long id;

    @Column(name = "nm_empresa", nullable = false, length = 50)
    private String nome;

    @Column(name = "cnpj_empresa", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "dsc_empresa", nullable = false, length = 100)
    private String descricao;

    @Column(name = "email_empresa", nullable = false, length = 70)
    private String email;

    @Column(name = "telefone_empresa", nullable = false, length = 11)
    private String telefone;
    //Ex: 11936620738

    public Empresa(String nome, String cnpj, String descricao, String email, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.email = email;
        this.telefone = telefone;
    }

}

