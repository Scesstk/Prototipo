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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FGALLARDO
 */
@Entity
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e")
    , @NamedQuery(name = "Equipos.findByIdequipos", query = "SELECT e FROM Equipos e WHERE e.idequipos = :idequipos")
    , @NamedQuery(name = "Equipos.findByModelo", query = "SELECT e FROM Equipos e WHERE e.modelo = :modelo")
    , @NamedQuery(name = "Equipos.findBySerial", query = "SELECT e FROM Equipos e WHERE e.serial = :serial")})
public class Equipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_equipos")
    private Integer idequipos;
    @Column(name = "Modelo")
    private String modelo;
    @Column(name = "Serial")
    private String serial;
    @JoinTable(name = "persona_equipos", joinColumns = {
        @JoinColumn(name = "Id_equipos", referencedColumnName = "Id_equipos")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_persona", referencedColumnName = "Id_persona")})
    @ManyToMany
    private Collection<Persona> personaCollection;
    @ManyToMany(mappedBy = "equiposCollection")
    private Collection<EntradaSalida> entradaSalidaCollection;
    @JoinColumn(name = "Id_marca_equipo", referencedColumnName = "Id_marca_equipo")
    @ManyToOne
    private MarcaEquipo idmarcaequipo;
    @JoinColumn(name = "Id_tipo_equipo", referencedColumnName = "Id_tipo_equipo")
    @ManyToOne
    private TipoEquipo idtipoequipo;

    public Equipos() {
    }

    public Equipos(Integer idequipos) {
        this.idequipos = idequipos;
    }

    public Integer getIdequipos() {
        return idequipos;
    }

    public void setIdequipos(Integer idequipos) {
        this.idequipos = idequipos;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @XmlTransient
    public Collection<EntradaSalida> getEntradaSalidaCollection() {
        return entradaSalidaCollection;
    }

    public void setEntradaSalidaCollection(Collection<EntradaSalida> entradaSalidaCollection) {
        this.entradaSalidaCollection = entradaSalidaCollection;
    }

    public MarcaEquipo getIdmarcaequipo() {
        return idmarcaequipo;
    }

    public void setIdmarcaequipo(MarcaEquipo idmarcaequipo) {
        this.idmarcaequipo = idmarcaequipo;
    }

    public TipoEquipo getIdtipoequipo() {
        return idtipoequipo;
    }

    public void setIdtipoequipo(TipoEquipo idtipoequipo) {
        this.idtipoequipo = idtipoequipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequipos != null ? idequipos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.idequipos == null && other.idequipos != null) || (this.idequipos != null && !this.idequipos.equals(other.idequipos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBD.Equipos[ idequipos=" + idequipos + " ]";
    }
    
}
