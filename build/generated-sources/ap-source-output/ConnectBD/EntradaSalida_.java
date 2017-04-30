package ConnectBD;

import ConnectBD.Equipos;
import ConnectBD.Persona;
import ConnectBD.TipoEntradaSalida;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T21:09:15")
@StaticMetamodel(EntradaSalida.class)
public class EntradaSalida_ { 

    public static volatile SingularAttribute<EntradaSalida, Integer> identradasalida;
    public static volatile SingularAttribute<EntradaSalida, Date> fechahora;
    public static volatile CollectionAttribute<EntradaSalida, Equipos> equiposCollection;
    public static volatile SingularAttribute<EntradaSalida, TipoEntradaSalida> idtipoentradasalida;
    public static volatile SingularAttribute<EntradaSalida, Persona> idpersona;

}