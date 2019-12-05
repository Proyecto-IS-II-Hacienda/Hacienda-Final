/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.managed_beans;

import grupo6.DP.entidades.Animal;
import grupo6.DP.entidades.Area;
import grupo6.DP.entidades.Distribucionanimal;
import grupo6.DP.entidades.DistribucionanimalPK;
import grupo6.DP.entidades.Distribucionplanta;
import grupo6.DP.entidades.DistribucionplantaPK;
import grupo6.DP.entidades.Planta;
import grupo6.MD.sesiones.AnimalFacadeLocal;
import grupo6.MD.sesiones.AreaFacadeLocal;
import grupo6.MD.sesiones.DistribucionanimalFacadeLocal;
import grupo6.MD.sesiones.DistribucionplantaFacadeLocal;
import grupo6.MD.sesiones.PlantaFacadeLocal;
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
@Named(value = "asignacionesManagedBean")
@ViewScoped
public class AsignacionesManagedBean implements Serializable {

    private List<Animal> animalesList;
    private List<Animal> animalesAsignarList;
    private List<Distribucionanimal> distribucionesAnimalesList;
    private List<Planta> plantasList;
    private List<Planta> plantasAsignarList;
    private List<Distribucionplanta> distribucionesPlantasList;
    private List<Area> areasList;
    private DistribucionanimalPK animalPK;
    private DistribucionplantaPK plantaPK;
    private String NombreArea;

    @EJB
    private AnimalFacadeLocal animalesFacadeLocal;
    private Animal animal;
    @EJB
    private DistribucionanimalFacadeLocal distribucionesAnimalesFacadeLocal;
    private Distribucionanimal distribucionAnimal;
    @EJB
    private PlantaFacadeLocal plantasFacadeLocal;
    private Planta planta;
    @EJB
    private DistribucionplantaFacadeLocal distribucionesPlantasFacadeLocal;
    private Distribucionplanta distribucionPlanta;
    private Area area;
    @EJB
    private AreaFacadeLocal areasFacadeLocal;
    private boolean esNuevo;
    private boolean Seleccion;

    public List<Animal> getAnimalesList() {
        return animalesList;
    }

    public void setAnimalesList(List<Animal> animalesList) {
        this.animalesList = animalesList;
    }

    public List<Distribucionanimal> getDistribucionesAnimalesList() {
        return distribucionesAnimalesList;
    }

    public void setDistribucionesAnimalesList(List<Distribucionanimal> distribucionesAnimalesList) {
        this.distribucionesAnimalesList = distribucionesAnimalesList;
    }

    public List<Planta> getPlantasList() {
        return plantasList;
    }

    public void setPlantasList(List<Planta> plantasList) {
        this.plantasList = plantasList;
    }

    public List<Distribucionplanta> getDistribucionesPlantasList() {
        return distribucionesPlantasList;
    }

    public void setDistribucionesPlantasList(List<Distribucionplanta> distribucionesPlantasList) {
        this.distribucionesPlantasList = distribucionesPlantasList;
    }

    public List<Area> getAreasList() {
        return areasList;
    }

