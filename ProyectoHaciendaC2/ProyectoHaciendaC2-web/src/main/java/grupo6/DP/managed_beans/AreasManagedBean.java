/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.managed_beans;

import grupo6.DP.entidades.Area;
import grupo6.MD.sesiones.AreaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Albert
 */
@Named(value = "areasManagedBean")
@ViewScoped
public class AreasManagedBean implements Serializable{
    @EJB
    private AreaFacadeLocal areaFacadeLocal;
    private List<Area> areasList;

    /**
     * Creates a new instance of AreasManagedBean
     */
    public AreasManagedBean() {
    }
    
     @PostConstruct
    public void init(){
        areasList=areaFacadeLocal.findAll();
    }

    public List<Area> getAreasList() {
        return areasList;
    }

    public void setAreasList(List<Area> areasList) {
        this.areasList = areasList;
    }
    

     public void seleccionar(Area area){
        PrimeFaces.current().dialog().closeDynamic(area);
    }
    
}
