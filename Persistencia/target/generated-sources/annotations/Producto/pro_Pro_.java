package Producto;

import Producto.Producto;
import Producto.Proveedor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-06T21:25:58", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(pro_Pro.class)
public class pro_Pro_ { 

    public static volatile SingularAttribute<pro_Pro, String> precioP;
    public static volatile SingularAttribute<pro_Pro, Proveedor> proveedor;
    public static volatile SingularAttribute<pro_Pro, Long> id;
    public static volatile SingularAttribute<pro_Pro, Producto> producto;
    public static volatile SingularAttribute<pro_Pro, Integer> stock;

}