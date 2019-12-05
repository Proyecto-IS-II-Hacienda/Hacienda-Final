/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Albert
 */
@Embeddable
public class ProcesamientoplantaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROPROCESAMIENTO")
    private BigInteger numeroprocesamiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_PRODUCTO")
    private String codProducto;

    public ProcesamientoplantaPK() {
    }

    public ProcesamientoplantaPK(BigInteger numeroprocesamiento, Date fecha, String codProducto) {
        this.numeroprocesamiento = numeroprocesamiento;
        this.fecha = fecha;
        this.codProducto = codProducto;
    }

    public BigInteger getNumeroprocesamiento() {
        return numeroprocesamiento;
    }

    public void setNumeroprocesamiento(BigInteger numeroprocesamiento) {
        this.numeroprocesamiento = numeroprocesamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroprocesamiento != null ? numeroprocesamiento.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (codProducto != null ? codProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesamientoplantaPK)) {
            return false;
        }
        ProcesamientoplantaPK other = (ProcesamientoplantaPK) object;
        if ((this.numeroprocesamiento == null && other.numeroprocesamiento != null) || (this.numeroprocesamiento != null && !this.numeroprocesamiento.equals(other.numeroprocesamiento))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.codProducto == null && other.codProducto != null) || (this.codProducto != null && !this.codProducto.equals(other.codProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.ProcesamientoplantaPK[ numeroprocesamiento=" + numeroprocesamiento + ", fecha=" + fecha + ", codProducto=" + codProducto + " ]";
    }
    
}
