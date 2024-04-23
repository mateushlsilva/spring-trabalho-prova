package prova.spring.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import prova.spring.prova.entity.Trabalho;

import java.util.List;


public interface TrabalhoRepository  extends JpaRepository<Trabalho, Long> {

    @Query("select u from Trabalho u where u.titulo like %?1% and u.nota > ?2")
    public List<Trabalho> getByTitulo(String titulo, Integer nota);
}
