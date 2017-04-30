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
@Table(name = "tipo_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEquipo.findAll", query = "SELECT t FROM TipoEquipo t")
    , @NamedQuery(name = "TipoEquipo.findByIdtipoequipo", query = "SELECT t FROM TipoEquipo t WHERE t.idtipoequipo = :idtipoequipo")
    , @NamedQuery(name = "TipoEquipo.findByClaseequipo", query = "SELECT t FROM TipoEquipo t WHERE t.claseequipo = :claseequipo")})
public class TipoEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_tipo_equipo")
    private Integer idtipoequipo;
    @Column(name = "Clase_equipo")
    private String claseequipo;
    @OneToMany(mappedBy = "idtipoequipo")
    private Collection<Equipos> equiposCollection;

    public TipoEquipo() {
    }

    public TipoEquipo(Integer idtipoequipo) {
        this.idtipoequipo = idtipoequipo;
    }

    public Integer getIdtipoequipo() {
        return idtipoequipo;
    }

    public void setIdtipoequipo(Integer idtipoequipo) {
        this.idtipoequipo = idtipoequipo;
    }

    public String getClaseequipo() {
        return claseequipo;
    }

    public void setClaseequipo(String claseequipo) {
        this.claseequipo = claseequipo;
    }

    @XmlTransient
    public Collection<Equipos> getEquiposCollection() {
        return equiposCollection;
    }

    public void setEquiposCollection(Collection<Equipos> equiposCollection) {
        this.equiposCollection = equiposCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoequipo != null ? idtipoequipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEquipo)) {
            return false;
        }
        TipoEquipo other = (TipoEquipo) object;
        if ((this.idtipoequipo == null && other.idtipoequipo != null) || (this.idtipoequipo != null && !this.idtipoequipo.equals(other.idtipoequipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBD.TipoEquipo[ idtipoequipo=" + idtipoequipo + " ]";
    }
    
}
