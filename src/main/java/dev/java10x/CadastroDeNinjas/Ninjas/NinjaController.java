package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ninjaDTO.getNome() + " Criado com sucesso! ID: " + ninjaDTO.getId());
    }

    // Mostrar todos os ninjas
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {

        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);

        if (ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado! ID: " + id);
        }
    }

    // Alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado. ID: " + id);
        }
    }

    // Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja Deletado com sucesso! ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o ID: " + id + " não foi encontrado!");
        }
    }

}
