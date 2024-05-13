/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;


import Conexion.Conexion;
import Entidades.proInventario;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
/**
 *
 * @author jesusmr
 */
public class DaoproInventario {
    private final MongoCollection<proInventario> coleccionproductos;

    public DaoproInventario() {
        coleccionproductos = Conexion.getDatabase().getCollection("proInventario", proInventario.class);
    }

    public List<proInventario> consultar() throws Exception {
        try {
            List<proInventario> productos = new ArrayList<>();
            coleccionproductos.find().into(productos);
            return productos;
        } catch (MongoException ex) {
            throw new Exception("Error en Dao proInventario - Método consultar");
        }
    }

    public void guardar(proInventario proInventario) throws Exception {
        try {
            coleccionproductos.insertOne(proInventario);
        } catch (MongoException ex) {
            throw new Exception("Error en Dao proInventario - Método guardar");
        }
    }

    public void actualizar(proInventario proInventario) throws Exception {
        try {
            Document filtro = new Document("codigo", proInventario.getCodigo());
            Document actualizacion = new Document();
            actualizacion.put("$set", new Document("nombre", proInventario.getNombre())
                    .append("codigo", proInventario.getCodigo())
                    .append("cantidad", proInventario.getCantidad()));
            coleccionproductos.updateOne(filtro, actualizacion);
        } catch (MongoException ex) {
            throw new Exception("Error en Dao proInventario - Método actualizar");
        }
    }

    public void eliminar(proInventario proInventario) throws Exception {
        try {
            coleccionproductos.deleteOne(Filters.eq("codigo", proInventario.getCodigo()));
        } catch (MongoException ex) {
            throw new Exception("Error en Dao proInventario - Método eliminar");
        }
    }

    public proInventario buscarPorCodigo(proInventario proInventario) throws Exception {
        try {
            return coleccionproductos.find(Filters.eq("codigo", proInventario.getCodigo())).first();
        } catch (MongoException ex) {
            throw new Exception("Error en Dao proInventario - Método buscarPorID");
        }
    }
}
