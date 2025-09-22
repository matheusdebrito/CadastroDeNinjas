package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRespository missoesRespository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRespository missoesRespository, MissoesMapper missoesMapper) {
        this.missoesRespository = missoesRespository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRespository.findAll();

        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissoesPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRespository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO criarMissao(MissoesDTO missaoDTO)
    {
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missoesRespository.save(missao);
        return missoesMapper.map(missao);

    }

    public void deletarMissaoPorId(Long id){
        missoesRespository.deleteById(id);
    }

    public MissoesDTO atualizarMissao(Long id, MissoesDTO missaoDTO){
        Optional<MissoesModel> missaoExistente = missoesRespository.findById(id);
        if (missaoExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missaoDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRespository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        } return null;
    }
}
