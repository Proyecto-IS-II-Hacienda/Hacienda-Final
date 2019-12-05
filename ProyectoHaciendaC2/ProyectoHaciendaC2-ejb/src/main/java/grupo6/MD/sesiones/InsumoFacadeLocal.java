/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Insumo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface InsumoFacadeLocal {

    void create(Insumo insumo);

    void edit(Insumo insumo);

    void remove(Insumo insumo);

    Insumo find(Object id);

    List<Insumo> findAll();

    List<Insumo> findRange(int[] range);

    int count();
    
}
