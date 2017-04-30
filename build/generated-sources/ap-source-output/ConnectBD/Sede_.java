package ConnectBD;

import ConnectBD.Centros;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T21:09:15")
@StaticMetamodel(Sede.class)
public class Sede_ { 

    public static volatile SingularAttribute<Sede, String> nomsede;
    public static volatile SingularAttribute<Sede, Integer> codsenasede;
    public static volatile CollectionAttribute<Sede, Centros> centrosCollection;
    public static volatile SingularAttribute<Sede, Integer> idsede;

}