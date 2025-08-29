package br.edu.ifpb.padroes.atv3.musicas.decorator;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.service.TocadorMusica;

import java.util.HashMap;
import java.util.Map;

public class EstatisticasGeneroDecorator extends MusicDecorator {
    private Map<String, Integer> contadorGeneros;

    public EstatisticasGeneroDecorator(TocadorMusica tocador) {
        super(tocador);
        this.contadorGeneros = new HashMap<>();
    }

    @Override
    public void tocarMusica(Musica musica) {
        super.tocarMusica(musica);
        contarGenero(musica.genero());
    }

    private void contarGenero(String genero) {
        contadorGeneros.put(genero, contadorGeneros.getOrDefault(genero, 0) + 1);
    }

    public Map<String, Integer> getEstatisticasGeneros() {
        return new HashMap<>(contadorGeneros);
    }

    public String getGeneroMaisTocado() {
        return contadorGeneros.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum gênero tocado");
    }
}