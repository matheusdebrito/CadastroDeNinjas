package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController("missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missões listadas com sucesso";
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }
}
