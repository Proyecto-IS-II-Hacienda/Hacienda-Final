/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Tipodeanimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface TipodeanimalFacadeLocal {

    void create(Tipodeanimal tipodeanimal);

    void edit(Tipodeanimal tipodeanimal);

    void remove(Tipodeanimal tipodeanimal);

    Tipodeanimal find(Object id);

    List<Tipodeanimal> findAll();

    List<Tipodeanimal> findRange(int[] range);

    int count();
    
}
