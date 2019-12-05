/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Cuidadoanimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface CuidadoanimalFacadeLocal {

    void create(Cuidadoanimal cuidadoanimal);

    void edit(Cuidadoanimal cuidadoanimal);

    void remove(Cuidadoanimal cuidadoanimal);

    Cuidadoanimal find(Object id);

    List<Cuidadoanimal> findAll();

    List<Cuidadoanimal> findRange(int[] range);

    int count();
    
}
