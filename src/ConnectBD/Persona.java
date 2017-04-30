/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectBD;

import java.io.Serializable;
import java.sql.*;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdpersona", query = "SELECT p FROM Persona p WHERE p.idpersona = :idpersona")
    , @NamedQuery(name = "Persona.findByNumdocumento", query = "SELECT p FROM Persona p WHERE p.numdocumento = :numdocumento")
    , @NamedQuery(name = "Persona.findByNombre1", query = "SELECT p FROM Persona p WHERE p.nombre1 = :nombre1")
    , @NamedQuery(name = "Persona.findByNombre2", query = "SELECT p FROM Persona p WHERE p.nombre2 = :nombre2")
    , @NamedQuery(name = "Persona.findByApellido1", query = "SELECT p FROM Persona p WHERE p.apellido1 = :apellido1")
    , @NamedQuery(name = "Persona.findByApellido2", query = "SELECT p FROM Persona p WHERE p.apellido2 = :apellido2")
    , @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Persona.findByTelfonofijo", query = "SELECT p FROM Persona p WHERE p.telfonofijo = :telfonofijo")
    , @NamedQuery(name = "Persona.findByCelular", query = "SELECT p FROM Persona p WHERE p.celular = :celular")
    , @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_persona")
    private Integer idpersona;
    @Basic(optional = false)
    @Column(name = "Num_documento")
    private int numdocumento;
    @Basic(optional = false)
    @Column(name = "Nombre_1")
    private String nombre1;
    @Column(name = "Nombre_2")
    private String nombre2;
    @Basic(optional = false)
    @Column(name = "Apellido_1")
    private String apellido1;
    @Column(name = "Apellido_2")
    private String apellido2;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Telfono_fijo")
    private Integer telfonofijo;
    @Column(name = "celular")
    private Integer celular;
    @Column(name = "correo")
    private String correo;
    @ManyToMany(mappedBy = "personaCollection")
    private Collection<Equipos> equiposCollection;
    @JoinColumn(name = "Id_centros", referencedColumnName = "Id_centros")
    @ManyToOne
    private Centros idcentros;
    @JoinColumn(name = "Id_documento", referencedColumnName = "Id_documento")
    @ManyToOne
    private Documento iddocumento;
    @JoinColumn(name = "Id_ficha", referencedColumnName = "Id_ficha")
    @ManyToOne
    private Ficha idficha;
    @JoinColumn(name = "Id_genero", referencedColumnName = "Id_genero")
    @ManyToOne
    private Genero idgenero;
    @JoinColumn(name = "Id_rh", referencedColumnName = "Id_rh")
    @ManyToOne
    private Rh idrh;
    @JoinColumn(name = "Id_rol", referencedColumnName = "Id_rol")
    @ManyToOne
    private Rol idrol;
    @JoinColumn(name = "Id_tipo_persona", referencedColumnName = "Id_tipo_persona")
    @ManyToOne
    private TipoPersona idtipopersona;
    @OneToMany(mappedBy = "idpersona")
    private Collection<Acceso> accesoCollection;
    @OneToMany(mappedBy = "idpersona")
    private Collection<EntradaSalida> entradaSalidaCollection;


    public Persona() {
    }

    public Persona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Persona(Integer idpersona, int numdocumento, String nombre1, String apellido1) {
        this.idpersona = idpersona;
        this.numdocumento = numdocumento;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public int getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(int numdocumento) {
        this.numdocumento = numdocumento;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelfonofijo() {
        return telfonofijo;
    }

    public void setTelfonofijo(Integer telfonofijo) {
        this.telfonofijo = telfonofijo;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public Collection<Equipos> getEquiposCollection() {
        return equiposCollection;
    }

    public void setEquiposCollection(Collection<Equipos> equiposCollection) {
        this.equiposCollection = equiposCollection;
    }

    public Centros getIdcentros() {
        return idcentros;
    }

    public void setIdcentros(Centros idcentros) {
        this.idcentros = idcentros;
    }

    public Documento getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(Documento iddocumento) {
        this.iddocumento = iddocumento;
    }

    public Ficha getIdficha() {
        return idficha;
    }

    public void setIdficha(Ficha idficha) {
        this.idficha = idficha;
    }

    public Genero getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(Genero idgenero) {
        this.idgenero = idgenero;
    }

    public Rh getIdrh() {
        return idrh;
    }

    public void setIdrh(Rh idrh) {
        this.idrh = idrh;
    }

    public Rol getIdrol() {
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;
    }

    public TipoPersona getIdtipopersona() {
        return idtipopersona;
    }

    public void setIdtipopersona(TipoPersona idtipopersona) {
        this.idtipopersona = idtipopersona;
    }

    @XmlTransient
    public Collection<Acceso> getAccesoCollection() {
        return accesoCollection;
    }

    public void setAccesoCollection(Collection<Acceso> accesoCollection) {
        this.accesoCollection = accesoCollection;
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
        hash += (idpersona != null ? idpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idpersona == null && other.idpersona != null) || (this.idpersona != null && !this.idpersona.equals(other.idpersona))) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "ConnectBD.Persona[ idpersona=" + idpersona + " ]";
    }

  
    
    
    
}
