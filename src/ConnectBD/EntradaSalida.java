/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectBD;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FGALLARDO
 */
@Entity
@Table(name = "entrada_salida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntradaSalida.findAll", query = "SELECT e FROM EntradaSalida e")
    , @NamedQuery(name = "EntradaSalida.findByIdentradasalida", query = "SELECT e FROM EntradaSalida e WHERE e.identradasalida = :identradasalida")
    , @NamedQuery(name = "EntradaSalida.findByFechahora", query = "SELECT e FROM EntradaSalida e WHERE e.fechahora = :fechahora")})
public class EntradaSalida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_entrada_salida")
    private Integer identradasalida;
    @Column(name = "Fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    @JoinTable(name = "entrada_salida_equipo", joinColumns = {
        @JoinColumn(name = "Id_entrada_salida", referencedColumnName = "Id_entrada_salida")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_equipos", referencedColumnName = "Id_equipos")})
    @ManyToMany
    private Collection<Equipos> equiposCollection;
    @JoinColumn(name = "Id_tipo_entrada_salida", referencedColumnName = "Id_tipo_entrada_salida")
    @ManyToOne
    private TipoEntradaSalida idtipoentradasalida;
    @JoinColumn(name = "Id_persona", referencedColumnName = "Id_persona")
    @ManyToOne
    private Persona idpersona;

    public EntradaSalida() {
    }

    public EntradaSalida(Integer identradasalida) {
        this.identradasalida = identradasalida;
    }

    public Integer getIdentradasalida() {
        return identradasalida;
    }

    public void setIdentradasalida(Integer identradasalida) {
        this.identradasalida = identradasalida;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    @XmlTransient
    public Collection<Equipos> getEquiposCollection() {
        return equiposCollection;
    }

    public void setEquiposCollection(Collection<Equipos> equiposCollection) {
        this.equiposCollection = equiposCollection;
    }

    public TipoEntradaSalida getIdtipoentradasalida() {
        return idtipoentradasalida;
    }

    public void setIdtipoentradasalida(TipoEntradaSalida idtipoentradasalida) {
        this.idtipoentradasalida = idtipoentradasalida;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identradasalida != null ? identradasalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaSalida)) {
            return false;
        }
        EntradaSalida other = (EntradaSalida) object;
        if ((this.identradasalida == null && other.identradasalida != null) || (this.identradasalida != null && !this.identradasalida.equals(other.identradasalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBD.EntradaSalida[ identradasalida=" + identradasalida + " ]";
    }
    
}
