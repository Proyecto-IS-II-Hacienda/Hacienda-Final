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
@Table(name = "ENTRADAINSUMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entradainsumo.findAll", query = "SELECT e FROM Entradainsumo e")
    , @NamedQuery(name = "Entradainsumo.findByIdcomprainsumo", query = "SELECT e FROM Entradainsumo e WHERE e.idcomprainsumo = :idcomprainsumo")
    , @NamedQuery(name = "Entradainsumo.findByFechacompra", query = "SELECT e FROM Entradainsumo e WHERE e.fechacompra = :fechacompra")
    , @NamedQuery(name = "Entradainsumo.findByCantidad", query = "SELECT e FROM Entradainsumo e WHERE e.cantidad = :cantidad")
    , @NamedQuery(name = "Entradainsumo.findByFechacaducidad", query = "SELECT e FROM Entradainsumo e WHERE e.fechacaducidad = :fechacaducidad")})
public class Entradainsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCOMPRAINSUMO")
    private Integer idcomprainsumo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACOMPRA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACADUCIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacaducidad;
    @JoinColumn(name = "CODINSUMO", referencedColumnName = "CODINSUMO")
    @ManyToOne(optional = false)
    private Insumo codinsumo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcomprainsumo")
    private List<Salidainsumo> salidainsumoList;

    public Entradainsumo() {
    }

    public Entradainsumo(Integer idcomprainsumo) {
        this.idcomprainsumo = idcomprainsumo;
    }

    public Entradainsumo(Integer idcomprainsumo, Date fechacompra, BigInteger cantidad, Date fechacaducidad) {
        this.idcomprainsumo = idcomprainsumo;
        this.fechacompra = fechacompra;
        this.cantidad = cantidad;
        this.fechacaducidad = fechacaducidad;
    }

    public Integer getIdcomprainsumo() {
        return idcomprainsumo;
    }

    public void setIdcomprainsumo(Integer idcomprainsumo) {
        this.idcomprainsumo = idcomprainsumo;
    }

    public Date getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(Date fechacompra) {
        this.fechacompra = fechacompra;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechacaducidad() {
        return fechacaducidad;
    }

    public void setFechacaducidad(Date fechacaducidad) {
        this.fechacaducidad = fechacaducidad;
    }

    public Insumo getCodinsumo() {
        return codinsumo;
    }

    public void setCodinsumo(Insumo codinsumo) {
        this.codinsumo = codinsumo;
    }

    @XmlTransient
    public List<Salidainsumo> getSalidainsumoList() {
        return salidainsumoList;
    }

    public void setSalidainsumoList(List<Salidainsumo> salidainsumoList) {
        this.salidainsumoList = salidainsumoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomprainsumo != null ? idcomprainsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entradainsumo)) {
            return false;
        }
        Entradainsumo other = (Entradainsumo) object;
        if ((this.idcomprainsumo == null && other.idcomprainsumo != null) || (this.idcomprainsumo != null && !this.idcomprainsumo.equals(other.idcomprainsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Entradainsumo[ idcomprainsumo=" + idcomprainsumo + " ]";
    }
    
}
