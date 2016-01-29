/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entityes;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author Jonatan182
 */
@Entity
@Table(name = "Modalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modalidad.findAll", query = "SELECT m FROM Modalidad m"),
    @NamedQuery(name = "Modalidad.findByCodigo", query = "SELECT m FROM Modalidad m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Modalidad.findByModalidad", query = "SELECT m FROM Modalidad m WHERE m.modalidad = :modalidad")})
public class Modalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "modalidad")
    private String modalidad;
    @OneToMany(mappedBy = "modalidad")
    private Collection<Ciclos> ciclosCollection;

    public Modalidad() {
    }

    public Modalidad(Integer codigo) {
        this.codigo = codigo;
    }

    public Modalidad(Integer codigo, String modalidad) {
        this.codigo = codigo;
        this.modalidad = modalidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    @XmlTransient
    public Collection<Ciclos> getCiclosCollection() {
        return ciclosCollection;
    }

    public void setCiclosCollection(Collection<Ciclos> ciclosCollection) {
        this.ciclosCollection = ciclosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalidad)) {
            return false;
        }
        Modalidad other = (Modalidad) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entityes.Modalidad[ codigo=" + codigo + " ]";
    }
    
}
