/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ColaNoFut.Bean;

import java.util.Objects;

/**
 *
 * @author MAIKOVITORDEIZEPISIL
 */
public class Locatario {
    private Integer id_locatario;
    private String cpf;
    private String rg;
    private String nome;
    private String telefone;

    public Locatario(Integer id_locatario, String cpf, String rg, String nome, String telefone) {
        this.id_locatario = id_locatario;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Locatario(String cpf, String rg, String nome, String telefone) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Locatario() {
    }

    @Override
    public String toString() {
        return "locatario{" +
                "id_locatario=" + id_locatario +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locatario locatario = (Locatario) o;
        return Objects.equals(id_locatario, locatario.id_locatario) &&
                Objects.equals(cpf, locatario.cpf) &&
                Objects.equals(rg, locatario.rg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_locatario, cpf, rg);
    }

    public Integer getId_locatario() {
        return id_locatario;
    }

    public void setId_locatario(Integer id_locatario) {
        this.id_locatario = id_locatario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
