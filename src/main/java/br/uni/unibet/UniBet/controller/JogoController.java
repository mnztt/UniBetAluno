package br.uni.unibet.UniBet.controller;


import br.uni.unibet.UniBet.model.Jogo;
import br.uni.unibet.UniBet.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    JogoService jogoService;

    @PostMapping("")
    public ResponseEntity<?> salvarJogo(@RequestBody (required = true) Jogo jogo) {
        try {
            Jogo jogoSalvo = jogoService.salvarJogo(jogo);
            return ResponseEntity.status(HttpStatus.CREATED).body(jogoSalvo);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
