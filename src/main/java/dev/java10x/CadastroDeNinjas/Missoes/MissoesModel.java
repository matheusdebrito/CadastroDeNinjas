package dev.java10x.CadastroDeNinjas.Missoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor // Anotation do lombok para criar construtor
@AllArgsConstructor // Anotation do lombok para criar construtor
@Data // Cria os getters e os setters
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;
    // One MissoesModel to Many NinjaModel
    @OneToMany(mappedBy = "missoes")
    private NinjaModel ninja;

}
