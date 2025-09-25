package dev.java10x.CadastroDeNinjas.Ninjas;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nesta rota";
    }

    // Adicionar ninja
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja"),
    })
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
    @Operation(summary = "Lista um ninja pelo ID", description = "rota lista um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado"),
    })
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
    @Operation(summary = "Altera um ninja pelo seu ID", description = "Altera um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Ninja não encontrado"),
    })
    public ResponseEntity<?> atualizarNinja(
            @Parameter(description = "Usuário manda o ID pelo caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado){
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
