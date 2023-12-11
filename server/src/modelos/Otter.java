package modelos;

import java.util.ArrayList;

public class Otter {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Post> postagens = new ArrayList<>();

    public void cadastrarUsuario(String nome, String username, String email, String senha){
        for (Usuario item:usuarios) {
            if (username.equals(item.getUsername()) || email.equals(item.getEmail())){
                System.out.println("Nome de usuário já esta em uso, tente outro");
            }
        }
        Usuario usuario = new Usuario(nome, username, email, senha);
        usuarios.add(usuario);
    }

    public boolean validarNomeUsuario(String username){
        for (Usuario item: usuarios) {
            if (username.equals(item.getUsername())){
                return false;
            }
        }
        return true;
    }

    // retorna um usuário específico
    public Usuario buscaUsuario(String username){
        Usuario alvo = null;
        for (Usuario item: usuarios) {
            if (item.getUsername().equals(username)){
                alvo = item;
            }
        }
        if (alvo != null){
            return alvo;
        }else {
            System.out.println("Usuário não encontrado!");
            return null;
        }
    }

    // autenticação de um usuário
    public boolean login(String username, String senha){
        Usuario usuario = buscaUsuario(username);
        if (usuario == null){
            return false;
        } else return usuario.getSenha().equals(senha);
    }

    public void seguir(Usuario usuarioLogado, Usuario usuarioAlvo){
        usuarioLogado.seguirUsuario(usuarioAlvo);
        usuarioAlvo.adicionarSeguidor(usuarioLogado);
    }

    public void pararDeSeguir(Usuario usuarioLogado, Usuario usuarioAlvo){
        usuarioLogado.pararDeSeguir(usuarioAlvo);
        usuarioAlvo.retirarSeguidor(usuarioLogado);
    }
}