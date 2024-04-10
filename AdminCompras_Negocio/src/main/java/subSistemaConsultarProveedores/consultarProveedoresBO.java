/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subSistemaConsultarProveedores;

import Entidades.pro_Pro;
import Entidades.pro_ProJpaController;
import Negocio.dto.ProductoDto;
import Negocio.dto.ProductoProveedorDto;
import Negocio.dto.ProveedorDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tacot
 */
public class consultarProveedoresBO implements IConsultarProveedores{
    @Override
    public List<ProductoProveedorDto> obtenerProveedores(Long idProducto) {
        pro_ProJpaController ppjc = new pro_ProJpaController();

        List<pro_Pro> pplist = ppjc.findpro_ProEntities();

        List<pro_Pro> provlist = new ArrayList<>();

        for (pro_Pro pp : pplist) {
            if (pp.getProducto().getId() == idProducto) {
                provlist.add(pp);
            }
        }

        List<ProductoProveedorDto> provlistdto = new ArrayList<>();

        for (pro_Pro p : provlist) {
            provlistdto.add(new ProductoProveedorDto(p.getPrecioP(), p.getStock(),
                    new ProductoDto(p.getProducto().getId(), p.getProducto().getNombre(), p.getProducto().getCodigo()),
                    new ProveedorDto(p.getProveedor().getId(), p.getProveedor().getNombre(), p.getProveedor().getTelefono())));
        }

        return provlistdto;
    }

    @Override
    public ProductoProveedorDto obtenerProductoProveedor(Long idProducto, Long idProveedor) {
        pro_ProJpaController ppjc = new pro_ProJpaController();
        List<pro_Pro> pplist = ppjc.findpro_ProEntities();

        for (pro_Pro pp : pplist) {
            if (idProducto == pp.getProducto().getId() && idProveedor == pp.getProveedor().getId()) {
                return new ProductoProveedorDto(pp.getPrecioP(), pp.getStock(), new ProductoDto(pp.getProducto().getId(), pp.getProducto().getNombre(), pp.getProducto().getCodigo()), new ProveedorDto(pp.getProveedor().getNombre(), pp.getProveedor().getTelefono()));
            }
        }

        return null;
    }

}
