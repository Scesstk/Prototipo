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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FGALLARDO
 */
@Entity
@Table(name = "centros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centros.findAll", query = "SELECT c FROM Centros c")
    , @NamedQuery(name = "Centros.findByIdcentros", query = "SELECT c FROM Centros c WHERE c.idcentros = :idcentros")
    , @NamedQuery(name = "Centros.findByNomcentro", query = "SELECT c FROM Centros c WHERE c.nomcentro = :nomcentro")
    , @NamedQuery(name = "Centros.findByCodsenacentro", query = "SELECT c FROM Centros c WHERE c.codsenacentro = :codsenacentro")})
public class Centros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_centros")
    private Integer idcentros;
    @Column(name = "Nom_centro")
    private String nomcentro;
    @Column(name = "Cod_sena_centro")
    private Integer codsenacentro;
    @JoinTable(name = "centro_sede", joinColumns = {
        @JoinColumn(name = "Id_centros", referencedColumnName = "Id_centros")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_sede", referencedColumnName = "Id_sede")})
    @ManyToMany
    private Collection<Sede> sedeCollection;
    @OneToMany(mappedBy = "idcentros")
    private Collection<Persona> personaCollection;
    @JoinColumn(name = "Id_ciudad", referencedColumnName = "Id_ciudad")
    @ManyToOne
    private Ciudad idciudad;

    public Centros() {
    }

    public Centros(Integer idcentros) {
        this.idcentros = idcentros;
    }

    public Integer getIdcentros() {
        return idcentros;
    }

    public void setIdcentros(Integer idcentros) {
        this.idcentros = idcentros;
    }

    public String getNomcentro() {
        return nomcentro;
    }

    public void setNomcentro(String nomcentro) {
        this.nomcentro = nomcentro;
    }

    public Integer getCodsenacentro() {
        return codsenacentro;
    }

    public void setCodsenacentro(Integer codsenacentro) {
        this.codsenacentro = codsenacentro;
    }

    @XmlTransient
    public Collection<Sede> getSedeCollection() {
        return sedeCollection;
    }

    public void setSedeCollection(Collection<Sede> sedeCollection) {
        this.sedeCollection = sedeCollection;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcentros != null ? idcentros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centros)) {
            return false;
        }
        Centros other = (Centros) object;
        if ((this.idcentros == null && other.idcentros != null) || (this.idcentros != null && !this.idcentros.equals(other.idcentros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBD.Centros[ idcentros=" + idcentros + " ]";
    }
    
}
