package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nesta rota";
    }

    // Adicionar ninja
    @PostMapping("/criar")
    // @RequestBody significa que vai pegar a variável do body da requisição
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por ID
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    // Alterar dados dos ninjas
    @PutMapping("/alterarID")
    public String atualizarNinja(){
        return "alterar ninja";
    }

    // Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }

}
