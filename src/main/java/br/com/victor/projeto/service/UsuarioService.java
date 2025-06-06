package br.com.victor.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victor.projeto.dto.UsuarioDTO;
import br.com.victor.projeto.entity.UsuarioEntity;
import br.com.victor.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;


	public List<UsuarioDTO>listarTodos(){
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}

	public void inserir(UsuarioDTO user) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(user);
		usuarioRepository.save(usuarioEntity);
	}

	public UsuarioDTO alterar(UsuarioDTO user) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(user);
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
	}

	public void excluir(Long id) {
		UsuarioEntity usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}

	public UsuarioDTO buscarPorId(Long id) {
		return new UsuarioDTO(usuarioRepository.findById(id).get());
	}
}
