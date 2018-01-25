/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mycompany.persistences.ExperimentoPersistence;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author fabio
 */
@Entity
public class Experimento implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "experimentoID", unique = true, nullable = false)
    private Integer id = 0;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario criador; //id do experimentador que criou

    @Column(name = "is_concluido")
    private boolean concluido;

    @Column(name = "is_replicavel")
    private boolean isReplicavel; // true = replicavel

    @Column(name = "dataInicial")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataInicial;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDefinicao")
    private Definicao definicao;

    public Experimento() {
        // default constructor
    }

    public Experimento(String nome, String descricao, boolean concluido, Calendar dataInicial, boolean isReplicavel, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.concluido = concluido;
        this.dataInicial = dataInicial;
        this.isReplicavel = isReplicavel;
        this.criador = usuario;
        this.definicao = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public boolean isIsReplicavel() {
        return isReplicavel;
    }

    public void setIsReplicavel(boolean isReplicavel) {
        this.isReplicavel = isReplicavel;
    }

    public Calendar getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Calendar dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Definicao getDefinicao() {
        return definicao;
    }

    public void setDefinicao(Definicao definicao) {

        this.definicao = definicao;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Experimento saveOnDatabase() {
        if (ExperimentoPersistence.save(this)) {
            return this;
        } else {
            return null;
        }
    }

    public Experimento updateDatabase() {
        if (ExperimentoPersistence.update(this)) {
            return this;
        } else {
            return null;
        }
    }

    public static Experimento buscaExperimento(Integer idExperimento) {
        return ExperimentoPersistence.getExperimento(idExperimento);
    }

    public void updateDef(String objEstudo, String objetivo, String perspectiva, String focoQualidade, String contexto, boolean editavel, boolean concluido) {
            this.definicao.setConcluido(concluido);
            this.definicao.setEditavel(editavel);
            this.definicao.setFocoQualidade(focoQualidade);
            this.definicao.setObjEstudo(objEstudo);
            this.definicao.setObjetivo(objetivo);
            this.definicao.setPerspectiva(perspectiva);
            this.definicao.setContexto(contexto);
    }

}
