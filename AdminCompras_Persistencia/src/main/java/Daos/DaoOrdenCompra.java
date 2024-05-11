/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import Conexion.Conexion;
import Entidades.ordenCompra;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author jesusmr
 */
public class DaoOrdenCompra {

    private final MongoCollection<ordenCompra> coleccionOrdenes;

    public DaoOrdenCompra() {
        coleccionOrdenes = Conexion.getDatabase().getCollection("OrdenCompra", ordenCompra.class);
    }

    public List<ordenCompra> consultar() throws Exception {
        try {
            List<ordenCompra> ordenes = new ArrayList<>();
            coleccionOrdenes.find().into(ordenes);
            return ordenes;
        } catch (MongoException ex) {
            throw new Exception("Error en Dao OrdenCompra - Método consultar");
        }
    }

    public void guardar(ordenCompra ordenCompra) throws Exception {
        try {
            coleccionOrdenes.insertOne(ordenCompra);
        } catch (MongoException ex) {
            throw new Exception("Error en Dao OrdenCompra - Método guardar");
        }
    }

    public void actualizar(ordenCompra ordenCompra) throws Exception {
        try {
            Document filtro = new Document("folio", ordenCompra.getFolio());
            Document actualizacion = new Document();
            actualizacion.put("$set", new Document("total", ordenCompra.getTotal())
                    .append("fechaExpedicion", ordenCompra.getFechaExpedicion())
                    .append("productos", ordenCompra.getProductos())
                    .append("estado", ordenCompra.getEstado()));
            coleccionOrdenes.updateOne(filtro, actualizacion);
        } catch (MongoException ex) {
            throw new Exception("Error en Dao OrdenCompra - Método actualizar");
        }
    }

    public void eliminar(ordenCompra ordenCompra) throws Exception {
        try {
            coleccionOrdenes.deleteOne(Filters.eq("_id", ordenCompra.getId()));
        } catch (MongoException ex) {
            throw new Exception("Error en Dao OrdenCompra - Método eliminar");
        }
    }

    public ordenCompra buscarPorID(ordenCompra ordenCompra) throws Exception {
        try {
            return coleccionOrdenes.find(Filters.eq("_id",ordenCompra.getId())).first();
        } catch (MongoException ex) {
            throw new Exception("Error en Dao OrdenCompra - Método buscarPorID");
        }
    }
}