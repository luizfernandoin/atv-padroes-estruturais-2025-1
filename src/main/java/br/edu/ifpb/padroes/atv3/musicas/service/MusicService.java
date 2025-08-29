package br.edu.ifpb.padroes.atv3.musicas.service;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import java.util.List;

public interface MusicService {
    List<Musica> listarTodasMusicas();
    List<Musica> buscarPorArtista(String artista);
    List<Musica> buscarPorGenero(String genero);
    Musica buscarPorTitulo(String titulo);
}