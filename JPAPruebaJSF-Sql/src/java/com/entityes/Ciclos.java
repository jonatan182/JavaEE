/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entityes;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author Jonatan182
 */
@Entity
@Table(name = "Ciclos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciclos.findAll", query = "SELECT c FROM Ciclos c"),
    @NamedQuery(name = "Ciclos.findByNumeroCiclo", query = "SELECT c FROM Ciclos c WHERE c.numeroCiclo = :numeroCiclo"),
    @NamedQuery(name = "Ciclos.findByDescripcion", query = "SELECT c FROM Ciclos c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Ciclos.findByNumeroAlumnos", query = "SELECT c FROM Ciclos c WHERE c.numeroAlumnos = :numeroAlumnos"),
    @NamedQuery(name = "Ciclos.findByCiclo", query = "SELECT c FROM Ciclos c WHERE c.ciclo = :ciclo")})
public class Ciclos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroCiclo")
    private Integer numeroCiclo;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "numeroAlumnos")
    private Integer numeroAlumnos;
    @Size(max = 50)
    @Column(name = "ciclo")
    private String ciclo;
    @JoinColumn(name = "modalidad", referencedColumnName = "codigo")
    @ManyToOne
    private Modalidad modalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciclos")
    private Collection<Cursos> cursosCollection;

    public Ciclos() {
    }

    public Ciclos(Integer numeroCiclo) {
        this.numeroCiclo = numeroCiclo;
    }

    public Integer getNumeroCiclo() {
        return numeroCiclo;
    }

    public void setNumeroCiclo(Integer numeroCiclo) {
        this.numeroCiclo = numeroCiclo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(Integer numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    @XmlTransient
    public Collection<Cursos> getCursosCollection() {
        return cursosCollection;
    }

    public void setCursosCollection(Collection<Cursos> cursosCollection) {
        this.cursosCollection = cursosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCiclo != null ? numeroCiclo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciclos)) {
            return false;
        }
        Ciclos other = (Ciclos) object;
        if ((this.numeroCiclo == null && other.numeroCiclo != null) || (this.numeroCiclo != null && !this.numeroCiclo.equals(other.numeroCiclo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entityes.Ciclos[ numeroCiclo=" + numeroCiclo + " ]";
    }
    
}
