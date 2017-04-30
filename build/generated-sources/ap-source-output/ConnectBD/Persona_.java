package ConnectBD;

import ConnectBD.Acceso;
import ConnectBD.Centros;
import ConnectBD.Documento;
import ConnectBD.EntradaSalida;
import ConnectBD.Equipos;
import ConnectBD.Ficha;
import ConnectBD.Genero;
import ConnectBD.Rh;
import ConnectBD.Rol;
import ConnectBD.TipoPersona;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T21:09:15")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, Rh> idrh;
    public static volatile SingularAttribute<Persona, String> apellido2;
    public static volatile SingularAttribute<Persona, Rol> idrol;
    public static volatile SingularAttribute<Persona, Documento> iddocumento;
    public static volatile SingularAttribute<Persona, String> apellido1;
    public static volatile SingularAttribute<Persona, Integer> idpersona;
    public static volatile SingularAttribute<Persona, String> direccion;
    public static volatile CollectionAttribute<Persona, Acceso> accesoCollection;
    public static volatile SingularAttribute<Persona, Integer> telfonofijo;
    public static volatile SingularAttribute<Persona, String> nombre2;
    public static volatile SingularAttribute<Persona, String> nombre1;
    public static volatile SingularAttribute<Persona, Integer> numdocumento;
    public static volatile CollectionAttribute<Persona, Equipos> equiposCollection;
    public static volatile SingularAttribute<Persona, String> correo;
    public static volatile SingularAttribute<Persona, TipoPersona> idtipopersona;
    public static volatile SingularAttribute<Persona, Integer> celular;
    public static volatile CollectionAttribute<Persona, EntradaSalida> entradaSalidaCollection;
    public static volatile SingularAttribute<Persona, Genero> idgenero;
    public static volatile SingularAttribute<Persona, Centros> idcentros;
    public static volatile SingularAttribute<Persona, Ficha> idficha;

}