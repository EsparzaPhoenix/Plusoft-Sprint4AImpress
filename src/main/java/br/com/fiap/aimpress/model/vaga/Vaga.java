package br.com.fiap.aimpress.model.vaga;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.fiap.aimpress.model.empresa.Empresa;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JV_AIMPRESS_VAGAS")
@SequenceGenerator(name="seq_vagas", sequenceName="seq_JV_vagas", allocationSize=1, initialValue = 1)
public class Vaga {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_vagas")
    @Column(name = "id_vaga")
    private long id;

    @Column(name = "titulo_vagas", nullable = false, length = 50)
    private String titulo;

    @Column(name = "dsc_vagas", nullable = false, length = 300)
    private String descricao;

    @Column(name = "requisitos_vagas",nullable = false, length = 100)
    private String requisitos;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Vaga(String titulo, String descricao, String requisitos, Empresa empresa) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.requisitos = requisitos;
        this.empresa = empresa;
    }
}