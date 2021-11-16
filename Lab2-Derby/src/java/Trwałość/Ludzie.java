/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trwałość;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Michał
 */
@Entity
@Table(name = "LUDZIE")
@NamedQueries({
    @NamedQuery(name = "Ludzie.findAll", query = "SELECT l FROM Ludzie l"),
    @NamedQuery(name = "Ludzie.findById", query = "SELECT l FROM Ludzie l WHERE l.id = :id"),
    @NamedQuery(name = "Ludzie.findByImie", query = "SELECT l FROM Ludzie l WHERE l.imie = :imie"),
    @NamedQuery(name = "Ludzie.findByNazwisko", query = "SELECT l FROM Ludzie l WHERE l.nazwisko = :nazwisko")})
public class Ludzie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "IMIE")
    private String imie;
    @Size(max = 30)
    @Column(name = "NAZWISKO")
    private String nazwisko;

    public Ludzie() {
    }

    public Ludzie(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ludzie)) {
            return false;
        }
        Ludzie other = (Ludzie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trwa\u0142o\u015b\u0107.Ludzie[ id=" + id + " ]";
    }
    
}
