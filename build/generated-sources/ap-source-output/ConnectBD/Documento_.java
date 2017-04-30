package ConnectBD;

import ConnectBD.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T21:09:15")
@StaticMetamodel(Documento.class)
public class Documento_ { 

    public static volatile CollectionAttribute<Documento, Persona> personaCollection;
    public static volatile SingularAttribute<Documento, Integer> iddocumento;
    public static volatile SingularAttribute<Documento, String> descripciontipdocumento;

}