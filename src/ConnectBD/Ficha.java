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
@Table(name = "ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f")
    , @NamedQuery(name = "Ficha.findByIdficha", query = "SELECT f FROM Ficha f WHERE f.idficha = :idficha")
    , @NamedQuery(name = "Ficha.findByNumficha", query = "SELECT f FROM Ficha f WHERE f.numficha = :numficha")
    , @NamedQuery(name = "Ficha.findByDescripcionficha", query = "SELECT f FROM Ficha f WHERE f.descripcionficha = :descripcionficha")})
public class Ficha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_ficha")
    private Integer idficha;
    @Column(name = "Num_ficha")
    private Integer numficha;
    @Column(name = "Descripcion_ficha")
    private String descripcionficha;
    @OneToMany(mappedBy = "idficha")
    private Collection<Persona> personaCollection;

    public Ficha() {
    }

    public Ficha(Integer idficha) {
        this.idficha = idficha;
    }

    public Integer getIdficha() {
        return idficha;
    }

    public void setIdficha(Integer idficha) {
        this.idficha = idficha;
    }

    public Integer getNumficha() {
        return numficha;
    }

    public void setNumficha(Integer numficha) {
        this.numficha = numficha;
    }

    public String getDescripcionficha() {
        return descripcionficha;
    }

    public void setDescripcionficha(String descripcionficha) {
        this.descripcionficha = descripcionficha;
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
        hash += (idficha != null ? idficha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.idficha == null && other.idficha != null) || (this.idficha != null && !this.idficha.equals(other.idficha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBD.Ficha[ idficha=" + idficha + " ]";
    }
    
}
