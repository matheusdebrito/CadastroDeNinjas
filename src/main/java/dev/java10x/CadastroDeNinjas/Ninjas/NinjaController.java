package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nesta rota";
    }

    // Adicionar ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja Criado";
    }

    // Mostrar todos os ninjas
    @GetMapping("/todos")
    public String mostrarNinjas() {
        return "Ninjas";
    }

    // Mostrar ninja por ID
    @GetMapping("/todosID")
    public String mostrarNinjasPorId() {
        return "Ninjas ID";
    }

    // Alterar dados dos ninjas
    @PutMapping("/alterarID")
    public String atualizarNinja(){
        return "alterar ninja";
    }

    // Deletar Ninja
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Deletar ninja";
    }

}
