/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Albert
 */
@Entity
@Table(name = "CUIDADOPLANTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuidadoplanta.findAll", query = "SELECT c FROM Cuidadoplanta c")
    , @NamedQuery(name = "Cuidadoplanta.findByIdcuidado", query = "SELECT c FROM Cuidadoplanta c WHERE c.idcuidado = :idcuidado")})
public class Cuidadoplanta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCUIDADO")
    private Integer idcuidado;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DOCIFICACION")
    private String docificacion;
    @JoinColumns({
        @JoinColumn(name = "IDPLANTA", referencedColumnName = "IDPLANTA")
        , @JoinColumn(name = "NOMBRECIENTIFICO", referencedColumnName = "NOMBRECIENTIFICO")})
    @ManyToOne(optional = false)
    private Planta planta;
    @JoinColumn(name = "IDSALIDAINSUMO", referencedColumnName = "IDSALIDAINSUMO")
    @ManyToOne(optional = false)
    private Salidainsumo idsalidainsumo;

    public Cuidadoplanta() {
    }

    public Cuidadoplanta(Integer idcuidado) {
        this.idcuidado = idcuidado;
    }

    public Cuidadoplanta(Integer idcuidado, String docificacion) {
        this.idcuidado = idcuidado;
        this.docificacion = docificacion;
    }

    public Integer getIdcuidado() {
        return idcuidado;
    }

    public void setIdcuidado(Integer idcuidado) {
        this.idcuidado = idcuidado;
    }

    public String getDocificacion() {
        return docificacion;
    }

    public void setDocificacion(String docificacion) {
        this.docificacion = docificacion;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public Salidainsumo getIdsalidainsumo() {
        return idsalidainsumo;
    }

    public void setIdsalidainsumo(Salidainsumo idsalidainsumo) {
        this.idsalidainsumo = idsalidainsumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuidado != null ? idcuidado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuidadoplanta)) {
            return false;
        }
        Cuidadoplanta other = (Cuidadoplanta) object;
        if ((this.idcuidado == null && other.idcuidado != null) || (this.idcuidado != null && !this.idcuidado.equals(other.idcuidado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Cuidadoplanta[ idcuidado=" + idcuidado + " ]";
    }
    
}
