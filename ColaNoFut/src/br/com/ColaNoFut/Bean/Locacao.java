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
public class Locacao {
    private Locador locador;
    private Locatario locatario;
    private Integer idlocatario;
    private Integer idlocador;
    private Integer idLocadLocat;
    private String obs;

    public Locacao(Integer idLocadLocat, Integer idlocatario, Integer idLocador,  String obs) {
        this.idLocadLocat = idLocadLocat;
        this.idlocatario = idlocatario;
        this.idlocador = idLocador;
        this.obs = obs;
    }

    public Locacao() {
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "locador=" + locador +
                ", locatario=" + locatario +
                ", idlocatario=" + idlocatario +
                ", idlocacao=" + idlocador +
                ", idLocadLocat=" + idLocadLocat +
                ", obs='" + obs + '\'' +
                '}';
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Integer getIdlocatario() {
        return idlocatario;
    }

    public void setIdlocatario(Integer idlocatario) {
        this.idlocatario = idlocatario;
    }

    public Integer getIdLocador() {
        return idlocador;
    }

    public void setIdLocador(Integer idLocador) {
        this.idlocador = idLocador;
    }

    public Integer getIdLocadLocat() {
        return idLocadLocat;
    }

    public void setIdLocadLocat(Integer idLocadLocat) {
        this.idLocadLocat = idLocadLocat;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
