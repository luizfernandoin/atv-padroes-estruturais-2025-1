package br.edu.ifpb.padroes.atv3.musicas.adapter;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.xpto.Song;

public class SongAdapter {

    public static Musica adapt(Song song) {
        return new Musica(
                song.id(),
                song.title(),
                song.artist(),
                song.year(),
                song.genre()
        );
    }
}