package br.edu.ifpb.padroes.atv3.musicas.service;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.exception.MusicaNaoEncontradaException;

public class TocadorMusica {

    public void tocarMusica(Musica musica) {
        if (musica == null)
            throw new MusicaNaoEncontradaException();

        System.out.println("Tocando musica: " + musica.titulo());
    }

}
