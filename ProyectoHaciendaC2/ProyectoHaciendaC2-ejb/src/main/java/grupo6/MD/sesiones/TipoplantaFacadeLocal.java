/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Tipoplanta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface TipoplantaFacadeLocal {

    void create(Tipoplanta tipoplanta);

    void edit(Tipoplanta tipoplanta);

    void remove(Tipoplanta tipoplanta);

    Tipoplanta find(Object id);

    List<Tipoplanta> findAll();

    List<Tipoplanta> findRange(int[] range);

    int count();
    
}
