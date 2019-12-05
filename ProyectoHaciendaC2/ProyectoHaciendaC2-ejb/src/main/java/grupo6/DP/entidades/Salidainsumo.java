/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Albert
 */
@Entity
@Table(name = "SALIDAINSUMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salidainsumo.findAll", query = "SELECT s FROM Salidainsumo s")
    , @NamedQuery(name = "Salidainsumo.findByIdsalidainsumo", query = "SELECT s FROM Salidainsumo s WHERE s.idsalidainsumo = :idsalidainsumo")
    , @NamedQuery(name = "Salidainsumo.findByCantidad", query = "SELECT s FROM Salidainsumo s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "Salidainsumo.findByFechasalida", query = "SELECT s FROM Salidainsumo s WHERE s.fechasalida = :fechasalida")})
public class Salidainsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSALIDAINSUMO")
    private Integer idsalidainsumo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHASALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasalida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsalidainsumo")
    private List<Cuidadoanimal> cuidadoanimalList;
    @JoinColumn(name = "IDCOMPRAINSUMO", referencedColumnName = "IDCOMPRAINSUMO")
    @ManyToOne(optional = false)
    private Entradainsumo idcomprainsumo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsalidainsumo")
    private List<Cuidadoplanta> cuidadoplantaList;

    public Salidainsumo() {
    }

    public Salidainsumo(Integer idsalidainsumo) {
        this.idsalidainsumo = idsalidainsumo;
    }

    public Salidainsumo(Integer idsalidainsumo, BigInteger cantidad, Date fechasalida) {
        this.idsalidainsumo = idsalidainsumo;
        this.cantidad = cantidad;
        this.fechasalida = fechasalida;
    }

    public Integer getIdsalidainsumo() {
        return idsalidainsumo;
    }

    public void setIdsalidainsumo(Integer idsalidainsumo) {
        this.idsalidainsumo = idsalidainsumo;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    @XmlTransient
    public List<Cuidadoanimal> getCuidadoanimalList() {
        return cuidadoanimalList;
    }

    public void setCuidadoanimalList(List<Cuidadoanimal> cuidadoanimalList) {
        this.cuidadoanimalList = cuidadoanimalList;
    }

    public Entradainsumo getIdcomprainsumo() {
        return idcomprainsumo;
    }

    public void setIdcomprainsumo(Entradainsumo idcomprainsumo) {
        this.idcomprainsumo = idcomprainsumo;
    }

    @XmlTransient
    public List<Cuidadoplanta> getCuidadoplantaList() {
        return cuidadoplantaList;
    }

    public void setCuidadoplantaList(List<Cuidadoplanta> cuidadoplantaList) {
        this.cuidadoplantaList = cuidadoplantaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsalidainsumo != null ? idsalidainsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salidainsumo)) {
            return false;
        }
        Salidainsumo other = (Salidainsumo) object;
        if ((this.idsalidainsumo == null && other.idsalidainsumo != null) || (this.idsalidainsumo != null && !this.idsalidainsumo.equals(other.idsalidainsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Salidainsumo[ idsalidainsumo=" + idsalidainsumo + " ]";
    }
    
}
