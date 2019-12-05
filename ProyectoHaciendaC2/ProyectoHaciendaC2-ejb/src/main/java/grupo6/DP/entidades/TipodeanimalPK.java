/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
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
public class TipodeanimalPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRECIENTIFICO")
    private String nombrecientifico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRECOMUN")
    private String nombrecomun;

    public TipodeanimalPK() {
    }

    public TipodeanimalPK(String nombrecientifico, String nombrecomun) {
        this.nombrecientifico = nombrecientifico;
        this.nombrecomun = nombrecomun;
    }

    public String getNombrecientifico() {
        return nombrecientifico;
    }

    public void setNombrecientifico(String nombrecientifico) {
        this.nombrecientifico = nombrecientifico;
    }

    public String getNombrecomun() {
        return nombrecomun;
    }

    public void setNombrecomun(String nombrecomun) {
        this.nombrecomun = nombrecomun;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombrecientifico != null ? nombrecientifico.hashCode() : 0);
        hash += (nombrecomun != null ? nombrecomun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipodeanimalPK)) {
            return false;
        }
        TipodeanimalPK other = (TipodeanimalPK) object;
        if ((this.nombrecientifico == null && other.nombrecientifico != null) || (this.nombrecientifico != null && !this.nombrecientifico.equals(other.nombrecientifico))) {
            return false;
        }
        if ((this.nombrecomun == null && other.nombrecomun != null) || (this.nombrecomun != null && !this.nombrecomun.equals(other.nombrecomun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.TipodeanimalPK[ nombrecientifico=" + nombrecientifico + ", nombrecomun=" + nombrecomun + " ]";
    }
    
}
