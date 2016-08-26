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
 * @author jonatanjavier
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByIdpaciente", query = "SELECT p FROM Paciente p WHERE p.idpaciente = :idpaciente"),
    @NamedQuery(name = "Paciente.findByIdentificacionpaciente", query = "SELECT p FROM Paciente p WHERE p.identificacionpaciente = :identificacionpaciente"),
    @NamedQuery(name = "Paciente.findByNombrepaciente", query = "SELECT p FROM Paciente p WHERE p.nombrepaciente = :nombrepaciente"),
    @NamedQuery(name = "Paciente.findByApellidopaciente", query = "SELECT p FROM Paciente p WHERE p.apellidopaciente = :apellidopaciente"),
    @NamedQuery(name = "Paciente.findByEdad", query = "SELECT p FROM Paciente p WHERE p.edad = :edad")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L; 
    @Basic(optional = false)
    @Column(name = "idpaciente")
    private int idpaciente;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "identificacionpaciente")
    private Integer identificacionpaciente;
    @Size(max = 50)
    @Column(name = "nombrepaciente")
    private String nombrepaciente;
    @Size(max = 50)
    @Column(name = "apellidopaciente")
    private String apellidopaciente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificacionpaciente")
    private Collection<Cita> citaCollection;

    public Paciente() {
    }

    public Paciente(Integer identificacionpaciente) {
        this.identificacionpaciente = identificacionpaciente;
    }

    public Paciente(Integer identificacionpaciente, int idpaciente, int edad) {
        this.identificacionpaciente = identificacionpaciente;
        this.idpaciente = idpaciente;
        this.edad = edad;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Integer getIdentificacionpaciente() {
        return identificacionpaciente;
    }

    public void setIdentificacionpaciente(Integer identificacionpaciente) {
        this.identificacionpaciente = identificacionpaciente;
    }

    public String getNombrepaciente() {
        return nombrepaciente;
    }

    public void setNombrepaciente(String nombrepaciente) {
        this.nombrepaciente = nombrepaciente;
    }

    public String getApellidopaciente() {
        return apellidopaciente;
    }

    public void setApellidopaciente(String apellidopaciente) {
        this.apellidopaciente = apellidopaciente;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @XmlTransient
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Collection<Cita> citaCollection) {
        this.citaCollection = citaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacionpaciente != null ? identificacionpaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.identificacionpaciente == null && other.identificacionpaciente != null) || (this.identificacionpaciente != null && !this.identificacionpaciente.equals(other.identificacionpaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entityes.Paciente[ identificacionpaciente=" + identificacionpaciente + " ]";
    }
    
}
