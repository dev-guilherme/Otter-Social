package modelos;

import java.util.ArrayList;
import java.util.Date;

public class Post implements Comparable<Post>{
    private String conteudo;
    private Date dataHora;
    private Usuario usuarioCriador;
    private ArrayList<Post> postResposta = new ArrayList<>();
    //private ArrayList<Likes> likes = new ArrayList<>();

    public Post(String conteudo, Usuario usuarioCriador) {
        this.conteudo = conteudo;
        this.dataHora = new Date();
        this.usuarioCriador = usuarioCriador;
    }

    //Métodos ----------------------------------------

    public void imprime(){
        System.out.println("@"+usuarioCriador.getUsername());
        System.out.println(conteudo);
        System.out.println(dataHora);
        System.out.println();
        System.out.println("------------------------------------");

    }

    //Getters e Setters ------------------------------

    public Usuario getUsuarioCriador() {
        return usuarioCriador;
    }

    @Override
    public int compareTo(Post outroPost) {
        return this.dataHora.compareTo(outroPost.dataHora);
    }
}
