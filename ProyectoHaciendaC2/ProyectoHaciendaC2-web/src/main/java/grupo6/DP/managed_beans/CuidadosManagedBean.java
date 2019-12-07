/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.managed_beans;

import grupo6.DP.entidades.Animal;
import grupo6.DP.entidades.Area;
import grupo6.DP.entidades.Cuidadoanimal;
import grupo6.DP.entidades.Cuidadoplanta;
import grupo6.DP.entidades.Distribucionanimal;
import grupo6.DP.entidades.DistribucionanimalPK;
import grupo6.DP.entidades.Distribucionplanta;
import grupo6.DP.entidades.DistribucionplantaPK;
import grupo6.DP.entidades.Insumo;
import grupo6.DP.entidades.Planta;
import grupo6.DP.entidades.Salidainsumo;
import grupo6.MD.sesiones.AnimalFacadeLocal;
import grupo6.MD.sesiones.AreaFacadeLocal;
import grupo6.MD.sesiones.CuidadoanimalFacade;
import grupo6.MD.sesiones.CuidadoanimalFacadeLocal;
import grupo6.MD.sesiones.CuidadoplantaFacadeLocal;
import grupo6.MD.sesiones.DistribucionanimalFacadeLocal;
import grupo6.MD.sesiones.DistribucionplantaFacadeLocal;
import grupo6.MD.sesiones.InsumoFacadeLocal;
import grupo6.MD.sesiones.PlantaFacadeLocal;
import grupo6.MD.sesiones.SalidainsumoFacadeLocal;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Albert
 */
@Named(value = "cuidadoMB")
@ViewScoped
public class CuidadosManagedBean implements Serializable {

    private List<Animal> animalesList;
    private List<Cuidadoanimal> distribucionesAnimalesList;
    private List<Planta> plantasList;
    private List<Cuidadoplanta> distribucionesPlantasList;
    private List<Insumo> insumosList;
    private List<Salidainsumo> salidaInsumosList;

    @EJB
    private AnimalFacadeLocal animalesFacadeLocal;
    private Animal animal;
    @EJB
    private CuidadoanimalFacadeLocal cuidadoanimalFacadeLocal;
    private Cuidadoanimal cuidadoanimal;
    @EJB
    private PlantaFacadeLocal plantasFacadeLocal;
    private Planta planta;
    @EJB
    private CuidadoplantaFacadeLocal cuidadoplantaFacadeLocal;
    private Cuidadoplanta cuidadoplanta;

    @EJB
    private InsumoFacadeLocal ifl;

    @EJB
    private SalidainsumoFacadeLocal sifl;
    private boolean esNuevo;
    private boolean seleccion;

    public List<Animal> getAnimalesList() {
        return animalesList;
    }

    public void setAnimalesList(List<Animal> animalesList) {
        this.animalesList = animalesList;
    }

    public List<Cuidadoanimal> getDistribucionesAnimalesList() {
        return distribucionesAnimalesList;
    }

    public void setDistribucionesAnimalesList(List<Cuidadoanimal> distribucionesAnimalesList) {
        this.distribucionesAnimalesList = distribucionesAnimalesList;
    }

    public List<Planta> getPlantasList() {
        return plantasList;
    }

    public void setPlantasList(List<Planta> plantasList) {
        this.plantasList = plantasList;
    }

    public List<Cuidadoplanta> getDistribucionesPlantasList() {
        return distribucionesPlantasList;
    }

