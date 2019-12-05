/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Procesamientoplanta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface ProcesamientoplantaFacadeLocal {

    void create(Procesamientoplanta procesamientoplanta);

    void edit(Procesamientoplanta procesamientoplanta);

    void remove(Procesamientoplanta procesamientoplanta);

    Procesamientoplanta find(Object id);

    List<Procesamientoplanta> findAll();

    List<Procesamientoplanta> findRange(int[] range);

    int count();
    
}
