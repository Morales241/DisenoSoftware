package Producto;

import Producto.ProComprado;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-06T22:47:35", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(OrdenCompra.class)
public class OrdenCompra_ { 

    public static volatile SingularAttribute<OrdenCompra, Double> total;
    public static volatile SingularAttribute<OrdenCompra, Long> id;
    public static volatile ListAttribute<OrdenCompra, ProComprado> productos;

}