package ConnectBD;

import ConnectBD.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T21:09:15")
@StaticMetamodel(Acceso.class)
public class Acceso_ { 

    public static volatile SingularAttribute<Acceso, Persona> idpersona;
    public static volatile SingularAttribute<Acceso, Integer> idacceso;
    public static volatile SingularAttribute<Acceso, String> contrasena;
    public static volatile SingularAttribute<Acceso, String> activo;

}