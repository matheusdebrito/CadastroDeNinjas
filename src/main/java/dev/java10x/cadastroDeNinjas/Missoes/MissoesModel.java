package dev.java10x.cadastroDeNinjas.Missoes;


import dev.java10x.cadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private MissaoDificuldade dificuldade;
    @OneToMany(mappedBy = "missoes") // Uma missão pode ter vários ninjas (One missao To Many ninjas)
    private List<NinjaModel> ninjas;

}
