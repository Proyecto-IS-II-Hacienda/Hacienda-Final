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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TIPOADMINISTRACIONINSUMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoadministracioninsumo.findAll", query = "SELECT t FROM Tipoadministracioninsumo t")
    , @NamedQuery(name = "Tipoadministracioninsumo.findByIdadmins", query = "SELECT t FROM Tipoadministracioninsumo t WHERE t.idadmins = :idadmins")
    , @NamedQuery(name = "Tipoadministracioninsumo.findByNombre", query = "SELECT t FROM Tipoadministracioninsumo t WHERE t.nombre = :nombre")})
public class Tipoadministracioninsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDADMINS")
    private Integer idadmins;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idadmins")
    private List<Insumo> insumoList;

    public Tipoadministracioninsumo() {
    }

    public Tipoadministracioninsumo(Integer idadmins) {
        this.idadmins = idadmins;
    }

    public Tipoadministracioninsumo(Integer idadmins, String nombre) {
        this.idadmins = idadmins;
        this.nombre = nombre;
    }

    public Integer getIdadmins() {
        return idadmins;
    }

    public void setIdadmins(Integer idadmins) {
        this.idadmins = idadmins;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Insumo> getInsumoList() {
        return insumoList;
    }

    public void setInsumoList(List<Insumo> insumoList) {
        this.insumoList = insumoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadmins != null ? idadmins.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoadministracioninsumo)) {
            return false;
        }
        Tipoadministracioninsumo other = (Tipoadministracioninsumo) object;
        if ((this.idadmins == null && other.idadmins != null) || (this.idadmins != null && !this.idadmins.equals(other.idadmins))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Tipoadministracioninsumo[ idadmins=" + idadmins + " ]";
    }
    
}
