package ConnectBD;

import ConnectBD.EntradaSalida;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T21:09:15")
@StaticMetamodel(TipoEntradaSalida.class)
public class TipoEntradaSalida_ { 

    public static volatile SingularAttribute<TipoEntradaSalida, String> descripciontipoentradasalida;
    public static volatile SingularAttribute<TipoEntradaSalida, Integer> idtipoentradasalida;
    public static volatile CollectionAttribute<TipoEntradaSalida, EntradaSalida> entradaSalidaCollection;

}