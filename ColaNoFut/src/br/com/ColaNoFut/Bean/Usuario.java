/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ColaNoFut.Bean;

/**
 *
 * @author MAIKOVITORDEIZEPISIL
 */
public class Usuario {
    
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String status;
    private String tipo;

    public Usuario(int id, String nome, String login, String senha, String status, String tipo) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.tipo = tipo;
    }
    public Usuario( String nome, String login, String senha, String status, String tipo) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.tipo = tipo;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}