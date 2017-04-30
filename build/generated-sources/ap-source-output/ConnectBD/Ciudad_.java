package ConnectBD;

import ConnectBD.Centros;
import ConnectBD.Departamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T21:09:15")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile SingularAttribute<Ciudad, Integer> idciudad;
    public static volatile SingularAttribute<Ciudad, String> nomciudad;
    public static volatile CollectionAttribute<Ciudad, Centros> centrosCollection;
    public static volatile SingularAttribute<Ciudad, Departamento> iddepartamento;

}