package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/missoes")
@RestController
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id){
        MissoesDTO missao = missoesService.listarMissoesPorId(id);
        if (missao != null){
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão não encontrada. ID: " + id);
        }
    }

    @PostMapping("/criar")
    // @RequestBody significa que vai pegar a variável do body da requisição
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO missaoDTO = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso! NOME:" + missaoDTO.getNome());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        MissoesDTO missao = missoesService.atualizarMissao(id, missaoAtualizada);
        if (missao != null){
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão não encontrada. ID: " + id);
        }

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if(missoesService.listarMissoesPorId(id) != null){
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão deletada com sucesso! ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID: " + id + " Não encontrado!");
        }
    }
}
