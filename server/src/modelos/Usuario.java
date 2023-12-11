package modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Usuario{
    private String nome;
    private String username;
    private String email;
    private String senha;
    private String descricao;
    private ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<Usuario> seguidores = new ArrayList<>();
    private ArrayList<Usuario> seguindo = new ArrayList<>();

    Scanner leitura = new Scanner(System.in);

    public Usuario(String nome, String username, String email, String senha) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
    }

    //Métodos ----------------------------------

    public void imprimePerfilUsuario(){
        System.out.println("Nome: "+nome);
        System.out.println("Username: "+username);
        System.out.println("Descrição: "+descricao);
        System.out.println("Num. Seguidores: "+seguidores.size());
        System.out.println("Num. seguindo: "+seguindo.size());
    }

    public void postar(String conteudo){
        Post post = new Post(conteudo, this);
        posts.add(post);
    }

    public void responderPost(String conteudo, Post post){
        PostResposta resposta = new PostResposta(conteudo, this, post);
        posts.add(resposta);
    }

    public void listarPosts(){
        System.out.println();
        System.out.println("Posts do "+username);
        System.out.print("------------------------------------");
        System.out.println();
        for (Post item:posts) {
            System.out.println();
            item.imprime();
        }
    }

    public void adicionarSeguidor(Usuario seguidor){
        seguidores.add(seguidor);
    }

    public void seguirUsuario(Usuario usuarioAlvo){
        seguindo.add(usuarioAlvo);
    }

    public void retirarSeguidor(Usuario seguidor){
        seguidores.remove(seguidor);
    }

    public void pararDeSeguir(Usuario usuarioAlvo){
        seguindo.remove(usuarioAlvo);
    }

    public boolean validaSegueUsuario(Usuario usuarioAlvo){
        return seguindo.contains(usuarioAlvo);
    }

    public void mostrarSeguidores(Usuario usuarioAlvo){
        if (!seguidores.isEmpty()){
            System.out.println("Lista de pessoas que seguem @"+username);
            for (Usuario item: seguidores) {
                System.out.println("@"+item.getUsername());
            }
        }else {
            if (usuarioAlvo.getUsername().equals(username)){
                System.out.println("Você não tem seguidores :(");
            }else {
                System.out.println("@"+username+" não tem seguidores :(");
            }
        }
    }

    public void mostrarPessoasQueSegue(Usuario usuarioAlvo){
        if (!seguindo.isEmpty()){
            System.out.println("Lista de pessoas que @"+username+" segue:");
            for (Usuario item: seguindo) {
                System.out.println("@"+item.getUsername());
            }
        }else {
            if (usuarioAlvo.getUsername().equals(this.getUsername())){
                System.out.println("Você não está seguindo ninguém  :(");
            }else {
                System.out.println("@"+username+" não está seguindo ninguém :(");
            }
        }
    }


    //Getters e Setters ------------------------------

    public ArrayList<Post> getFeed(){
        ArrayList<Post> feed = new ArrayList<>();

        for (Usuario itemUsuario:seguindo) {
            feed.addAll(itemUsuario.posts);
        }

        Collections.sort(feed);
        Collections.reverse(feed);

        return feed;
    }

    public String getSenha() {
        return senha;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
