/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.managed_beans;

import grupo6.DP.entidades.Planta;
import grupo6.MD.sesiones.PlantaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
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
@Named(value = "plantasManagedBean")
@ViewScoped
public class PlantasManagedBean implements Serializable {
    @EJB
    private PlantaFacadeLocal plantaFacadeLocal;
    private List <Planta> plantasList;
    Planta plantasAsignar;
    private boolean seleccionado;

    /**
     * Creates a new instance of PlantasManagedBean
     */
    public PlantasManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        seleccionado=false;
        plantasList=plantaFacadeLocal.findAll();
        plantasAsignar=new Planta();
    }

    
    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    

    public List<Planta> getPlantasList() {
        return plantasList;
    }

    public void setPlantasList(List<Planta> plantasList) {
        this.plantasList = plantasList;
    }
    
    public void seleccionar(Planta planta){
        plantasAsignar = planta;
        agregar();
    }
    
     public void agregar (){
        PrimeFaces.current().dialog().closeDynamic(plantasAsignar);
    }
}
