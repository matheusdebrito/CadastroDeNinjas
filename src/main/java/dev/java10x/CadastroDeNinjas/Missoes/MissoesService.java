package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRespository missoesRespository;

    public MissoesService(MissoesRespository missoesRespository) {
        this.missoesRespository = missoesRespository;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRespository.findAll();
    }
}
