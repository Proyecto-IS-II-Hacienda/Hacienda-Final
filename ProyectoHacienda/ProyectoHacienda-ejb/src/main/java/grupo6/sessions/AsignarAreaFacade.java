/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.sessions;

import grupo6.entities.AsignarArea;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marcelo_Echeverria
 */
@Stateless
public class AsignarAreaFacade extends AbstractFacade<AsignarArea> implements AsignarAreaFacadeLocal {

    @PersistenceContext(unitName = "grupo6_ProyectoHacienda-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignarAreaFacade() {
        super(AsignarArea.class);
    }
    
}
