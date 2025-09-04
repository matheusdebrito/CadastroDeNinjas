package dev.java10x.CadastroDeNinjas.Missoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor // Anotation do lombok para criar construtor
@AllArgsConstructor // Anotation do lombok para criar construtor
@Data // Cria os getters e os setters
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dificuldade")
    private String dificuldade;


    // One MissoesModel to Many NinjaModel
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;

}
