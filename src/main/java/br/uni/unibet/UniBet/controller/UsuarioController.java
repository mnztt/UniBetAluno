package br.uni.unibet.UniBet.controller;

import br.uni.unibet.UniBet.model.Usuario;
import br.uni.unibet.UniBet.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("")
    public ResponseEntity<?> criaUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioSalvo = usuarioService.criaUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable(required = true) int id) {
        try {
            usuarioService.deletaUsuario(id);
            return ResponseEntity.ok("Usuário apagado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> retornaUsuarios() {
        List<Usuario> usuarios = usuarioService.buscarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retornaUsuario(@PathVariable(required = true) int id) {
        Usuario usuario = usuarioService.buscaUsuario(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.badRequest().body("Usuário não encontrado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alteraUsuario(@PathVariable(required = true) int id,
                                           @RequestBody Usuario novoUsuario) {
        try {
            Usuario usuarioAlterado = usuarioService.alteraUsuario(id, novoUsuario);
            return ResponseEntity.ok(usuarioAlterado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
