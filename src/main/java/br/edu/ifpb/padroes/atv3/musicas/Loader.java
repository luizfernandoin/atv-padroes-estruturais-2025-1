package br.edu.ifpb.padroes.atv3.musicas;

import br.edu.ifpb.padroes.atv3.musicas.facade.MusicStreamFacade;

public class Loader {
    public static void main(String[] args) {
        MusicStreamFacade facade = new MusicStreamFacade();

        System.out.println("=== Todas as Músicas (Cache + Adapter) ===");
        facade.listarTodasMusicas().forEach(m ->
                System.out.println(m.titulo() + " - " + m.artista() + " (" + m.genero() + ")"));

        System.out.println("\n=== Músicas de Rock ===");
        facade.buscarPorGenero("Rock").forEach(m ->
                System.out.println(m.titulo() + " - " + m.artista()));

        System.out.println("\n=== Reproduzindo Músicas (Decorator) ===");
        facade.tocarPorTitulo("Garota de Ipanema");
        facade.tocarPorTitulo("Bohemian Rhapsody");
        facade.tocarPorTitulo("Thriller");
        facade.tocarPorTitulo("Garota de Ipanema");
        facade.tocarPorTitulo("Stairway to Heaven");

        System.out.println("\n=== Estatísticas de Reprodução ===");
        System.out.println("Total de reproduções: " + facade.getTotalReproducoes());
        System.out.println("Artista mais tocado: " + facade.getArtistaMaisTocado());
        System.out.println("Gênero mais tocado: " + facade.getGeneroMaisTocado());

        System.out.println("\n=== Contagem por Música ===");
        facade.getContagemMusicas().forEach((musica, count) ->
                System.out.println(musica + ": " + count + " vezes"));
    }
}
