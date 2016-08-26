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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m ORDER BY m.nombremedico"),
    @NamedQuery(name = "Medico.findByIdmedico", query = "SELECT m FROM Medico m WHERE m.idmedico = :idmedico"),
    @NamedQuery(name = "Medico.findByIdentificacionmedico", query = "SELECT m FROM Medico m WHERE m.identificacionmedico = :identificacionmedico"),
    @NamedQuery(name = "Medico.findByNombremedico", query = "SELECT m FROM Medico m WHERE m.nombremedico = :nombremedico"),
    @NamedQuery(name = "Medico.findByApellidomedico", query = "SELECT m FROM Medico m WHERE m.apellidomedico = :apellidomedico"),
    @NamedQuery(name = "Medico.findByEdadmedico", query = "SELECT m FROM Medico m WHERE m.edadmedico = :edadmedico")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idmedico")
    private int idmedico;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "identificacionmedico")
    private Integer identificacionmedico;
    @Size(max = 50)
    @Column(name = "nombremedico")
    private String nombremedico;
    @Size(max = 50)
    @Column(name = "apellidomedico")
    private String apellidomedico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edadmedico")
    private int edadmedico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificacionmedico")
    private Collection<Cita> citaCollection;

    public Medico() {
    }

    public Medico(Integer identificacionmedico) {
        this.identificacionmedico = identificacionmedico;
    }

    public Medico(Integer identificacionmedico, int idmedico, int edadmedico) {
        this.identificacionmedico = identificacionmedico;
        this.idmedico = idmedico;
        this.edadmedico = edadmedico;
    }

    public int getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    public Integer getIdentificacionmedico() {
        return identificacionmedico;
    }

    public void setIdentificacionmedico(Integer identificacionmedico) {
        this.identificacionmedico = identificacionmedico;
    }

    public String getNombremedico() {
        return nombremedico;
    }

    public void setNombremedico(String nombremedico) {
        this.nombremedico = nombremedico;
    }

    public String getApellidomedico() {
        return apellidomedico;
    }

    public void setApellidomedico(String apellidomedico) {
        this.apellidomedico = apellidomedico;
    }

    public int getEdadmedico() {
        return edadmedico;
    }

    public void setEdadmedico(int edadmedico) {
        this.edadmedico = edadmedico;
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
        hash += (identificacionmedico != null ? identificacionmedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.identificacionmedico == null && other.identificacionmedico != null) || (this.identificacionmedico != null && !this.identificacionmedico.equals(other.identificacionmedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entityes.Medico[ identificacionmedico=" + identificacionmedico + " ]";
    }
    
}
