package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity // Transforma a classe em uma entidade. (Precisa do JPA como dependência.)
@Table(name = "tb_cadastro") // Da um nome para a tabela.
@NoArgsConstructor // Anotation do lombok para criar construtor
@AllArgsConstructor // Anotation do lombok para criar construtor
@Data // Cria os getters e os setters
@Setter
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imagemUrl;

    @Column(name = "rank")
    private String rank;

    @Column(name = "idade")
    private int idade;

    // Many NinjaModel to One MissoesModel
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

    public void setId(Long id){
        this.id = id;
    }

}
