/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Albert
 */
@Entity
@Table(name = "TIPODEANIMAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodeanimal.findAll", query = "SELECT t FROM Tipodeanimal t")
    , @NamedQuery(name = "Tipodeanimal.findByNombrecientifico", query = "SELECT t FROM Tipodeanimal t WHERE t.tipodeanimalPK.nombrecientifico = :nombrecientifico")
    , @NamedQuery(name = "Tipodeanimal.findByNombrecomun", query = "SELECT t FROM Tipodeanimal t WHERE t.tipodeanimalPK.nombrecomun = :nombrecomun")
    , @NamedQuery(name = "Tipodeanimal.findByRaza", query = "SELECT t FROM Tipodeanimal t WHERE t.raza = :raza")})
public class Tipodeanimal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipodeanimalPK tipodeanimalPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RAZA")
    private String raza;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipodeanimal")
    private List<Animal> animalList;

    public Tipodeanimal() {
    }

    public Tipodeanimal(TipodeanimalPK tipodeanimalPK) {
        this.tipodeanimalPK = tipodeanimalPK;
    }

    public Tipodeanimal(TipodeanimalPK tipodeanimalPK, String raza, String descripcion) {
        this.tipodeanimalPK = tipodeanimalPK;
        this.raza = raza;
        this.descripcion = descripcion;
    }

    public Tipodeanimal(String nombrecientifico, String nombrecomun) {
        this.tipodeanimalPK = new TipodeanimalPK(nombrecientifico, nombrecomun);
    }

    public TipodeanimalPK getTipodeanimalPK() {
        return tipodeanimalPK;
    }

    public void setTipodeanimalPK(TipodeanimalPK tipodeanimalPK) {
        this.tipodeanimalPK = tipodeanimalPK;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipodeanimalPK != null ? tipodeanimalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodeanimal)) {
            return false;
        }
        Tipodeanimal other = (Tipodeanimal) object;
        if ((this.tipodeanimalPK == null && other.tipodeanimalPK != null) || (this.tipodeanimalPK != null && !this.tipodeanimalPK.equals(other.tipodeanimalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Tipodeanimal[ tipodeanimalPK=" + tipodeanimalPK + " ]";
    }
    
}
