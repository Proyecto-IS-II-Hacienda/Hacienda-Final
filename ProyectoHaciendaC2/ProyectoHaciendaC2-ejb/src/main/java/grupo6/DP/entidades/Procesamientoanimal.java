/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Albert
 */
@Entity
@Table(name = "PROCESAMIENTOANIMAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procesamientoanimal.findAll", query = "SELECT p FROM Procesamientoanimal p")
    , @NamedQuery(name = "Procesamientoanimal.findByNumeroprocesamiento", query = "SELECT p FROM Procesamientoanimal p WHERE p.procesamientoanimalPK.numeroprocesamiento = :numeroprocesamiento")
    , @NamedQuery(name = "Procesamientoanimal.findByFecha", query = "SELECT p FROM Procesamientoanimal p WHERE p.procesamientoanimalPK.fecha = :fecha")
    , @NamedQuery(name = "Procesamientoanimal.findByCodProducto", query = "SELECT p FROM Procesamientoanimal p WHERE p.procesamientoanimalPK.codProducto = :codProducto")
    , @NamedQuery(name = "Procesamientoanimal.findByMortal", query = "SELECT p FROM Procesamientoanimal p WHERE p.mortal = :mortal")
    , @NamedQuery(name = "Procesamientoanimal.findByFechacaducidad", query = "SELECT p FROM Procesamientoanimal p WHERE p.fechacaducidad = :fechacaducidad")
    , @NamedQuery(name = "Procesamientoanimal.findByCantidad", query = "SELECT p FROM Procesamientoanimal p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Procesamientoanimal.findByUnidades", query = "SELECT p FROM Procesamientoanimal p WHERE p.unidades = :unidades")})
public class Procesamientoanimal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesamientoanimalPK procesamientoanimalPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MORTAL")
    private BigInteger mortal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACADUCIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacaducidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "UNIDADES")
    private String unidades;
    @JoinColumns({
        @JoinColumn(name = "IDANIMAL", referencedColumnName = "IDANIMAL")
        , @JoinColumn(name = "NOMBRECIENTIFICO", referencedColumnName = "NOMBRECIENTIFICO")})
    @ManyToOne(optional = false)
    private Animal animal;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesamientoanimal")
    private List<Salidaproducto> salidaproductoList;

    public Procesamientoanimal() {
    }

    public Procesamientoanimal(ProcesamientoanimalPK procesamientoanimalPK) {
        this.procesamientoanimalPK = procesamientoanimalPK;
    }

    public Procesamientoanimal(ProcesamientoanimalPK procesamientoanimalPK, BigInteger mortal, Date fechacaducidad, double cantidad, String unidades) {
        this.procesamientoanimalPK = procesamientoanimalPK;
        this.mortal = mortal;
        this.fechacaducidad = fechacaducidad;
        this.cantidad = cantidad;
        this.unidades = unidades;
    }

    public Procesamientoanimal(BigInteger numeroprocesamiento, Date fecha, String codProducto) {
        this.procesamientoanimalPK = new ProcesamientoanimalPK(numeroprocesamiento, fecha, codProducto);
    }

    public ProcesamientoanimalPK getProcesamientoanimalPK() {
        return procesamientoanimalPK;
    }

    public void setProcesamientoanimalPK(ProcesamientoanimalPK procesamientoanimalPK) {
        this.procesamientoanimalPK = procesamientoanimalPK;
    }

    public BigInteger getMortal() {
        return mortal;
    }

    public void setMortal(BigInteger mortal) {
        this.mortal = mortal;
    }

    public Date getFechacaducidad() {
        return fechacaducidad;
    }

    public void setFechacaducidad(Date fechacaducidad) {
        this.fechacaducidad = fechacaducidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @XmlTransient
    public List<Salidaproducto> getSalidaproductoList() {
        return salidaproductoList;
    }

    public void setSalidaproductoList(List<Salidaproducto> salidaproductoList) {
        this.salidaproductoList = salidaproductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procesamientoanimalPK != null ? procesamientoanimalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procesamientoanimal)) {
            return false;
        }
        Procesamientoanimal other = (Procesamientoanimal) object;
        if ((this.procesamientoanimalPK == null && other.procesamientoanimalPK != null) || (this.procesamientoanimalPK != null && !this.procesamientoanimalPK.equals(other.procesamientoanimalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Procesamientoanimal[ procesamientoanimalPK=" + procesamientoanimalPK + " ]";
    }
    
}
