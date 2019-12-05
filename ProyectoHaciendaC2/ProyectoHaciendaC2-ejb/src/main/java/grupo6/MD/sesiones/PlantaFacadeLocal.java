/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Planta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface PlantaFacadeLocal {

    void create(Planta planta);

    void edit(Planta planta);

    void remove(Planta planta);

    Planta find(Object id);

    List<Planta> findAll();

    List<Planta> findRange(int[] range);

    int count();
    
}
