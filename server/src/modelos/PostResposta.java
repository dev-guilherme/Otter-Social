package modelos;

public class PostResposta extends Post{
    private Post postReferencia;

    public PostResposta(String conteudo, Usuario usuarioCriador, Post postReferencia) {
        super (conteudo, usuarioCriador);
        this.postReferencia = postReferencia;
    }

    @Override
    public void imprime() {
        System.out.println("Em resposta a @" + postReferencia.getUsuarioCriador().getUsername());
        super.imprime();
    }
}
