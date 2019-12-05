/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Salidaproducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface SalidaproductoFacadeLocal {

    void create(Salidaproducto salidaproducto);

    void edit(Salidaproducto salidaproducto);

    void remove(Salidaproducto salidaproducto);

    Salidaproducto find(Object id);

    List<Salidaproducto> findAll();

    List<Salidaproducto> findRange(int[] range);

    int count();
    
}
