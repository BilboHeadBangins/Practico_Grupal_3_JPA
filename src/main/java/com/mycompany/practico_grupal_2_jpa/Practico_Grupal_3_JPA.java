package com.mycompany.practico_grupal_2_jpa;

import com.mycompany.practico_grupal_2_jpa.entities.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
            
            
            em.getTransaction().commit();
            
        } catch (Exception e) {
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
