package br.edu.ifpb.padroes.atv3.musicas.decorator;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.service.TocadorMusica;

public abstract class MusicDecorator extends TocadorMusica {
    protected TocadorMusica tocadorDecorado;

    public MusicDecorator(TocadorMusica tocador) {
        this.tocadorDecorado = tocador;
    }

    @Override
    public void tocarMusica(Musica musica) {
        tocadorDecorado.tocarMusica(musica);
    }
}