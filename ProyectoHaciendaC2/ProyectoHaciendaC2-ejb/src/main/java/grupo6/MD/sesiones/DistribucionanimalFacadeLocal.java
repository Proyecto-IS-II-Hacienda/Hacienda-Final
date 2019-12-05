/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Distribucionanimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface DistribucionanimalFacadeLocal {

    void create(Distribucionanimal distribucionanimal);

    void edit(Distribucionanimal distribucionanimal);

    void remove(Distribucionanimal distribucionanimal);

    Distribucionanimal find(Object id);

    List<Distribucionanimal> findAll();

    List<Distribucionanimal> findRange(int[] range);

    int count();
    
}
