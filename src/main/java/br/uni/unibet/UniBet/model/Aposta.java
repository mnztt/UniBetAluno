package br.uni.unibet.UniBet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aposta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double valorAposta;
    @ManyToOne
    private Usuario jogador;
    @ManyToOne
    private Jogo jogo;    
    private ETipoResultado  aposta;
    
}
