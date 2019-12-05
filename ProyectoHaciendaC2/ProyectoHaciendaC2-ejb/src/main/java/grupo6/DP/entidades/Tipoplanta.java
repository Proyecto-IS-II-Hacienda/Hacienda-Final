/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Albert
 */
@Entity
@Table(name = "TIPOPLANTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoplanta.findAll", query = "SELECT t FROM Tipoplanta t")
    , @NamedQuery(name = "Tipoplanta.findByNombrecientifico", query = "SELECT t FROM Tipoplanta t WHERE t.tipoplantaPK.nombrecientifico = :nombrecientifico")
    , @NamedQuery(name = "Tipoplanta.findByNombrecomun", query = "SELECT t FROM Tipoplanta t WHERE t.tipoplantaPK.nombrecomun = :nombrecomun")
    , @NamedQuery(name = "Tipoplanta.findByDiasparacosecha", query = "SELECT t FROM Tipoplanta t WHERE t.diasparacosecha = :diasparacosecha")})
public class Tipoplanta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoplantaPK tipoplantaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIASPARACOSECHA")
    private BigInteger diasparacosecha;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoplanta")
    private List<Planta> plantaList;

    public Tipoplanta() {
    }

    public Tipoplanta(TipoplantaPK tipoplantaPK) {
        this.tipoplantaPK = tipoplantaPK;
    }

    public Tipoplanta(TipoplantaPK tipoplantaPK, BigInteger diasparacosecha, String descripcion) {
        this.tipoplantaPK = tipoplantaPK;
        this.diasparacosecha = diasparacosecha;
        this.descripcion = descripcion;
    }

    public Tipoplanta(String nombrecientifico, String nombrecomun) {
        this.tipoplantaPK = new TipoplantaPK(nombrecientifico, nombrecomun);
    }

    public TipoplantaPK getTipoplantaPK() {
        return tipoplantaPK;
    }

    public void setTipoplantaPK(TipoplantaPK tipoplantaPK) {
        this.tipoplantaPK = tipoplantaPK;
    }

    public BigInteger getDiasparacosecha() {
        return diasparacosecha;
    }

    public void setDiasparacosecha(BigInteger diasparacosecha) {
        this.diasparacosecha = diasparacosecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Planta> getPlantaList() {
        return plantaList;
    }

    public void setPlantaList(List<Planta> plantaList) {
        this.plantaList = plantaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoplantaPK != null ? tipoplantaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoplanta)) {
            return false;
        }
        Tipoplanta other = (Tipoplanta) object;
        if ((this.tipoplantaPK == null && other.tipoplantaPK != null) || (this.tipoplantaPK != null && !this.tipoplantaPK.equals(other.tipoplantaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Tipoplanta[ tipoplantaPK=" + tipoplantaPK + " ]";
    }
    
}
