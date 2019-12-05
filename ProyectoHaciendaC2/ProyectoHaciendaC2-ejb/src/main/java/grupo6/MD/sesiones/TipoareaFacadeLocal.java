/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Tipoarea;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface TipoareaFacadeLocal {

    void create(Tipoarea tipoarea);

    void edit(Tipoarea tipoarea);

    void remove(Tipoarea tipoarea);

    Tipoarea find(Object id);

    List<Tipoarea> findAll();

    List<Tipoarea> findRange(int[] range);

    int count();
    
}
