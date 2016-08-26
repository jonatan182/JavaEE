package com.entityes;

import com.entityes.Medico;
import com.entityes.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-26T11:46:52")
@StaticMetamodel(Cita.class)
public class Cita_ { 

    public static volatile SingularAttribute<Cita, Date> fecha;
    public static volatile SingularAttribute<Cita, Integer> idcita;
    public static volatile SingularAttribute<Cita, Date> hora;
    public static volatile SingularAttribute<Cita, Medico> identificacionmedico;
    public static volatile SingularAttribute<Cita, Paciente> identificacionpaciente;

}