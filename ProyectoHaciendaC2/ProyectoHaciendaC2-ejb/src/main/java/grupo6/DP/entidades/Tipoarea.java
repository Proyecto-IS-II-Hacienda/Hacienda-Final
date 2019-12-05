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
@Table(name = "TIPOAREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoarea.findAll", query = "SELECT t FROM Tipoarea t")
    , @NamedQuery(name = "Tipoarea.findByIdtipoarea", query = "SELECT t FROM Tipoarea t WHERE t.idtipoarea = :idtipoarea")
    , @NamedQuery(name = "Tipoarea.findByNombrearea", query = "SELECT t FROM Tipoarea t WHERE t.nombrearea = :nombrearea")})
public class Tipoarea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "IDTIPOAREA")
    private String idtipoarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBREAREA")
    private String nombrearea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoarea")
    private List<Area> areaList;

    public Tipoarea() {
    }

    public Tipoarea(String idtipoarea) {
        this.idtipoarea = idtipoarea;
    }

    public Tipoarea(String idtipoarea, String nombrearea) {
        this.idtipoarea = idtipoarea;
        this.nombrearea = nombrearea;
    }

    public String getIdtipoarea() {
        return idtipoarea;
    }

    public void setIdtipoarea(String idtipoarea) {
        this.idtipoarea = idtipoarea;
    }

    public String getNombrearea() {
        return nombrearea;
    }

    public void setNombrearea(String nombrearea) {
        this.nombrearea = nombrearea;
    }

    @XmlTransient
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoarea != null ? idtipoarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoarea)) {
            return false;
        }
        Tipoarea other = (Tipoarea) object;
        if ((this.idtipoarea == null && other.idtipoarea != null) || (this.idtipoarea != null && !this.idtipoarea.equals(other.idtipoarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Tipoarea[ idtipoarea=" + idtipoarea + " ]";
    }
    
}
