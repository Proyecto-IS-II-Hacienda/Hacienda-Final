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
public class AnimalPK implements Serializable {

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

    public AnimalPK() {
    }

    public AnimalPK(String idanimal, String nombrecientifico) {
        this.idanimal = idanimal;
        this.nombrecientifico = nombrecientifico;
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
        hash += (idanimal != null ? idanimal.hashCode() : 0);
        hash += (nombrecientifico != null ? nombrecientifico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnimalPK)) {
            return false;
        }
        AnimalPK other = (AnimalPK) object;
        if ((this.idanimal == null && other.idanimal != null) || (this.idanimal != null && !this.idanimal.equals(other.idanimal))) {
            return false;
        }
        return !((this.nombrecientifico == null && other.nombrecientifico != null) || (this.nombrecientifico != null && !this.nombrecientifico.equals(other.nombrecientifico)));
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.AnimalPK[ idanimal=" + idanimal + ", nombrecientifico=" + nombrecientifico + " ]";
    }
    
}
