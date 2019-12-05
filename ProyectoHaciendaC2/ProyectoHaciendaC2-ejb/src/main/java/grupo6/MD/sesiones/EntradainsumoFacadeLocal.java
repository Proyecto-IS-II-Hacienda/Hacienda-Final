/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Entradainsumo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface EntradainsumoFacadeLocal {

    void create(Entradainsumo entradainsumo);

    void edit(Entradainsumo entradainsumo);

    void remove(Entradainsumo entradainsumo);

    Entradainsumo find(Object id);

    List<Entradainsumo> findAll();

    List<Entradainsumo> findRange(int[] range);

    int count();
    
}
