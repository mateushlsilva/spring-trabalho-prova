package prova.spring.prova.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prova.spring.prova.entity.Trabalho;
import prova.spring.prova.service.TrabalhoService;

import java.util.List;

@RestController
@RequestMapping(value = "/trabalho")
@CrossOrigin
public class TrabalhoController {

    @Autowired
    private TrabalhoService service;

    @GetMapping
    public List<Trabalho> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Trabalho postTrabalho(@RequestBody Trabalho trabalho){
        return service.postTrabalho(trabalho);
    }

    @GetMapping(value = "/{id}")
    public Trabalho getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @GetMapping(value = "/{titulo}/{nota}")
    public List<Trabalho> getByTituloAndNota(@PathVariable("titulo") String titulo, @PathVariable("nota") Integer nota){
        return service.getByTituloAndNota(titulo, nota);
    }
}
