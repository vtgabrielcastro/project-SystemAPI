package br.com.victor.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victor.projeto.dto.PerfilUsuarioDTO;
import br.com.victor.projeto.entity.PerfilUsuarioEntity;
import br.com.victor.projeto.repository.PerfilUsuarioRepository;

@Service
public class PerfilUsuarioService {
	@Autowired
	PerfilUsuarioRepository perfilUsuarioRepository;
	
	public List<PerfilUsuarioDTO> listarTodos() {
		List<PerfilUsuarioEntity> perfis = perfilUsuarioRepository.findAll();
		return perfis.stream().map(PerfilUsuarioDTO::new).toList();
	}
	public void inserir(PerfilUsuarioDTO perfil) {
		PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfil);
		perfilUsuarioRepository.save(perfilUsuarioEntity);
	}
	public PerfilUsuarioDTO alterar(PerfilUsuarioDTO perfil) {
		PerfilUsuarioEntity perfilEntity = new PerfilUsuarioEntity(perfil);
		return new PerfilUsuarioDTO(perfilUsuarioRepository.save(perfilEntity));
	}
	public void excluir(Long id) {
		PerfilUsuarioEntity perfilEntity = perfilUsuarioRepository.findById(id).get();
		perfilUsuarioRepository.delete(perfilEntity);
	}
	public PerfilUsuarioDTO buscarPorId(Long id) {
		return new PerfilUsuarioDTO(perfilUsuarioRepository.findById(id).get());
	}
}
