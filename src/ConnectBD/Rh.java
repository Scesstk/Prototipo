/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectBD;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FGALLARDO
 */
@Entity
@Table(name = "rh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rh.findAll", query = "SELECT r FROM Rh r")
    , @NamedQuery(name = "Rh.findByIdrh", query = "SELECT r FROM Rh r WHERE r.idrh = :idrh")
    , @NamedQuery(name = "Rh.findByDescripcionrh", query = "SELECT r FROM Rh r WHERE r.descripcionrh = :descripcionrh")})
public class Rh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_rh")
    private Integer idrh;
    @Column(name = "Descripcion_rh")
    private String descripcionrh;
    @OneToMany(mappedBy = "idrh")
    private Collection<Persona> personaCollection;

    public Rh() {
    }

    public Rh(Integer idrh) {
        this.idrh = idrh;
    }

    public Integer getIdrh() {
        return idrh;
    }

    public void setIdrh(Integer idrh) {
        this.idrh = idrh;
    }

    public String getDescripcionrh() {
        return descripcionrh;
    }

    public void setDescripcionrh(String descripcionrh) {
        this.descripcionrh = descripcionrh;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrh != null ? idrh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rh)) {
            return false;
        }
        Rh other = (Rh) object;
        if ((this.idrh == null && other.idrh != null) || (this.idrh != null && !this.idrh.equals(other.idrh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBD.Rh[ idrh=" + idrh + " ]";
    }
    
}
