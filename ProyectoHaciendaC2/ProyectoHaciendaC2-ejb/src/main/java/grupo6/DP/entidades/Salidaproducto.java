/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Albert
 */
@Entity
@Table(name = "SALIDAPRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salidaproducto.findAll", query = "SELECT s FROM Salidaproducto s")
    , @NamedQuery(name = "Salidaproducto.findByIdsalidaproducto", query = "SELECT s FROM Salidaproducto s WHERE s.idsalidaproducto = :idsalidaproducto")
    , @NamedQuery(name = "Salidaproducto.findByCantidad", query = "SELECT s FROM Salidaproducto s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "Salidaproducto.findByFechasalida", query = "SELECT s FROM Salidaproducto s WHERE s.fechasalida = :fechasalida")
    , @NamedQuery(name = "Salidaproducto.findByUnidades", query = "SELECT s FROM Salidaproducto s WHERE s.unidades = :unidades")})
public class Salidaproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSALIDAPRODUCTO")
    private Integer idsalidaproducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHASALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasalida;
    @Size(max = 5)
    @Column(name = "UNIDADES")
    private String unidades;
    @JoinColumns({
        @JoinColumn(name = "NUMEROPROCESAMIENTO", referencedColumnName = "NUMEROPROCESAMIENTO")
        , @JoinColumn(name = "FECHA", referencedColumnName = "FECHA")
        , @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")})
    @ManyToOne(optional = false)
    private Procesamientoanimal procesamientoanimal;

    public Salidaproducto() {
    }

    public Salidaproducto(Integer idsalidaproducto) {
        this.idsalidaproducto = idsalidaproducto;
    }

    public Salidaproducto(Integer idsalidaproducto, double cantidad, Date fechasalida) {
        this.idsalidaproducto = idsalidaproducto;
        this.cantidad = cantidad;
        this.fechasalida = fechasalida;
    }

    public Integer getIdsalidaproducto() {
        return idsalidaproducto;
    }

    public void setIdsalidaproducto(Integer idsalidaproducto) {
        this.idsalidaproducto = idsalidaproducto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public Procesamientoanimal getProcesamientoanimal() {
        return procesamientoanimal;
    }

    public void setProcesamientoanimal(Procesamientoanimal procesamientoanimal) {
        this.procesamientoanimal = procesamientoanimal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsalidaproducto != null ? idsalidaproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salidaproducto)) {
            return false;
        }
        Salidaproducto other = (Salidaproducto) object;
        if ((this.idsalidaproducto == null && other.idsalidaproducto != null) || (this.idsalidaproducto != null && !this.idsalidaproducto.equals(other.idsalidaproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Salidaproducto[ idsalidaproducto=" + idsalidaproducto + " ]";
    }
    
}
