/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Distribucionplanta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Albert
 */
@Local
public interface DistribucionplantaFacadeLocal {

    void create(Distribucionplanta distribucionplanta);

    void edit(Distribucionplanta distribucionplanta);

    void remove(Distribucionplanta distribucionplanta);

    Distribucionplanta find(Object id);

    List<Distribucionplanta> findAll();

    List<Distribucionplanta> findRange(int[] range);

    int count();
    
}
