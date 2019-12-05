/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Tipoadministracioninsumo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface TipoadministracioninsumoFacadeLocal {

    void create(Tipoadministracioninsumo tipoadministracioninsumo);

    void edit(Tipoadministracioninsumo tipoadministracioninsumo);

    void remove(Tipoadministracioninsumo tipoadministracioninsumo);

    Tipoadministracioninsumo find(Object id);

    List<Tipoadministracioninsumo> findAll();

    List<Tipoadministracioninsumo> findRange(int[] range);

    int count();
    
}
