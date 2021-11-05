
package br.com.william.jdbc.model;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contato {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(length = 50, name = "nomeCompleto")
    private String nome;
    @Column(length = 20) 
    private String telefone; 
    @Column(length = 70, name = "email")
    private String email;
    private LocalDate dataCadastro;
    private String observacao;

    public Contato() {
    }

    public Contato(Integer codigo, String nome, String telefone, String email, LocalDate dataCadastro, String observacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.observacao = observacao;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Contato{" + "codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", dataCadastro=" + dataCadastro + ", observacao=" + observacao + '}';
    }
    
    
    
}
