///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Negocio.objetosNegocio;
//
//import Entidades.ProComprado;
//import Negocio.dto.ProductoCompradoDto;
//import Negocio.dto.ProductoDto;
//import Negocio.dto.ProductoProveedorDto;
//import Negocio.dto.ProveedorDto;
//import java.util.List;
//
///**
// *
// * @author marlon
// */
//public interface IOrdenNegocio {
//    //ya
//    void realizarOrden(List<ProductoCompradoDto> prdsDto);
//    
//    //ya
//    List<ProductoDto> obtenerProductos();
//
//    //ya
//    List<ProductoProveedorDto> obtenerProveedores(Long codigoProducto)throws Exception;
//    
//    //ya
//    ProductoProveedorDto obtenerProductoProveedor(Long idProducto, Long idProveedor);
//    
//    //ya
//    public List<ProductoDto> obtenerCoincidenciasProductos(String palabra);
//    
//    //ya
//    boolean verificarPresupuesto(Double cantidad);
//    
//    //ya
//    List<ProductoCompradoDto> obtenerProductosPorAgotarse();
//    
//    //subsistema de insercion
//    public void insercion();
//}
