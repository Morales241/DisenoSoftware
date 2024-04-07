package Producto;

import Producto.pro_Pro;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-06T21:25:58", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile ListAttribute<Proveedor, pro_Pro> productoProveedores;
    public static volatile SingularAttribute<Proveedor, Long> id;
    public static volatile SingularAttribute<Proveedor, String> telefono;
    public static volatile SingularAttribute<Proveedor, String> nombre;

}