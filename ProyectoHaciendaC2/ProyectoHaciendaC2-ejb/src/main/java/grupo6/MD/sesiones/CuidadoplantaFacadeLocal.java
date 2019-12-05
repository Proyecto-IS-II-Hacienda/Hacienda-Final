/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Cuidadoplanta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface CuidadoplantaFacadeLocal {

    void create(Cuidadoplanta cuidadoplanta);

    void edit(Cuidadoplanta cuidadoplanta);

    void remove(Cuidadoplanta cuidadoplanta);

    Cuidadoplanta find(Object id);

    List<Cuidadoplanta> findAll();

    List<Cuidadoplanta> findRange(int[] range);

    int count();
    
}
