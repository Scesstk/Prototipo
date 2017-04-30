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
@Table(name = "tipo_entrada_salida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEntradaSalida.findAll", query = "SELECT t FROM TipoEntradaSalida t")
    , @NamedQuery(name = "TipoEntradaSalida.findByIdtipoentradasalida", query = "SELECT t FROM TipoEntradaSalida t WHERE t.idtipoentradasalida = :idtipoentradasalida")
    , @NamedQuery(name = "TipoEntradaSalida.findByDescripciontipoentradasalida", query = "SELECT t FROM TipoEntradaSalida t WHERE t.descripciontipoentradasalida = :descripciontipoentradasalida")})
public class TipoEntradaSalida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_tipo_entrada_salida")
    private Integer idtipoentradasalida;
    @Column(name = "Descripcion_tipo_entrada_salida")
    private String descripciontipoentradasalida;
    @OneToMany(mappedBy = "idtipoentradasalida")
    private Collection<EntradaSalida> entradaSalidaCollection;

    public TipoEntradaSalida() {
    }

    public TipoEntradaSalida(Integer idtipoentradasalida) {
        this.idtipoentradasalida = idtipoentradasalida;
    }

    public Integer getIdtipoentradasalida() {
        return idtipoentradasalida;
    }

    public void setIdtipoentradasalida(Integer idtipoentradasalida) {
        this.idtipoentradasalida = idtipoentradasalida;
    }

    public String getDescripciontipoentradasalida() {
        return descripciontipoentradasalida;
    }

    public void setDescripciontipoentradasalida(String descripciontipoentradasalida) {
        this.descripciontipoentradasalida = descripciontipoentradasalida;
    }

    @XmlTransient
    public Collection<EntradaSalida> getEntradaSalidaCollection() {
        return entradaSalidaCollection;
    }

    public void setEntradaSalidaCollection(Collection<EntradaSalida> entradaSalidaCollection) {
        this.entradaSalidaCollection = entradaSalidaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoentradasalida != null ? idtipoentradasalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEntradaSalida)) {
            return false;
        }
        TipoEntradaSalida other = (TipoEntradaSalida) object;
        if ((this.idtipoentradasalida == null && other.idtipoentradasalida != null) || (this.idtipoentradasalida != null && !this.idtipoentradasalida.equals(other.idtipoentradasalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConnectBD.TipoEntradaSalida[ idtipoentradasalida=" + idtipoentradasalida + " ]";
    }
    
}
