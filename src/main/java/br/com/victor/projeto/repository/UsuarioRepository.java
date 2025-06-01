package br.com.victor.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victor.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

}
