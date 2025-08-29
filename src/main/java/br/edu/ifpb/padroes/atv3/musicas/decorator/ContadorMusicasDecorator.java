package br.edu.ifpb.padroes.atv3.musicas.decorator;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.service.TocadorMusica;

import java.util.HashMap;
import java.util.Map;

public class ContadorMusicasDecorator extends MusicDecorator {
    private Map<String, Integer> contadorMusicas;

    public ContadorMusicasDecorator(TocadorMusica tocador) {
        super(tocador);
        this.contadorMusicas = new HashMap<>();
    }

    @Override
    public void tocarMusica(Musica musica) {
        super.tocarMusica(musica);
        contarMusica(musica.titulo());
    }

    private void contarMusica(String titulo) {
        contadorMusicas.put(titulo, contadorMusicas.getOrDefault(titulo, 0) + 1);
    }

    public Map<String, Integer> getContagemMusicas() {
        return new HashMap<>(contadorMusicas);
    }

    public int getTotalReproducoes() {
        return contadorMusicas.values().stream().mapToInt(Integer::intValue).sum();
    }
}