package com.entityes;

import com.entityes.Cita;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-26T11:46:52")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile CollectionAttribute<Paciente, Cita> citaCollection;
    public static volatile SingularAttribute<Paciente, String> apellidopaciente;
    public static volatile SingularAttribute<Paciente, Integer> idpaciente;
    public static volatile SingularAttribute<Paciente, String> nombrepaciente;
    public static volatile SingularAttribute<Paciente, Integer> edad;
    public static volatile SingularAttribute<Paciente, Integer> identificacionpaciente;

}