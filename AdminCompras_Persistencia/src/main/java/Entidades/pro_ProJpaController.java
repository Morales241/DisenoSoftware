/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Producto.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author tacot
 */
public class pro_ProJpaController implements Serializable {

    
    
    public pro_ProJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ConexionPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(pro_Pro pro_Pro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto = pro_Pro.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getId());
                pro_Pro.setProducto(producto);
            }
            Proveedor proveedor = pro_Pro.getProveedor();
            if (proveedor != null) {
                proveedor = em.getReference(proveedor.getClass(), proveedor.getId());
                pro_Pro.setProveedor(proveedor);
            }
            em.persist(pro_Pro);
            if (producto != null) {
                producto.getProductoProveedores().add(pro_Pro);
                producto = em.merge(producto);
            }
            if (proveedor != null) {
                proveedor.getProductoProveedores().add(pro_Pro);
                proveedor = em.merge(proveedor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void insercion(){
    
        
        Producto producto1 = new Producto("Jeringa", "132313");
        Producto producto2 = new Producto("Guantes médicos", "132314");
        Producto producto3 = new Producto("Bisturí", "132315");
        Producto producto4 = new Producto("Termómetro", "132316");
        Producto producto5 = new Producto("Estetoscopio", "132317");
        Producto producto6 = new Producto("Tensiómetro", "132318");
        Producto producto7 = new Producto("Vendaje", "132319");
        Producto producto8 = new Producto("Gasas", "132320");
        Producto producto9 = new Producto("Espejo bucal", "132321");
        Producto producto10 = new Producto("Pinzas", "132322");
        Producto producto11 = new Producto("Sonda Foley", "132323");
        Producto producto12 = new Producto("Electrocardiógrafo", "132324");
        Producto producto13 = new Producto("Mascarilla de oxígeno", "132325");
        Producto producto14 = new Producto("Camilla", "132326");
        Producto producto15 = new Producto("Desfibrilador", "132327");
        Producto producto16 = new Producto("Microscopio", "132328");
        Producto producto17 = new Producto("Tubo de ensayo", "132329");
        Producto producto18 = new Producto("Bata de hospital", "132330");
        Producto producto19 = new Producto("Silla de ruedas", "132331");
        Producto producto20 = new Producto("Respirador artificial", "132332");

        Proveedor proveedor1 = new Proveedor("Juan Pérez", "644-456-7890");
        Proveedor proveedor2 = new Proveedor("Ana Sánchez", "644-567-8901");
        Proveedor proveedor3 = new Proveedor("Carlos García", "644-678-9012");
        Proveedor proveedor4 = new Proveedor("María Rodríguez", "644-789-0123");
        Proveedor proveedor5 = new Proveedor("Luis Martínez", "644-890-1234");

        // Crear una lista de todos los productos
        List<Producto> productos = Arrays.asList(producto1, producto2, producto3, producto4, producto5, producto6, producto7, producto8, producto9, producto10, producto11, producto12, producto13, producto14, producto15, producto16, producto17, producto18, producto19, producto20);

        // Crear una lista de todos los proveedores
        List<Proveedor> proveedores = Arrays.asList(proveedor1, proveedor2, proveedor3, proveedor4, proveedor5);

        // Crear una lista para almacenar todas las relaciones producto-proveedor
        List<pro_Pro> productoProveedores = new ArrayList<>();

        // Crear un generador de números aleatorios
        Random rand = new Random();

        // Para cada proveedor, asignar 10 productos al azar
        for (Proveedor proveedor : proveedores) {
            // Mezclar la lista de productos
            Collections.shuffle(productos);

            for (int i = 0; i < 10; i++) {
                Producto producto = productos.get(i);

                // Generar un precio y una cantidad de stock aleatorios
                // Precio entre 50.00 y 150.00
                double numero = 50 + (150 - 50) * rand.nextDouble();
                String numeroR = String.format("%.2f", numero);
                double precioP = Double.parseDouble(numeroR);

                // Stock entre 1 y 100
                int stock = rand.nextInt(100) + 1;

                // Crear una nueva relación producto-proveedor con el precio y el stock generados
                pro_Pro productoProveedor = new pro_Pro(precioP, stock, producto, proveedor);
                productoProveedores.add(productoProveedor);
            }
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        for (pro_Pro p : productoProveedores) {
            em.persist(p);
        }
        
        Finanzas f = new Finanzas(5000.50);
        
        em.persist(f);
        
        em.getTransaction().commit();

        em.close();
        emf.close();
        
        
    };

    public void edit(pro_Pro pro_Pro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pro_Pro persistentpro_Pro = em.find(pro_Pro.class, pro_Pro.getId());
            Producto productoOld = persistentpro_Pro.getProducto();
            Producto productoNew = pro_Pro.getProducto();
            Proveedor proveedorOld = persistentpro_Pro.getProveedor();
            Proveedor proveedorNew = pro_Pro.getProveedor();
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getId());
                pro_Pro.setProducto(productoNew);
            }
            if (proveedorNew != null) {
                proveedorNew = em.getReference(proveedorNew.getClass(), proveedorNew.getId());
                pro_Pro.setProveedor(proveedorNew);
            }
            pro_Pro = em.merge(pro_Pro);
            if (productoOld != null && !productoOld.equals(productoNew)) {
                productoOld.getProductoProveedores().remove(pro_Pro);
                productoOld = em.merge(productoOld);
            }
            if (productoNew != null && !productoNew.equals(productoOld)) {
                productoNew.getProductoProveedores().add(pro_Pro);
                productoNew = em.merge(productoNew);
            }
            if (proveedorOld != null && !proveedorOld.equals(proveedorNew)) {
                proveedorOld.getProductoProveedores().remove(pro_Pro);
                proveedorOld = em.merge(proveedorOld);
            }
            if (proveedorNew != null && !proveedorNew.equals(proveedorOld)) {
                proveedorNew.getProductoProveedores().add(pro_Pro);
                proveedorNew = em.merge(proveedorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pro_Pro.getId();
                if (findpro_Pro(id) == null) {
                    throw new NonexistentEntityException("The pro_Pro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pro_Pro pro_Pro;
            try {
                pro_Pro = em.getReference(pro_Pro.class, id);
                pro_Pro.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pro_Pro with id " + id + " no longer exists.", enfe);
            }
            Producto producto = pro_Pro.getProducto();
            if (producto != null) {
                producto.getProductoProveedores().remove(pro_Pro);
                producto = em.merge(producto);
            }
            Proveedor proveedor = pro_Pro.getProveedor();
            if (proveedor != null) {
                proveedor.getProductoProveedores().remove(pro_Pro);
                proveedor = em.merge(proveedor);
            }
            em.remove(pro_Pro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<pro_Pro> findpro_ProEntities() {
        return findpro_ProEntities(true, -1, -1);
    }

    public List<pro_Pro> findpro_ProEntities(int maxResults, int firstResult) {
        return findpro_ProEntities(false, maxResults, firstResult);
    }

    private List<pro_Pro> findpro_ProEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(pro_Pro.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public pro_Pro findpro_Pro(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(pro_Pro.class, id);
        } finally {
            em.close();
        }
    }

    public int getpro_ProCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<pro_Pro> rt = cq.from(pro_Pro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
