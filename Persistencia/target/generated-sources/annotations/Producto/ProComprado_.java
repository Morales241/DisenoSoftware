package Producto;

import Producto.OrdenCompra;
import Producto.Proveedor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-06T21:25:58", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ProComprado.class)
public class ProComprado_ { 

    public static volatile SingularAttribute<ProComprado, String> codigo;
    public static volatile SingularAttribute<ProComprado, Double> precio;
    public static volatile SingularAttribute<ProComprado, Proveedor> proveedor;
    public static volatile SingularAttribute<ProComprado, Long> id;
    public static volatile SingularAttribute<ProComprado, Integer> cantidad;
    public static volatile SingularAttribute<ProComprado, OrdenCompra> orden;
    public static volatile SingularAttribute<ProComprado, String> nombre;

}