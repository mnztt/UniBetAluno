package br.uni.unibet.UniBet.service;

import br.uni.unibet.UniBet.model.Aposta;
import br.uni.unibet.UniBet.model.DTO.ApostaInputDTO;
import br.uni.unibet.UniBet.model.Jogo;
import br.uni.unibet.UniBet.model.Time;
import br.uni.unibet.UniBet.model.Usuario;
import br.uni.unibet.UniBet.model.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class UsuarioService {

    @Autowired
    UsuarioDAO udao;

    public Usuario criaUsuario(Usuario usuario) throws Exception {

        //Verificar se o usuario já existe
        Usuario uExiste = udao.findByNome( usuario.getNome() );
        if( uExiste != null ){
            throw new Exception("Usuário já existe!!!");
        }

        Usuario usr = new Usuario(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha(), usuario.getEmail()
                , usuario.getSaldo(), usuario.isEhAdmin(), usuario.getMinhasApostas());
        return udao.save(usr);

    }

    public Usuario buscaUsuario(int id){
        Optional<Usuario> u = udao.findById(id);
        return u.orElse(null);
    }

    public Usuario alteraUsuario(int id, Usuario usuario) throws Exception {
        Optional<Usuario> u = udao.findById(id);
        if (! u.isPresent()){
            throw new Exception("Usuário "+id+"não existe!");
        }
        if (usuario.getNome().isEmpty() || usuario.getNome().isBlank()){
            throw new Exception("Nome do usuário não pode ser vazio");
        }
        Usuario usuarioExiste = udao.findByNome(usuario.getNome());
        if(usuarioExiste != null){
            throw new Exception("usuário "+usuarioExiste.getNome()+" já cadastrado");
        }
        Usuario usuarioAlterado = u.get();
        usuarioAlterado.setNome(usuario.getNome());
        return udao.save(usuarioAlterado);
    }

    public void deletaUsuario(int id) throws Exception{
        Optional<Usuario> u = udao.findById( id );
        if ( u.isPresent() ){
            udao.delete( u.get() );
        } else {
            throw new Exception("Usuario "+id+" não existe");
        }
    }

    public List<Usuario> buscarTodos() {
        return udao.findAll();
    }

}
