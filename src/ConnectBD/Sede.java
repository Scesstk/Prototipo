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
import javax.persistence.ManyToMany;
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
@Table(name = "sede")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sede.findAll", query = "SELECT s FROM Sede s")
    , @NamedQuery(name = "Sede.findByIdsede", query = "SELECT s FROM Sede s WHERE s.idsede = :idsede")
    , @NamedQuery(name = "Sede.findByNomsede", query = "SELECT s FROM Sede s WHERE s.nomsede = :nomsede")
    , @NamedQuery(name = "Sede.findByCodsenasede", query = "SELECT s FROM Sede s WHERE s.codsenasede = :codsenasede")})
public class Sede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_sede")
    private Integer idsede;
    @Column(name = "Nom_sede")
    private String nomsede;
    @Column(name = "Cod_sena_sede")
    private Integer codsenasede;
    @ManyToMany(mappedBy = "sedeCollection")
    private Collection<Centros> centrosCollection;

    public Sede() {
    }

    public Sede(Integer idsede) {
        this.idsede = idsede;
    }

    public Integer getIdsede() {
        return idsede;
    }

    public void setIdsede(Integer idsede) {
        this.idsede = idsede;
    }

    public String getNomsede() {
        return nomsede;
    }

    public void setNomsede(String nomsede) {
        this.nomsede = nomsede;
    }

    public Integer getCodsenasede() {
        return codsenasede;
    }

    public void setCodsenasede(Integer codsenasede) {
        this.codsenasede = codsenasede;
    }

    @XmlTransient
    public Collection<Centros> getCentrosCollection() {
        return centrosCollection;
    }

    public void setCentrosCollection(Collection<Centros> centrosCollection) {
        this.centrosCollection = centrosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsede != null ? idsede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.idsede == null && other.idsede != null) || (this.idsede != null && !this.idsede.equals(other.idsede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBD.Sede[ idsede=" + idsede + " ]";
    }
    
}