    public void setDistribucionesPlantasList(List<Cuidadoplanta> distribucionesPlantasList) {
        this.distribucionesPlantasList = distribucionesPlantasList;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Cuidadoanimal getCuidadoanimal() {
        return cuidadoanimal;
    }

    public void setCuidadoanimal(Cuidadoanimal cuidadoanimal) {
        this.cuidadoanimal = cuidadoanimal;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public Cuidadoplanta getCuidadoplanta() {
        return cuidadoplanta;
    }

    public void setCuidadoplanta(Cuidadoplanta cuidadoplanta) {
        this.cuidadoplanta = cuidadoplanta;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean Seleccion) {
        this.seleccion = Seleccion;
    }

    /**
     * Creates a new instance of AsignacionesManagedBean
     */
    public CuidadosManagedBean() {

    }

    public List<Insumo> getInsumosList() {
        return insumosList;
    }

    public void setInsumosList(List<Insumo> insumosList) {
        this.insumosList = insumosList;
    }

    @PostConstruct
    public void init() {
        cuidadoanimal = null;
        cuidadoplanta = null;
        animalesList = animalesFacadeLocal.findAll();
        plantasList = plantasFacadeLocal.findAll();
        distribucionesAnimalesList = cuidadoanimalFacadeLocal.findAll();
        distribucionesPlantasList = cuidadoplantaFacadeLocal.findAll();
        insumosList = ifl.findAll();
        salidaInsumosList = sifl.findAll();
        esNuevo = true;

    }

    public List<Salidainsumo> getSalidaInsumosList() {
        return salidaInsumosList;
    }

    public void setSalidaInsumosList(List<Salidainsumo> salidaInsumosList) {
        this.salidaInsumosList = salidaInsumosList;
    }

    public void nuevo() {
        if (seleccion) {
            cuidadoanimal = new Cuidadoanimal();
        } else {
            cuidadoplanta = new Cuidadoplanta();
        }
        esNuevo = true;
    }

    public void grabar() {
        if (esNuevo) {
            if (cuidadoanimal != null) {


                cuidadoanimal.setIdcuidado (cuidadoanimalFacadeLocal.findAll().isEmpty()? 0 :  cuidadoanimalFacadeLocal.findAll().get(cuidadoanimalFacadeLocal.findAll().size() - 1).getIdcuidado() + 1);
                cuidadoanimalFacadeLocal.create(cuidadoanimal);
            } else if (cuidadoplanta != null) {
                cuidadoplanta.setIdcuidado(cuidadoplantaFacadeLocal.findAll().isEmpty() ? 0 : cuidadoplantaFacadeLocal.findAll().get(cuidadoplantaFacadeLocal.findAll().size() - 1).getIdcuidado() + 1);
                cuidadoplantaFacadeLocal.create(cuidadoplanta);
            }
        } else {
            if (cuidadoanimal != null) {
                cuidadoanimalFacadeLocal.edit(cuidadoanimal);
            } else if (cuidadoplanta != null) {
                cuidadoplantaFacadeLocal.edit(cuidadoplanta);
            }
        }
        init();
    }

    public void eliminar(Object c) {
        if (c instanceof Cuidadoanimal) {
            cuidadoanimalFacadeLocal.remove((Cuidadoanimal) c);
        } else if (c instanceof Cuidadoplanta) {
            cuidadoplantaFacadeLocal.remove((Cuidadoplanta) c);
        }
    }

    public void cancelar() {
        init();
    }

    public void abrirBusquedaArea() {

        Map<String, Object> opciones = new HashMap<>();
        opciones.put("modal", true);
        opciones.put("contentWidth", 800);
        opciones.put("contentHeigth", 500);

        PrimeFaces.current().dialog().openDynamic("seleccion_area", opciones, null);
    }

    public void recibirDialogo(SelectEvent e) {
        if (e.getObject() instanceof Animal) {
            cuidadoanimal.setAnimal((Animal) e.getObject());
        } else if (e.getObject() instanceof Planta) {
            cuidadoplanta.setPlanta((Planta) e.getObject());
        }
    }

    public void abrirBusquedaAnimal() {
        Map<String, Object> opciones = new HashMap<>();
        opciones.put("modal", true);
        opciones.put("contentWidth", 800);
        opciones.put("contentHeigth", 500);
        PrimeFaces.current().dialog().openDynamic("seleccion_animal", opciones, null);
    }

    public void abrirBusquedaPlanta() {

        Map<String, Object> opciones = new HashMap<>();
        opciones.put("modal", true);
        opciones.put("contentWidth", 800);
        opciones.put("contentHeigth", 500);

        PrimeFaces.current().dialog().openDynamic("seleccion_planta", opciones, null);
    }

    public void seleccionar(Object c) {
        if (c instanceof Cuidadoanimal) {
            cuidadoanimal = cuidadoanimalFacadeLocal.find(((Cuidadoanimal) c).getIdcuidado());
        } else if (c instanceof Cuidadoplanta) {
            cuidadoplanta = cuidadoplantaFacadeLocal.find(((Cuidadoplanta) c).getIdcuidado());
        }
        esNuevo = false;
    }

}
