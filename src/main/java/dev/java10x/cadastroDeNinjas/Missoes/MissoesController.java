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

    @GetMapping("/listar")
    public String mostrarTodasAsMissoes(){
        return "Todas";
    }

    // Alterar dados dos Missoes (UPDATE)
    @PutMapping("/alterar")
    public String alterarMissaoPorId(){
        return "Missao alterada";
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/deletar")
    public String deletarMissaoPorId(){
        return "Missao deletada";
    }
}
