package ConnectBD;

import ConnectBD.EntradaSalida;
import ConnectBD.MarcaEquipo;
import ConnectBD.Persona;
import ConnectBD.TipoEquipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T21:09:15")
@StaticMetamodel(Equipos.class)
public class Equipos_ { 

    public static volatile CollectionAttribute<Equipos, Persona> personaCollection;
    public static volatile SingularAttribute<Equipos, String> serial;
    public static volatile SingularAttribute<Equipos, TipoEquipo> idtipoequipo;
    public static volatile SingularAttribute<Equipos, MarcaEquipo> idmarcaequipo;
    public static volatile SingularAttribute<Equipos, Integer> idequipos;
    public static volatile CollectionAttribute<Equipos, EntradaSalida> entradaSalidaCollection;
    public static volatile SingularAttribute<Equipos, String> modelo;

}