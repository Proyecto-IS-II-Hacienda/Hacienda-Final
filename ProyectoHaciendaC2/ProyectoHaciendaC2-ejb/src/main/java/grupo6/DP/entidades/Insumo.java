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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "INSUMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumo.findAll", query = "SELECT i FROM Insumo i")
    , @NamedQuery(name = "Insumo.findByCodinsumo", query = "SELECT i FROM Insumo i WHERE i.codinsumo = :codinsumo")
    , @NamedQuery(name = "Insumo.findByNombre", query = "SELECT i FROM Insumo i WHERE i.nombre = :nombre")})
public class Insumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODINSUMO")
    private String codinsumo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "IDADMINS", referencedColumnName = "IDADMINS")
    @ManyToOne(optional = false)
    private Tipoadministracioninsumo idadmins;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codinsumo")
    private List<Entradainsumo> entradainsumoList;

    public Insumo() {
    }

    public Insumo(String codinsumo) {
        this.codinsumo = codinsumo;
    }

    public Insumo(String codinsumo, String nombre) {
        this.codinsumo = codinsumo;
        this.nombre = nombre;
    }

    public String getCodinsumo() {
        return codinsumo;
    }

    public void setCodinsumo(String codinsumo) {
        this.codinsumo = codinsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipoadministracioninsumo getIdadmins() {
        return idadmins;
    }

    public void setIdadmins(Tipoadministracioninsumo idadmins) {
        this.idadmins = idadmins;
    }

    @XmlTransient
    public List<Entradainsumo> getEntradainsumoList() {
        return entradainsumoList;
    }

    public void setEntradainsumoList(List<Entradainsumo> entradainsumoList) {
        this.entradainsumoList = entradainsumoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codinsumo != null ? codinsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumo)) {
            return false;
        }
        Insumo other = (Insumo) object;
        if ((this.codinsumo == null && other.codinsumo != null) || (this.codinsumo != null && !this.codinsumo.equals(other.codinsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Insumo[ codinsumo=" + codinsumo + " ]";
    }
    
}
