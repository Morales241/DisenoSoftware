package Producto;

import Producto.pro_Pro;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-06T22:47:35", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile ListAttribute<Producto, pro_Pro> productoProveedores;
    public static volatile SingularAttribute<Producto, String> codigo;
    public static volatile SingularAttribute<Producto, Long> id;
    public static volatile SingularAttribute<Producto, String> nombre;

}