    public void setAreasList(List<Area> areasList) {
        this.areasList = areasList;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Distribucionanimal getDistribucionAnimal() {
        return distribucionAnimal;
    }

    public void setDistribucionAnimal(Distribucionanimal distribucionAnimal) {
        this.distribucionAnimal = distribucionAnimal;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public Distribucionplanta getDistribucionPlanta() {
        return distribucionPlanta;
    }

    public void setDistribucionPlanta(Distribucionplanta distribucionPlanta) {
        this.distribucionPlanta = distribucionPlanta;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public DistribucionanimalPK getAnimalPK() {
        return animalPK;
    }

    public void setAnimalPK(DistribucionanimalPK animalPK) {
        this.animalPK = animalPK;
    }

    public List<Animal> getAnimalesAsignarList() {
        return animalesAsignarList;
    }

    public void setAnimalesAsignarList(List<Animal> animalesAsignarList) {
        this.animalesAsignarList = animalesAsignarList;
    }

    public List<Planta> getPlantasAsignarList() {
        return plantasAsignarList;
    }

    public void setPlantasAsignarList(List<Planta> plantasAsignarList) {
        this.plantasAsignarList = plantasAsignarList;
    }

    public DistribucionplantaPK getPlantaPK() {
        return plantaPK;
    }

    public void setPlantaPK(DistribucionplantaPK plantaPK) {
        this.plantaPK = plantaPK;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public boolean isSeleccion() {
        return Seleccion;
    }

    public void setSeleccion(boolean Seleccion) {
        this.Seleccion = Seleccion;
    }

    /**
     * Creates a new instance of AsignacionesManagedBean
     */
    public AsignacionesManagedBean() {

    }

    @PostConstruct
    public void init() {
        animalesList = null;
        animalesAsignarList = null;
        animalesList = animalesFacadeLocal.findAll();
        plantasList = null;
        plantasAsignarList = null;
        plantasList = plantasFacadeLocal.findAll();
        distribucionesAnimalesList = null;
        distribucionesAnimalesList = distribucionesAnimalesFacadeLocal.findAll();
        distribucionesPlantasList = null;
        distribucionesPlantasList = distribucionesPlantasFacadeLocal.findAll();
        areasList = null;
        areasList = areasFacadeLocal.findAll();
        esNuevo = true;
        //NombreArea=areasFacadeLocal.find(this).getTipoarea().getNombrearea();
        distribucionAnimal = null;
        distribucionPlanta = null;
    }

    public String getNombreArea() {
        return NombreArea;
    }

    public void setNombreArea(String NombreArea) {
        this.NombreArea = NombreArea;
    }

    public void nuevo() {
        if (Seleccion) {
            distribucionAnimal = new Distribucionanimal();
            animalPK = new DistribucionanimalPK();
        } else {
            distribucionPlanta = new Distribucionplanta();
            plantaPK = new DistribucionplantaPK();
        }
        esNuevo = true;
    }

    public void grabar() {
        try {
            if (esNuevo) {
                if (distribucionAnimal != null) {

                    distribucionesAnimalesFacadeLocal.create(distribucionAnimal);
                } else {
                    distribucionesPlantasFacadeLocal.create(distribucionPlanta);
                }

            } else {
                if (distribucionAnimal != null) {
                    distribucionesAnimalesFacadeLocal.edit(distribucionAnimal);
                } else if (distribucionPlanta != null) {
                    distribucionesPlantasFacadeLocal.edit(distribucionPlanta);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            init();
        }
    }

    public void eliminar(Distribucionanimal distribucion) {
        try {
            distribucionesAnimalesFacadeLocal.remove(distribucion);
            init();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelar() {
        if (distribucionAnimal != null) {
            distribucionAnimal = null;
        } else {
            distribucionPlanta = null;
        }
    }

    public void abrirBusquedaArea() {

        Map<String, Object> opciones = new HashMap<>();
        opciones.put("modal", true);
        opciones.put("contentWidth", 800);
        opciones.put("contentHeigth", 500);

        PrimeFaces.current().dialog().openDynamic("seleccion_area", opciones, null);
    }

    public void recibirArea(SelectEvent e) {
        if (distribucionAnimal != null) {
            distribucionAnimal.setArea((Area) e.getObject());
        } else {
            distribucionPlanta.setArea((Area) e.getObject());
        }
    }

    public void abrirBusquedaAnimal() {

        Map<String, Object> opciones = new HashMap<>();
        opciones.put("modal", true);
        opciones.put("contentWidth", 800);
        opciones.put("contentHeigth", 500);

        PrimeFaces.current().dialog().openDynamic("seleccion_animal", opciones, null);
    }

    public void recibirAnimales(SelectEvent e) {
        distribucionAnimal.setAnimal((Animal) e.getObject());

    }

    public void abrirBusquedaPlanta() {

        Map<String, Object> opciones = new HashMap<>();
        opciones.put("modal", true);
        opciones.put("contentWidth", 800);
        opciones.put("contentHeigth", 500);

        PrimeFaces.current().dialog().openDynamic("seleccion_planta", opciones, null);
    }

    public void recibirPlanta(SelectEvent e) {
        distribucionPlanta.setPlanta((Planta) e.getObject());
    }

    public void seleccionar(Object asig) {
        if (asig instanceof Distribucionanimal) {
            Distribucionanimal aux = (Distribucionanimal) asig;
            distribucionAnimal = distribucionesAnimalesFacadeLocal.find(new DistribucionanimalPK(aux.getDistribucionanimalPK().getNumeroarea(),
                    aux.getDistribucionanimalPK().getIdtipoarea(),
                    aux.getDistribucionanimalPK().getIdanimal(),
                    aux.getDistribucionanimalPK().getNombrecientifico()));

        } else if (asig instanceof Distribucionplanta) {
            Distribucionplanta asigP = (Distribucionplanta) asig;
            distribucionPlanta = distribucionesPlantasFacadeLocal.find(new DistribucionplantaPK(asigP.getDistribucionplantaPK().getNumeroarea(),
                    asigP.getDistribucionplantaPK().getIdtipoarea(),
                    asigP.getPlanta().getPlantaPK().getIdplanta(),
                    asigP.getPlanta().getPlantaPK().getNombrecientifico()));
        }
     esNuevo = false;
    }

}
