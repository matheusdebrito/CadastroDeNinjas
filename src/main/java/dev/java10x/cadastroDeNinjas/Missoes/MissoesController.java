package dev.java10x.cadastroDeNinjas.Missoes;

import dev.java10x.cadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar Missao (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<?> criarMissao(@RequestBody MissoesDTO missaoDTO) {
        MissoesDTO novaMissao = missoesService.criarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novaMissao);
    }

    // Mostrar Todos os Missoes (READ)

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> mostrarTodasAsMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id){
        MissoesDTO missao =  missoesService.listarMissoesPorId(id);
        if(missao!= null){
            return ResponseEntity.ok()
                    .body(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missao com id:"+id+" não foi encontrada");
        }

    }

    // Alterar dados dos Missoes (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){

        MissoesDTO missao = missoesService.listarMissoesPorId(id);
        if(missao!=null){
            missaoAtualizada.setId(missao.getId());
            missoesService.alterarMissaoPorId(id, missaoAtualizada);
            return ResponseEntity.ok(missaoAtualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com id:"+id+" não foi encontrado");
        }
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarMissaoPorId(@PathVariable Long id){
        MissoesDTO missao =  missoesService.listarMissoesPorId(id);
        if(missao!= null){
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão ID:"+id+" não encontrada");
        }

    }
}
