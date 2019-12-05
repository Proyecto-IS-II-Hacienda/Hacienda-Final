/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Procesamientoanimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface ProcesamientoanimalFacadeLocal {

    void create(Procesamientoanimal procesamientoanimal);

    void edit(Procesamientoanimal procesamientoanimal);

    void remove(Procesamientoanimal procesamientoanimal);

    Procesamientoanimal find(Object id);

    List<Procesamientoanimal> findAll();

    List<Procesamientoanimal> findRange(int[] range);

    int count();
    
}
