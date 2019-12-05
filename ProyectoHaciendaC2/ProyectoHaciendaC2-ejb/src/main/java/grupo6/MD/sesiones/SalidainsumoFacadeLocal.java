/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Salidainsumo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface SalidainsumoFacadeLocal {

    void create(Salidainsumo salidainsumo);

    void edit(Salidainsumo salidainsumo);

    void remove(Salidainsumo salidainsumo);

    Salidainsumo find(Object id);

    List<Salidainsumo> findAll();

    List<Salidainsumo> findRange(int[] range);

    int count();
    
}
