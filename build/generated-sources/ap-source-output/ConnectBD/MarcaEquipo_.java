package ConnectBD;

import ConnectBD.Equipos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T21:09:15")
@StaticMetamodel(MarcaEquipo.class)
public class MarcaEquipo_ { 

    public static volatile SingularAttribute<MarcaEquipo, String> descripcionmarcaequipo;
    public static volatile CollectionAttribute<MarcaEquipo, Equipos> equiposCollection;
    public static volatile SingularAttribute<MarcaEquipo, Integer> idmarcaequipo;

}