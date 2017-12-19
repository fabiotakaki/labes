/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * @author fabio
 */
@Entity
public class Experimento implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "experimentoID", unique = true, nullable = false)
    private Integer id;

    private String nome;
    private String descricao;
    private int criador; //id do experimentador que criou
    private boolean concluido;
    private boolean replicacao; //se pode ser replicado ou não 1 == pode , 0 == não pode

    @Column(name = "dataInicial")
    private Calendar data_inicial;

    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDefinicao")
    private Definicao definicao;
    
    
    public Experimento(){
    }
    
    public Experimento(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
        this.concluido = false;
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

    public int getCriador() {
        return criador;
    }

    public void setCriador(int criador) {
        this.criador = criador;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public boolean isReplicacao() {
        return replicacao;
    }

    public void setReplicacao(boolean replicacao) {
        this.replicacao = replicacao;
    }
    
    public Calendar getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(Calendar data_inicial) {
        this.data_inicial = data_inicial;
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

    public boolean saveOnDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
