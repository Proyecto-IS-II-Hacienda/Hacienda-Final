/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Tipoarea;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Albert
 */
@Stateless
public class TipoareaFacade extends AbstractFacade<Tipoarea> implements TipoareaFacadeLocal {

    @PersistenceContext(unitName = "grupo6_ProyectoHaciendaC2-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoareaFacade() {
        super(Tipoarea.class);
    }
    
}
