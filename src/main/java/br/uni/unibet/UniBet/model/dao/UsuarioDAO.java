package br.uni.unibet.UniBet.model.dao;

import br.uni.unibet.UniBet.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

    Usuario findByNome(String nome);

}
