package com.mycompany.model;

/**
 *
 * @author nicol, sidious
 */
//import com.sun.istack.internal.NotNull;
import com.mycompany.persistences.UsuarioPersistence;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @NotNull
    private Integer id;

    @Column(name = "userName", nullable = false, unique = true)
    private String nomeUsuario;

    @Column(name = "senha", nullable = false, unique = false)
    private String senha;

    public Usuario(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public Usuario() {

    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public boolean saveOnDatabase() {
        return UsuarioPersistence.save(this);
    }

    public static Usuario login(String email, String senha) {
        return UsuarioPersistence.login(email, senha);
    }
    
    public static Usuario buscaUsuario(Integer idUsuario){
        return UsuarioPersistence.getUsuario(idUsuario);
    }
    
    public static Usuario buscaUsuarioEmail(String email){
        return UsuarioPersistence.getUsuarioEmail(email);
    }

}
