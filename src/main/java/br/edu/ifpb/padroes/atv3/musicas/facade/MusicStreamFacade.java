package br.edu.ifpb.padroes.atv3.musicas.facade;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.proxy.MusicServiceProxy;
import br.edu.ifpb.padroes.atv3.musicas.service.TocadorMusica;
import br.edu.ifpb.padroes.atv3.musicas.decorator.ContadorMusicasDecorator;
import br.edu.ifpb.padroes.atv3.musicas.decorator.EstatisticasArtistasDecorator;
import br.edu.ifpb.padroes.atv3.musicas.decorator.EstatisticasGeneroDecorator;

import java.util.List;
import java.util.Map;

public class MusicStreamFacade {
    private final MusicServiceProxy musicService;
    private final TocadorMusica tocadorBase;
    private final ContadorMusicasDecorator contadorMusicas;
    private final EstatisticasArtistasDecorator estatisticasArtistas;
    private final EstatisticasGeneroDecorator estatisticasGenero;

    public MusicStreamFacade() {
        this.musicService = new MusicServiceProxy();
        this.tocadorBase = new TocadorMusica();
        this.contadorMusicas = new ContadorMusicasDecorator(tocadorBase);
        this.estatisticasArtistas = new EstatisticasArtistasDecorator(contadorMusicas);
        this.estatisticasGenero = new EstatisticasGeneroDecorator(estatisticasArtistas);
    }

    public List<Musica> listarTodasMusicas() {
        return musicService.listarTodasMusicas();
    }

    public List<Musica> buscarPorArtista(String artista) {
        return musicService.buscarPorArtista(artista);
    }

    public List<Musica> buscarPorGenero(String genero) {
        return musicService.buscarPorGenero(genero);
    }

    public Musica buscarPorTitulo(String titulo) {
        return musicService.buscarPorTitulo(titulo);
    }

    public void tocarMusica(Musica musica) {
        estatisticasGenero.tocarMusica(musica);
    }

    public void tocarPorTitulo(String titulo) {
        Musica musica = buscarPorTitulo(titulo);
        if (musica != null) {
            tocarMusica(musica);
        }
    }

    public Map<String, Integer> getContagemMusicas() {
        return contadorMusicas.getContagemMusicas();
    }

    public Map<String, Integer> getEstatisticasArtistas() {
        return estatisticasArtistas.getEstatisticasArtistas();
    }

    public Map<String, Integer> getEstatisticasGeneros() {
        return estatisticasGenero.getEstatisticasGeneros();
    }

    public String getArtistaMaisTocado() {
        return estatisticasArtistas.getArtistaMaisTocado();
    }

    public String getGeneroMaisTocado() {
        return estatisticasGenero.getGeneroMaisTocado();
    }

    public int getTotalReproducoes() {
        return contadorMusicas.getTotalReproducoes();
    }

    public void limparCache() {
        musicService.limparCache();
    }
}