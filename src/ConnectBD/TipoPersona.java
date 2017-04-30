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
@Table(name = "tipo_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPersona.findAll", query = "SELECT t FROM TipoPersona t")
    , @NamedQuery(name = "TipoPersona.findByIdtipopersona", query = "SELECT t FROM TipoPersona t WHERE t.idtipopersona = :idtipopersona")
    , @NamedQuery(name = "TipoPersona.findByDescripciontipopersona", query = "SELECT t FROM TipoPersona t WHERE t.descripciontipopersona = :descripciontipopersona")})
public class TipoPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_tipo_persona")
    private Integer idtipopersona;
    @Column(name = "Descripcion_tipo_persona")
    private String descripciontipopersona;
    @OneToMany(mappedBy = "idtipopersona")
    private Collection<Persona> personaCollection;

    public TipoPersona() {
    }

    public TipoPersona(Integer idtipopersona) {
        this.idtipopersona = idtipopersona;
    }

    public Integer getIdtipopersona() {
        return idtipopersona;
    }

    public void setIdtipopersona(Integer idtipopersona) {
        this.idtipopersona = idtipopersona;
    }

    public String getDescripciontipopersona() {
        return descripciontipopersona;
    }

    public void setDescripciontipopersona(String descripciontipopersona) {
        this.descripciontipopersona = descripciontipopersona;
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
        hash += (idtipopersona != null ? idtipopersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPersona)) {
            return false;
        }
        TipoPersona other = (TipoPersona) object;
        if ((this.idtipopersona == null && other.idtipopersona != null) || (this.idtipopersona != null && !this.idtipopersona.equals(other.idtipopersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBD.TipoPersona[ idtipopersona=" + idtipopersona + " ]";
    }
    
}
