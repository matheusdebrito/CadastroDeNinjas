package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRespository missoesRespository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRespository missoesRespository, MissoesMapper missoesMapper) {
        this.missoesRespository = missoesRespository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRespository.findAll();
    }

    public MissoesModel listarMissoesPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRespository.findById(id);
        return missaoPorId.orElse(null);
    }

    public MissoesDTO criarMissao(MissoesDTO missaoDTO)
    {
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missoesRespository.save(missao);
        return missoesMapper.map(missao);

    }

    public void deletarMissao(Long id){
        missoesRespository.deleteById(id);
    }

    public MissoesModel atualizarMissão(Long id, MissoesModel missaoAtualizada){
        if (missoesRespository.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRespository.save(missaoAtualizada);
        }
        return null;
    }
}
