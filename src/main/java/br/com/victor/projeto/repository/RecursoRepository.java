package br.com.victor.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victor.projeto.entity.RecursoEntity;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long> {

}
