package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity // Transforma a classe em uma entidade. (Precisa do JPA como dependência.)
@Table(name = "tb_cadastro") // Da um nome para a tabela.
@NoArgsConstructor // Anotation do lombok para criar construtor
@AllArgsConstructor // Anotation do lombok para criar construtor
@Data // Cria os getters e os setters
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;
    // Many NinjaModel to One MissoesModel
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

}
