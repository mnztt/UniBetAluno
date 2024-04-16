package br.uni.unibet.UniBet.service;

import br.uni.unibet.UniBet.model.Jogo;
import br.uni.unibet.UniBet.model.dao.JogoDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JogoService {
    @Autowired
    JogoDAO adao;

    public List<Jogo> buscarTodosJogos() {
        return adao.findAll();
    }

    public Jogo salvarJogo (Jogo jogo) {
        return adao.save(jogo);
    }

}
