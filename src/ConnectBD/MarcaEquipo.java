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
@Table(name = "marca_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaEquipo.findAll", query = "SELECT m FROM MarcaEquipo m")
    , @NamedQuery(name = "MarcaEquipo.findByIdmarcaequipo", query = "SELECT m FROM MarcaEquipo m WHERE m.idmarcaequipo = :idmarcaequipo")
    , @NamedQuery(name = "MarcaEquipo.findByDescripcionmarcaequipo", query = "SELECT m FROM MarcaEquipo m WHERE m.descripcionmarcaequipo = :descripcionmarcaequipo")})
public class MarcaEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_marca_equipo")
    private Integer idmarcaequipo;
    @Column(name = "Descripcion_marca_equipo")
    private String descripcionmarcaequipo;
    @OneToMany(mappedBy = "idmarcaequipo")
    private Collection<Equipos> equiposCollection;

    public MarcaEquipo() {
    }

    public MarcaEquipo(Integer idmarcaequipo) {
        this.idmarcaequipo = idmarcaequipo;
    }

    public Integer getIdmarcaequipo() {
        return idmarcaequipo;
    }

    public void setIdmarcaequipo(Integer idmarcaequipo) {
        this.idmarcaequipo = idmarcaequipo;
    }

    public String getDescripcionmarcaequipo() {
        return descripcionmarcaequipo;
    }

    public void setDescripcionmarcaequipo(String descripcionmarcaequipo) {
        this.descripcionmarcaequipo = descripcionmarcaequipo;
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
        hash += (idmarcaequipo != null ? idmarcaequipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaEquipo)) {
            return false;
        }
        MarcaEquipo other = (MarcaEquipo) object;
        if ((this.idmarcaequipo == null && other.idmarcaequipo != null) || (this.idmarcaequipo != null && !this.idmarcaequipo.equals(other.idmarcaequipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBD.MarcaEquipo[ idmarcaequipo=" + idmarcaequipo + " ]";
    }
    
}
