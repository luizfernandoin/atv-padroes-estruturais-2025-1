package br.edu.ifpb.padroes.atv3.musicas.proxy;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.abcd.ClienteHttpABCD;
import br.edu.ifpb.padroes.atv3.musicas.xpto.ClientHttpXPTO;
import br.edu.ifpb.padroes.atv3.musicas.adapter.SongAdapter;
import br.edu.ifpb.padroes.atv3.musicas.service.MusicService;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MusicServiceProxy implements MusicService {

    private final ClienteHttpABCD clienteABCD;
    private final ClientHttpXPTO clienteXPTO;
    private List<Musica> cacheMusicas;

    public MusicServiceProxy() {
        this.clienteABCD = new ClienteHttpABCD();
        this.clienteXPTO = new ClientHttpXPTO();
        this.cacheMusicas = new ArrayList<>();
    }

    @Override
    public List<Musica> listarTodasMusicas() {
        if (cacheMusicas.isEmpty()) {
            carregarCache();
        }
        return new ArrayList<>(cacheMusicas);
    }

    @Override
    public List<Musica> buscarPorArtista(String artista) {
        if (cacheMusicas.isEmpty()) {
            carregarCache();
        }
        return cacheMusicas.stream()
                .filter(m -> m.artista().equalsIgnoreCase(artista))
                .collect(Collectors.toList());
    }

    @Override
    public List<Musica> buscarPorGenero(String genero) {
        if (cacheMusicas.isEmpty()) {
            carregarCache();
        }
        return cacheMusicas.stream()
                .filter(m -> m.genero().equalsIgnoreCase(genero))
                .collect(Collectors.toList());
    }

    @Override
    public Musica buscarPorTitulo(String titulo) {
        if (cacheMusicas.isEmpty()) {
            carregarCache();
        }
        return cacheMusicas.stream()
                .filter(m -> m.titulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    private void carregarCache() {
        cacheMusicas.clear();

        try {
            cacheMusicas.addAll(clienteABCD.listarMusicas());
        } catch (Exception e) {
            System.err.println("Erro ao carregar músicas ABCD: " + e.getMessage());
        }

        try {
            clienteXPTO.findAll().forEach(song -> {
                cacheMusicas.add(SongAdapter.adapt(song));
            });
        } catch (Exception e) {
            System.err.println("Erro ao carregar músicas XPTO: " + e.getMessage());
        }
    }

    public void limparCache() {
        cacheMusicas.clear();
    }
}