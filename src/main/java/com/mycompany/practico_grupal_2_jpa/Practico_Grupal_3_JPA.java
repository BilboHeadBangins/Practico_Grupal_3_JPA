package com.mycompany.practico_grupal_2_jpa;

import com.mycompany.practico_grupal_2_jpa.entities.*;
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
            Consigna 1: Obtener la lista completa de todas las facturas de venta registradas en el
            sistema.
            */
            
            String jpql1 = "SELECT fv FROM FacturaVenta fv";
            TypedQuery<FacturaVenta> query1 = em.createQuery(jpql1, FacturaVenta.class);
            List<FacturaVenta> fvs = query1.getResultList();
            
            for (FacturaVenta fv : fvs) {
                System.out.println(fv.toString());
            }
            
            /*
            Consigna 2: Seleccionar únicamente el número de factura, la fecha de emisión y el
            importe total de todas las facturas de venta.
            */
            
            String jpql2 = "SELECT fv.numero,fv.fechaEmision,fv.importeTotal FROM FacturaVenta fv";
            TypedQuery<Object[]> query2 = em.createQuery(jpql2, Object[].class);
            
            List<Object[]> fvs2 = query2.getResultList();
            
            for (Object[] fv2 : fvs2) {
                Long numero = (Long) fv2[0];
                LocalDate fechaEmision = (LocalDate) fv2[1];
                double importeTotal = (double) fv2[2];
                
                System.out.println("Factura: numero:" + numero + ", fechaEmision: " + fechaEmision +", importeTotal: "+importeTotal);
            }
            
            /*
            Consigna 3: Obtener todos los artículos que pertenecen a un rubro con una
            denominación específica (ej. "Electrónica").
            */
            
            String jpql3 = "SELECT a FROM Articulo a INNER JOIN a.rubro  r WHERE r.denominacion = :denominacion";
            TypedQuery<Articulo> query3 = em.createQuery(jpql3, Articulo.class);
            query3.setParameter("denominacion", "Entretenimiento");
            
            //Caso donde no traiga ningún Articulo:
            //query3.setParameter("denominacion", "Electrónica");
            
            
            List<Articulo> articulos3 = query3.getResultList();
            
            for (Articulo art : articulos3) {
                System.out.println("denominación rubro: "+art.getMarca().getDenominacion());
            }
            
            /*
            Consigna 4: Listar todas las facturas de venta emitidas dentro de un rango de fechas
            determinado.
            */
            
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
            
            /*
            Consigna 5: Obtener las facturas cuyo estado sea "EMITIDA", con un importe total
            superior a $10,000 y que no hayan sido anuladas (fechaAnulacion sea nula).
            */
            
            String jpql5 = "SELECT fv FROM FacturaVenta fv WHERE fv.estado = :estado";
            
            em.getTransaction().commit();  
        } 
        
        catch (NonUniqueResultException nure){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            } 
            nure.printStackTrace();
        }
        
        catch (NoResultException nre){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            } 
            nre.printStackTrace();
        }
        catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            } 
            e.printStackTrace();
        } finally {
            
            em.close();
            emf.close();
        }
    }
}
