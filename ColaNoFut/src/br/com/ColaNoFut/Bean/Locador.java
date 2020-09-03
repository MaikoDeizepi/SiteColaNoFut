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
public class Locador {
    
    private Integer id_locador;
    private String cnpj;
    private String nome_proprietario;
    private String nome_espaco;
    private String telefone;

    public Locador(Integer id_locador, String cnpj, String nome_proprietario, String nome_espaco, String telefone) {
        this.id_locador = id_locador;
        this.cnpj = cnpj;
        this.nome_proprietario = nome_proprietario;
        this.nome_espaco = nome_espaco;
        this.telefone = telefone;
    }

    public Locador(String cnpj, String nome_proprietario, String nome_espaco, String telefone) {
        this.cnpj = cnpj;
        this.nome_proprietario = nome_proprietario;
        this.nome_espaco = nome_espaco;
        this.telefone = telefone;
    }

    public Locador() {
    }

    public Locador(Integer id_locador) {
        this.id_locador = id_locador;
    }


    @Override
    public String toString() {
        return "locador{" +
                "id_locador=" + id_locador +
                ", cnpj='" + cnpj + '\'' +
                ", nome_proprietario='" + nome_proprietario + '\'' +
                ", nome='" + nome_espaco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locador locador = (Locador) o;
        return Objects.equals(id_locador, locador.id_locador) &&
                Objects.equals(cnpj, locador.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_locador, cnpj);
    }

    public Integer getId_locador() {
        return id_locador;
    }

    public void setId_locador(Integer id_locador) {
        this.id_locador = id_locador;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome_proprietario() {
        return nome_proprietario;
    }

    public void setNome_proprietario(String nome_proprietario) {
        this.nome_proprietario = nome_proprietario;
    }

    public String getNome_espaco() {
        return nome_espaco;
    }

    public void setNome_espaco(String nome_espaco) {
        this.nome_espaco = nome_espaco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
