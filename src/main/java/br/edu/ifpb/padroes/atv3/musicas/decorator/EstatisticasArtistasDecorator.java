package br.edu.ifpb.padroes.atv3.musicas.decorator;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.service.TocadorMusica;

import java.util.HashMap;
import java.util.Map;

public class EstatisticasArtistasDecorator extends MusicDecorator {
    private Map<String, Integer> contadorArtistas;

    public EstatisticasArtistasDecorator(TocadorMusica tocador) {
        super(tocador);
        this.contadorArtistas = new HashMap<>();
    }

    @Override
    public void tocarMusica(Musica musica) {
        super.tocarMusica(musica);
        contarArtista(musica.artista());
    }

    private void contarArtista(String artista) {
        contadorArtistas.put(artista, contadorArtistas.getOrDefault(artista, 0) + 1);
    }

    public Map<String, Integer> getEstatisticasArtistas() {
        return new HashMap<>(contadorArtistas);
    }

    public String getArtistaMaisTocado() {
        return contadorArtistas.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum artista tocado");
    }
}