/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grupo6.DP.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Albert
 */
@Embeddable
public class AreaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROAREA")
    private BigInteger numeroarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "IDTIPOAREA")
    private String idtipoarea;

    public AreaPK() {
    }

    public AreaPK(BigInteger numeroarea, String idtipoarea) {
        this.numeroarea = numeroarea;
        this.idtipoarea = idtipoarea;
    }

    public BigInteger getNumeroarea() {
        return numeroarea;
    }

    public void setNumeroarea(BigInteger numeroarea) {
        this.numeroarea = numeroarea;
    }

    public String getIdtipoarea() {
        return idtipoarea;
    }

    public void setIdtipoarea(String idtipoarea) {
        this.idtipoarea = idtipoarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroarea != null ? numeroarea.hashCode() : 0);
        hash += (idtipoarea != null ? idtipoarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaPK)) {
            return false;
        }
        AreaPK other = (AreaPK) object;
        if ((this.numeroarea == null && other.numeroarea != null) || (this.numeroarea != null && !this.numeroarea.equals(other.numeroarea))) {
            return false;
        }
        if ((this.idtipoarea == null && other.idtipoarea != null) || (this.idtipoarea != null && !this.idtipoarea.equals(other.idtipoarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.AreaPK[ numeroarea=" + numeroarea + ", idtipoarea=" + idtipoarea + " ]";
    }

}
