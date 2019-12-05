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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Albert
 */
@Entity
@Table(name = "ANIMAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a")
    , @NamedQuery(name = "Animal.findByIdanimal", query = "SELECT a FROM Animal a WHERE a.animalPK.idanimal = :idanimal")
    , @NamedQuery(name = "Animal.findByNombrecientifico", query = "SELECT a FROM Animal a WHERE a.animalPK.nombrecientifico = :nombrecientifico")
    , @NamedQuery(name = "Animal.findByPeso", query = "SELECT a FROM Animal a WHERE a.peso = :peso")
    , @NamedQuery(name = "Animal.findByLongitudvertical", query = "SELECT a FROM Animal a WHERE a.longitudvertical = :longitudvertical")
    , @NamedQuery(name = "Animal.findByLongitudhorizontal", query = "SELECT a FROM Animal a WHERE a.longitudhorizontal = :longitudhorizontal")
    , @NamedQuery(name = "Animal.findByFechanacimiento", query = "SELECT a FROM Animal a WHERE a.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "Animal.findBySexo", query = "SELECT a FROM Animal a WHERE a.sexo = :sexo")})
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnimalPK animalPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PESO")
    private BigInteger peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUDVERTICAL")
    private double longitudvertical;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUDHORIZONTAL")
    private double longitudhorizontal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHANACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXO")
    private Character sexo;
    @JoinColumns({
        @JoinColumn(name = "NOMBRECOMUN", referencedColumnName = "NOMBRECOMUN")
        , @JoinColumn(name = "NOMBRECIENTIFICO", referencedColumnName = "NOMBRECIENTIFICO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Tipodeanimal tipodeanimal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
    private List<Distribucionanimal> distribucionanimalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
    private List<Procesamientoanimal> procesamientoanimalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
    private List<Cuidadoanimal> cuidadoanimalList;

    public Animal() {
    }

    public Animal(AnimalPK animalPK) {
        this.animalPK = animalPK;
    }

    public Animal(AnimalPK animalPK, BigInteger peso, double longitudvertical, double longitudhorizontal, Date fechanacimiento, Character sexo) {
        this.animalPK = animalPK;
        this.peso = peso;
        this.longitudvertical = longitudvertical;
        this.longitudhorizontal = longitudhorizontal;
        this.fechanacimiento = fechanacimiento;
        this.sexo = sexo;
    }

    public Animal(String idanimal, String nombrecientifico) {
        this.animalPK = new AnimalPK(idanimal, nombrecientifico);
    }

    public AnimalPK getAnimalPK() {
        return animalPK;
    }

    public void setAnimalPK(AnimalPK animalPK) {
        this.animalPK = animalPK;
    }

    public BigInteger getPeso() {
        return peso;
    }

    public void setPeso(BigInteger peso) {
        this.peso = peso;
    }

    public double getLongitudvertical() {
        return longitudvertical;
    }

    public void setLongitudvertical(double longitudvertical) {
        this.longitudvertical = longitudvertical;
    }

    public double getLongitudhorizontal() {
        return longitudhorizontal;
    }

    public void setLongitudhorizontal(double longitudhorizontal) {
        this.longitudhorizontal = longitudhorizontal;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Tipodeanimal getTipodeanimal() {
        return tipodeanimal;
    }

    public void setTipodeanimal(Tipodeanimal tipodeanimal) {
        this.tipodeanimal = tipodeanimal;
    }

    @XmlTransient
    public List<Distribucionanimal> getDistribucionanimalList() {
        return distribucionanimalList;
    }

    public void setDistribucionanimalList(List<Distribucionanimal> distribucionanimalList) {
        this.distribucionanimalList = distribucionanimalList;
    }

    @XmlTransient
    public List<Procesamientoanimal> getProcesamientoanimalList() {
        return procesamientoanimalList;
    }

    public void setProcesamientoanimalList(List<Procesamientoanimal> procesamientoanimalList) {
        this.procesamientoanimalList = procesamientoanimalList;
    }

    @XmlTransient
    public List<Cuidadoanimal> getCuidadoanimalList() {
        return cuidadoanimalList;
    }

    public void setCuidadoanimalList(List<Cuidadoanimal> cuidadoanimalList) {
        this.cuidadoanimalList = cuidadoanimalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (animalPK != null ? animalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.animalPK == null && other.animalPK != null) || (this.animalPK != null && !this.animalPK.equals(other.animalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo6.DP.entidades.Animal[ animalPK=" + animalPK + " ]";
    }
    
}
