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
public class DistribucionanimalPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROAREA")
    private BigInteger numeroarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "IDTIPOAREA")
    private String idtipoarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDANIMAL")
    private String idanimal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRECIENTIFICO")
    private String nombrecientifico;

    public DistribucionanimalPK() {
    }

    public DistribucionanimalPK(BigInteger numeroarea, String idtipoarea, String idanimal, String nombrecientifico) {
        this.numeroarea = numeroarea;
        this.idtipoarea = idtipoarea;
        this.idanimal = idanimal;
        this.nombrecientifico = nombrecientifico;
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

    public String getIdanimal() {
        return idanimal;
    }

    public void setIdanimal(String idanimal) {
        this.idanimal = idanimal;
    }

    public String getNombrecientifico() {
        return nombrecientifico;
    }

    public void setNombrecientifico(String nombrecientifico) {
        this.nombrecientifico = nombrecientifico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroarea != null ? numeroarea.hashCode() : 0);
        hash += (idtipoarea != null ? idtipoarea.hashCode() : 0);
        hash += (idanimal != null ? idanimal.hashCode() : 0);
        hash += (nombrecientifico != null ? nombrecientifico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DistribucionanimalPK)) {
            return false;
        }
        DistribucionanimalPK other = (DistribucionanimalPK) object;
        return !((this.numeroarea == null && other.numeroarea != null) || (this.numeroarea != null && !this.numeroarea.equals(other.numeroarea))||(this.idtipoarea == null && other.idtipoarea != null) || (this.idtipoarea != null && !this.idtipoarea.equals(other.idtipoarea))||(this.idanimal == null && other.idanimal != null) || (this.idanimal != null && !this.idanimal.equals(other.idanimal))||(this.nombrecientifico == null && other.nombrecientifico != null) || (this.nombrecientifico != null && !this.nombrecientifico.equals(other.nombrecientifico)));
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.DistribucionanimalPK[ numeroarea=" + numeroarea + ", idtipoarea=" + idtipoarea + ", idanimal=" + idanimal + ", nombrecientifico=" + nombrecientifico + " ]";
    }
    
}
