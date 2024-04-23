package prova.spring.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import prova.spring.prova.entity.Trabalho;
import prova.spring.prova.repository.TrabalhoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepo;

    public Trabalho postTrabalho(Trabalho trabalho){
        if(trabalho == null || trabalho.getNota() == null ||
            trabalho.getGrupo() == null || trabalho.getTitulo() == null
        ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        if(trabalho.getData() == null){
            trabalho.setData(LocalDateTime.now());
        }
        return trabalhoRepo.save(trabalho);
    }

    public List<Trabalho> getAll(){
        List<Trabalho> trabalho = trabalhoRepo.findAll();
        return trabalho;
    }

    public Trabalho getById(Long id){
        Optional<Trabalho> trabalhoOp = trabalhoRepo.findById(id);
        if(trabalhoOp.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabalho inesistente!");
        }
        return trabalhoOp.get();
    }

    public List<Trabalho> getByTituloAndNota(String titulo, Integer nota){
        return trabalhoRepo.getByTitulo(titulo, nota);
    }

}
