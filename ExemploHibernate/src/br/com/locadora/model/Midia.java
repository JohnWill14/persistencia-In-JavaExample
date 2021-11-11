
package br.com.locadora.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "midia")
public class Midia implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_midia")
    private Long id;
    @Column(name = "inutilizada")
    private Character inutilizada;
    @ManyToOne
    @JoinColumn(name = "cod_filme")
    private Filme filme;

    public Midia() {
    }

    public Midia(Long id, Character inutilizada, Filme filme) {
        this.id = id;
        this.inutilizada = inutilizada;
        this.filme = filme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getInutilizada() {
        return inutilizada;
    }

    public void setInutilizada(Character inutilizada) {
        this.inutilizada = inutilizada;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.inutilizada);
        hash = 23 * hash + Objects.hashCode(this.filme);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Midia other = (Midia) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.inutilizada, other.inutilizada)) {
            return false;
        }
        if (!Objects.equals(this.filme, other.filme)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Midia{" + "id=" + id + ", inutilizada=" + inutilizada + ", filme=" + filme + '}';
    }
    
    

}
