/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author fabio
 */
@SuppressWarnings("Serial")
@Entity
public class Definicao implements Serializable {

    @Id
    @GeneratedValue
    private int idDef;

    @OneToOne
    @MapsId
    @JoinColumn(name = "experimentoID")
    private Experimento experimento;

    @Column(name = "obj_Estudo")
    private String objEstudo;

    @Column(name = "objetivo")
    private String objetivo;

    @Column(name = "perspectiva")
    private String perspectiva;

    @Column(name = "focoQualidade")
    private String focoQualidade;

    @Column(name = "contexto")
    private String contexto;

    @Column(name = "editavel")
    private boolean editvel;

    @Column(name = "concluido")
    private boolean concluido;

    public int getIdDef() {
        return idDef;
    }

    public void setIdDef(int idDef) {
        this.idDef = idDef;
    }

    public Experimento getExperimento() {
        return experimento;
    }

    public void setExperimento(Experimento experimento) {
        this.experimento = experimento;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public boolean isEditvel() {
        return editvel;
    }

    public void setEditvel(boolean editvel) {
        this.editvel = editvel;
    }

    public String getObjEstudo() {
        return objEstudo;
    }

    public void setObjEstudo(String objEstudo) {
        this.objEstudo = objEstudo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getPerspectiva() {
        return perspectiva;
    }

    public void setPerspectiva(String perspectiva) {
        this.perspectiva = perspectiva;
    }

    public String getFocoQualidade() {
        return focoQualidade;
    }

    public void setFocoQualidade(String focoQualidade) {
        this.focoQualidade = focoQualidade;
    }

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }

}
