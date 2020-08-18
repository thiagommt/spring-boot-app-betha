package br.com.projetoBetha.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.projetoBetha.ws.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value="SELECT u FROM Usuario u WHERE u.nome=:pNome")
	public Usuario buscarPorNome(@Param("pNome") String nome);
}
