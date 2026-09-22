package com.mycompany.practico_grupal_3_jpa;

import com.mycompany.practico_grupal_3_jpa.entities.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author italo
 */
public class Practico_Grupal_3_JPA {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FacturacionPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            
            /*
            consigna1(em);
            consigna2(em);
            consigna3(em);
            consigna4(em);
            consigna5(em);
            consigna6(em);
            consigna7(em);
            consigna8(em);
            consigna9(em);
            consigna10(em);
            
            consigna15(em);
            */
            
            consigna11(em);  
            em.getTransaction().commit();
        } 
        
        catch (NonUniqueResultException nure){
            nure.printStackTrace();
        }
        
        catch (NoResultException nre){
            nre.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            } 
            em.close();
            emf.close();
        }
    }
    
    private static void consigna1(EntityManager em){
        /*
        Consigna 1: Obtener la lista completa de todas las facturas de venta registradas en el
        sistema.
        */
        System.out.println("Consigna 1");
            
        String jpql1 = "SELECT fv FROM FacturaVenta fv";
        TypedQuery<FacturaVenta> query1 = em.createQuery(jpql1, FacturaVenta.class);
        List<FacturaVenta> fvs = query1.getResultList();
            
        for (FacturaVenta fv : fvs) {
            System.out.println("id facturaVenta: "+fv.getId());
        }
    }
    private static void consigna2(EntityManager em){
        /*
        Consigna 2: Seleccionar únicamente el número de factura, la fecha de emisión y el
        importe total de todas las facturas de venta.
        */
        System.out.println("Consigna 2");
            
        String jpql2 = "SELECT fv.numero,fv.fechaEmision,fv.importeTotal FROM FacturaVenta fv";
        TypedQuery<Object[]> query2 = em.createQuery(jpql2, Object[].class);
            
        List<Object[]> fvs2 = query2.getResultList();
            
        for (Object[] fv2 : fvs2) {
            Long numero = (Long) fv2[0];
            LocalDate fechaEmision = (LocalDate) fv2[1];
            double importeTotal = (double) fv2[2];
                
            System.out.println("Factura: numero:" + numero
            +", fechaEmision: "+ fechaEmision
            +", importeTotal: "+importeTotal);
        }
    }
    private static void consigna3(EntityManager em){
        /*
        Consigna 3: Obtener todos los artículos que pertenecen a un rubro con una
        denominación específica (ej. "Electrónica").
        */
            System.out.println("Consigna 3");
            
            String jpql3 = "SELECT a FROM Articulo a INNER JOIN a.rubro  r WHERE r.denominacion = :denominacion";
            TypedQuery<Articulo> query3 = em.createQuery(jpql3, Articulo.class);
            query3.setParameter("denominacion", "Entretenimiento");
            
            //Caso donde no traiga ningún Articulo:
            //query3.setParameter("denominacion", "Electrónica");
            
            
            List<Articulo> articulos3 = query3.getResultList();
            
            for (Articulo art : articulos3) {
                System.out.println("denominación rubro: "+art.getMarca().getDenominacion());
            }    
    }
    private static void consigna4(EntityManager em){
        /*
        Consigna 4: Listar todas las facturas de venta emitidas dentro de un rango de fechas
        determinado.
        */
            System.out.println("Consigna 4");
            
            String jpql4 = "SELECT fv FROM FacturaVenta fv WHERE fv.fechaEmision BETWEEN :rangoDesde AND :rangoHasta";
            TypedQuery<FacturaVenta> query4 = em.createQuery(jpql4, FacturaVenta.class);
            LocalDate fechaDesde = LocalDate.of(2026, 1, 1);
            LocalDate fechaHasta = LocalDate.of(2026, 12, 31);
            query4.setParameter("rangoDesde", fechaDesde);
            query4.setParameter("rangoHasta", fechaHasta);
            
            List<FacturaVenta> fvs4 = query4.getResultList();
            for (FacturaVenta fv : fvs4) {
                System.out.println("fechaEmision: "+fv.getFechaEmision());
            }
    }
    private static void consigna5(EntityManager em){
        /*
            Consigna 5: Obtener las facturas cuyo estado sea "EMITIDA", con un importe total
            superior a $10,000 y que no hayan sido anuladas (fechaAnulacion sea nula).
            */
            System.out.println("Consigna 5");
            
            String jpql5 = "SELECT fv FROM FacturaVenta fv WHERE fv.estado = :estado AND fv.importeTotal = :importeTotal AND fv.fechaAnulacion IS NULL";
            TypedQuery query5 = em.createQuery(jpql5, FacturaVenta.class);
            query5.setParameter("estado", "EMITIDA");
            query5.setParameter("importeTotal", 10000.0);
            
            List<FacturaVenta> fvs5 = query5.getResultList();
            
            for (FacturaVenta fv : fvs5) {
                System.out.println(fv.toString());
            }
    }
    private static void consigna6(EntityManager em){
        /*
            Consigna 6: Buscar todos los clientes cuya denominación contenga un texto parcial
            (sin importar mayúsculas/minúsculas) o cuyo CUIT/CUIL comience con "20-".
            */
            System.out.println("Consigna 6");
            
            String jpql6 = "SELECT c FROM Cliente c WHERE LOWER(c.denominacion) LIKE '%ar%' OR c.cuitCuil LIKE '20%'";
            TypedQuery query6 = em.createQuery(jpql6, Cliente.class);
            
            List<Cliente> cls6 = query6.getResultList();
            for (Cliente cl : cls6) {
                System.out.println("denominacion: "+cl.getDenominacion());
                System.out.println("cuit: "+cl.getCuitCuil());
            }
    }
    private static void consigna7(EntityManager em){
        /*
        Consigna 7: Obtener sin duplicados todos los estados posibles registrados en las
        facturas de venta, ordenados alfabéticamente de forma ascendente.
        */
        System.out.println("Consigna 7");
           
        String jpql7 = "SELECT DISTINCT fv.estado FROM FacturaVenta fv ORDER BY fv.estado ASC";
        TypedQuery query7 = em.createQuery(jpql7, Object.class);

        List<Object> estados7 = query7.getResultList();
        for (Object est : estados7) {
            System.out.println("nombre estado: "+est);
        }             
    }
    private static void consigna8(EntityManager em){
        /*
            Consigna 8: Obtener la cantidad total de facturas emitidas, la suma acumulada de
            sus importes totales y el importe promedio devuelto en un solo objeto/arreglo.
            */
            System.out.println("Consigna 8");
            
            String jpql8 = "SELECT COUNT(fv), SUM(fv.importeTotal), AVG(fv.importeTotal) FROM FacturaVenta fv ";
            TypedQuery query8 = em.createQuery(jpql8, Object[].class);
            List<Object[]> arreglo8 = query8.getResultList();
            
            for (Object[] fvarr : arreglo8) {
                Long cuantasFacturas = (Long) fvarr[0];
                double sumaImportesTotal = (double) fvarr[1];
                double promedioImportesTotal = (double) fvarr[2];
                
                System.out.println("cantidad de facturas:" + cuantasFacturas
                +", suma acumulada de importes totales: "+ sumaImportesTotal
                +", importe promedio: "+ promedioImportesTotal);
            }
    }
    private static void consigna9(EntityManager em){
        /*
        Consigna 9: Obtener todos los puntos de venta cuyo número coincida con una lista
        de enteros proporcionada por parámetro (ej. 1, 2, 5).
        */
        System.out.println("Consigna 9");
            
            
        List<Integer> numerosPermitidos = List.of(105, 200, 505);
            
        String jpql9 = "SELECT pv FROM PuntoVenta pv WHERE pv.numero IN :numerosPermitidos";

        List<PuntoVenta> puntosVenta = em.createQuery(jpql9, PuntoVenta.class)
        .setParameter("numerosPermitidos", numerosPermitidos)
        .getResultList();
            
        for(PuntoVenta pdv9 : puntosVenta){
            System.out.println("Numero punto de venta: "+pdv9.getNumero());
        }
    }
    private static void consigna10(EntityManager em){
        /*
        Consigna: Consultar todas las facturas de venta creadas por un usuario en
        particular navegando por su nombre de usuario de carga (usuarioCarga.usuario).
        */
        System.out.println("Consigna 10");
        
        String jpql10 = "SELECT fv FROM FacturaVenta fv WHERE "
            + "fv.usuarioCarga.usuario = :nombreUsuario";
        String nomUsuario = "mariosantana008";
        
        TypedQuery query10 = em.createQuery(jpql10, FacturaVenta.class);
        query10.setParameter("nombreUsuario", nomUsuario);
        List<FacturaVenta> facturas10 = query10.getResultList();
        
        System.out.println("Facturas cargadas por el usuario "+nomUsuario+":");
        for(FacturaVenta fv : facturas10){
            System.out.println(fv.toString());
        }
        
    }
    private static void consigna11(EntityManager em){
        /*
        Consigna 11: Obtener todos los detalles de factura (FacturaVentaDetalle) que
        correspondan a facturas emitidas por un punto de venta determinado.
        */
        System.out.println("Consigna 11");
        
        String jpql11 = "SELECT d FROM FacturaVentaDetalle d JOIN FETCH d.factura fv"
            + " WHERE fv.fechaEmision IS NOT NULL AND"
            + " fv.puntoVenta.numero = :numeroPuntoVenta";
        TypedQuery query11 = em.createQuery(jpql11, FacturaVentaDetalle.class);
        query11.setParameter("numeroPuntoVenta", 200);
        List<FacturaVentaDetalle> detalles = query11.getResultList();
        
        for (FacturaVentaDetalle detalle : detalles) {
            System.out.println("descripcion detalle: "+detalle.getDescripcion());
        }
    }
    private static void consigna12(EntityManager em){}
    private static void consigna13(EntityManager em){}
    private static void consigna14(EntityManager em){}
    private static void consigna15(EntityManager em){
        /*
        Consigna 15: Obtener la descripción del punto de venta, la cantidad de facturas
        emitidas por cada uno y la suma total facturada.
        */
        
        System.out.println("Consigna 15");
        String jpql15 = "SELECT fv.puntoVenta.descripcion, COUNT(fv), SUM(fv.importeTotal) FROM FacturaVenta fv"
        + " GROUP BY fv.puntoVenta.numero, fv.puntoVenta.descripcion";
            
        TypedQuery query15 = em.createQuery(jpql15, Object[].class);
        List<Object[]> arreglo15 = query15.getResultList();
            
        for (Object[] pdvarr : arreglo15)
        {
            String descripcion = (String) pdvarr[0];
            Long cuantasFacturas = (Long) pdvarr[1];
            double sumaTotalFacturada = (double) pdvarr[2];

            System.out.println("descripcion punto de venta:" + descripcion
            +", cantidad de facturas emitidas: "+ cuantasFacturas
            +", suma total facturada: "+ sumaTotalFacturada);
        }
    }
    private static void consigna16(EntityManager em){
        /*
        Consigna: Obtener los nombres de los usuarios de carga que hayan registrado más
        de 5 facturas de venta en el sistema
        */
        String jpql16 = "SELECT u.nombre,u.apellido FROM Usuario u"
                + " GROUP BY u.Id";
    
    }
    private static void consigna17(EntityManager em){
        /*
        Consigna: Obtener la denominación de cada marca, la cantidad total de unidades
        vendidas (SUM(cantidad)) y el subtotal acumulado, agrupado por marca.
        */   
    }
    private static void consigna18(EntityManager em){}
    private static void consigna19(EntityManager em){}
    private static void consigna20(EntityManager em){}
}
