/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Albert
 */
@Entity
@Table(name = "DISTRIBUCIONANIMAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distribucionanimal.findAll", query = "SELECT d FROM Distribucionanimal d")
    , @NamedQuery(name = "Distribucionanimal.findByNumeroarea", query = "SELECT d FROM Distribucionanimal d WHERE d.distribucionanimalPK.numeroarea = :numeroarea")
    , @NamedQuery(name = "Distribucionanimal.findByIdtipoarea", query = "SELECT d FROM Distribucionanimal d WHERE d.distribucionanimalPK.idtipoarea = :idtipoarea")
    , @NamedQuery(name = "Distribucionanimal.findByIdanimal", query = "SELECT d FROM Distribucionanimal d WHERE d.distribucionanimalPK.idanimal = :idanimal")
    , @NamedQuery(name = "Distribucionanimal.findByNombrecientifico", query = "SELECT d FROM Distribucionanimal d WHERE d.distribucionanimalPK.nombrecientifico = :nombrecientifico")
    , @NamedQuery(name = "Distribucionanimal.findByFechaasignacion", query = "SELECT d FROM Distribucionanimal d WHERE d.fechaasignacion = :fechaasignacion")
    , @NamedQuery(name = "Distribucionanimal.findByFechasalida", query = "SELECT d FROM Distribucionanimal d WHERE d.fechasalida = :fechasalida")})
public class Distribucionanimal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DistribucionanimalPK distribucionanimalPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAASIGNACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaasignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHASALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasalida;
    @Lob
    @Column(name = "DESCRIPCIONUSO")
    private String descripcionuso;
    @JoinColumns({
        @JoinColumn(name = "IDANIMAL", referencedColumnName = "IDANIMAL", insertable = false, updatable = false)
        , @JoinColumn(name = "NOMBRECIENTIFICO", referencedColumnName = "NOMBRECIENTIFICO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Animal animal;
    @JoinColumns({
        @JoinColumn(name = "NUMEROAREA", referencedColumnName = "NUMEROAREA", insertable = false, updatable = false)
        , @JoinColumn(name = "IDTIPOAREA", referencedColumnName = "IDTIPOAREA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Area area;

    public Distribucionanimal() {
    }

    public Distribucionanimal(DistribucionanimalPK distribucionanimalPK) {
        this.distribucionanimalPK = distribucionanimalPK;
    }

    public Distribucionanimal(DistribucionanimalPK distribucionanimalPK, Date fechaasignacion, Date fechasalida) {
        this.distribucionanimalPK = distribucionanimalPK;
        this.fechaasignacion = fechaasignacion;
        this.fechasalida = fechasalida;
    }

    public Distribucionanimal(BigInteger numeroarea, String idtipoarea, String idanimal, String nombrecientifico) {
        this.distribucionanimalPK = new DistribucionanimalPK(numeroarea, idtipoarea, idanimal, nombrecientifico);
    }

    public DistribucionanimalPK getDistribucionanimalPK() {
        return distribucionanimalPK;
    }

    public void setDistribucionanimalPK(DistribucionanimalPK distribucionanimalPK) {
        this.distribucionanimalPK = distribucionanimalPK;
    }

    public Date getFechaasignacion() {
        return fechaasignacion;
    }
  public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechaasignacion(Date fechaasignacion) {
        Date aux = this.fechaasignacion;
        this.fechaasignacion = fechaasignacion;
        
        if(validarFechas())
          this.fechaasignacion = aux;

    }

  
    public void setFechasalida(Date fechasalida) {
        Date aux = this.fechasalida;
        this.fechasalida = fechasalida;
        
        if(validarFechas())
          this.fechasalida = aux;
        

    }

    public String getDescripcionuso() {
        return descripcionuso;
    }

    public void setDescripcionuso(String descripcionuso) {
        this.descripcionuso = descripcionuso;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (distribucionanimalPK != null ? distribucionanimalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distribucionanimal)) {
            return false;
        }
        Distribucionanimal other = (Distribucionanimal) object;
        if ((this.distribucionanimalPK == null && other.distribucionanimalPK != null) || (this.distribucionanimalPK != null && !this.distribucionanimalPK.equals(other.distribucionanimalPK))) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Distribucionanimal[ distribucionanimalPK=" + distribucionanimalPK + " ]";
    }
    
    
            public boolean validarFechas()  {
            String salir=null;
        
        
            try {
                
                if (isMayorFechaHoy(this.fechaasignacion) || isMayorFechaHoy(this.fechasalida)) 
                    salir = "No se guardó la asignación, se pueden hacer asignaciones solamente para fechas superiores o actuales ";
                
                if (isMayor(this.fechaasignacion, this.fechasalida)) 
                    salir = "No se guardó la asignación, la fecha de asignación debe ser menor a la de salida";
                    
                if(salir!=null)
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", salir));
                
            } catch (Exception ex) {
                Logger.getLogger(Distribucionanimal.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        return salir!=null;
    }
        
        public Boolean isMayorFechaHoy(Date fecha) {
        Date hoy = new Date();
        Boolean resultado = false;

        if (fecha != null && fecha.before(hoy)) {
            resultado = true;
        }

        return resultado;
    }
        
        public Boolean isMayor(Date fechaInicial, Date fechaFinal) {
        Boolean resultado = false;
            if (fechaInicial.after(fechaFinal) || fechaInicial.equals(fechaFinal)) 
            resultado=true;
        
        return resultado;
        
    }
    
    
}
