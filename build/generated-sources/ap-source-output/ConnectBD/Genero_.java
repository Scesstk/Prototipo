package ConnectBD;

import ConnectBD.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T21:09:15")
@StaticMetamodel(Genero.class)
public class Genero_ { 

    public static volatile SingularAttribute<Genero, String> descripciongenero;
    public static volatile CollectionAttribute<Genero, Persona> personaCollection;
    public static volatile SingularAttribute<Genero, Integer> idgenero;

}