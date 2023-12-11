package br.com.otter.otter_social.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome_completo", length = 200, nullable = true)
    private String nome;
    @Column(name = "cpf", length = 11, nullable = true)
    private String cpf;
    @Column(name = "apelido", length = 100, nullable = true)
    private String apelido;
    @Column(name = "email", length = 50, nullable = true)
    private String email;
    @Column(name = "senha", columnDefinition = "TEXT", nullable = true)
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
