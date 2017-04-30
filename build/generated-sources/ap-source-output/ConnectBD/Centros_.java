package ConnectBD;

import ConnectBD.Ciudad;
import ConnectBD.Persona;
import ConnectBD.Sede;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T21:09:15")
@StaticMetamodel(Centros.class)
public class Centros_ { 

    public static volatile CollectionAttribute<Centros, Persona> personaCollection;
    public static volatile SingularAttribute<Centros, Integer> codsenacentro;
    public static volatile SingularAttribute<Centros, String> nomcentro;
    public static volatile CollectionAttribute<Centros, Sede> sedeCollection;
    public static volatile SingularAttribute<Centros, Ciudad> idciudad;
    public static volatile SingularAttribute<Centros, Integer> idcentros;

}