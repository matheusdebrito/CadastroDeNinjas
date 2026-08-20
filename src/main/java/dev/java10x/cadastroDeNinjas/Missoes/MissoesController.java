package dev.java10x.cadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // Adicionar Missao (CREATE)
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada";
    }

    // Mostrar Todos os Missoes (READ)

    @GetMapping("/todas")
    public String mostrarTodasAsMissoes(){
        return "Todas";
    }

    // Procurar Missao por id (READ)
    @GetMapping("/todasID")
    public String mostrarTodasAsMissoesPorId(){
        return "Missao por id";
    }

    // Alterar dados dos Missoes (UPDATE)
    @PutMapping("/alterarID")
    public String alterarMissaoPorId(){
        return "Missao alterada";
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarMissaoPorId(){
        return "Missao deletada";
    }
}
