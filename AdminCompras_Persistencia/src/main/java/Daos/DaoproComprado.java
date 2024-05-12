/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;


import Conexion.Conexion;
import Entidades.ordenCompra;
import Entidades.proComprado;
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
public class DaoproComprado {
    private final MongoCollection<proComprado> coleccionproductos;

    public DaoproComprado() {
        coleccionproductos = Conexion.getDatabase().getCollection("proComprado", proComprado.class);
    }

    public List<proComprado> consultar() throws Exception {
        try {
            List<proComprado> productos = new ArrayList<>();
            coleccionproductos.find().into(productos);
            return productos;
        } catch (MongoException ex) {
            throw new Exception("Error en Dao proComprado - Método consultar");
        }
    }

    public void guardar(proComprado proComprado) throws Exception {
        try {
            coleccionproductos.insertOne(proComprado);
        } catch (MongoException ex) {
            throw new Exception("Error en Dao proComprado - Método guardar");
        }
    }

    public void actualizar(proComprado proComprado) throws Exception {
        try {
            Document filtro = new Document("_id", proComprado.getId());
            Document actualizacion = new Document();
            actualizacion.put("$set", new Document("nombre", proComprado.getNombre())
                    .append("codigo", proComprado.getCodigo())
                    .append("cantidad", proComprado.getCantidad()));
            coleccionproductos.updateOne(filtro, actualizacion);
        } catch (MongoException ex) {
            throw new Exception("Error en Dao proComprado - Método actualizar");
        }
    }

    public void eliminar(proComprado proComprado) throws Exception {
        try {
            coleccionproductos.deleteOne(Filters.eq("_id", proComprado.getId()));
        } catch (MongoException ex) {
            throw new Exception("Error en Dao proComprado - Método eliminar");
        }
    }

    public proComprado buscarPorID(proComprado proComprado) throws Exception {
        try {
            return coleccionproductos.find(Filters.eq("_id", proComprado.getId())).first();
        } catch (MongoException ex) {
            throw new Exception("Error en Dao proComprado - Método buscarPorID");
        }
    }
}
