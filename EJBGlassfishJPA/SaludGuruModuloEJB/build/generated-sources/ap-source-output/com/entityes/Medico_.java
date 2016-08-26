package com.entityes;

import com.entityes.Cita;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-26T11:46:52")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile CollectionAttribute<Medico, Cita> citaCollection;
    public static volatile SingularAttribute<Medico, String> nombremedico;
    public static volatile SingularAttribute<Medico, String> apellidomedico;
    public static volatile SingularAttribute<Medico, Integer> identificacionmedico;
    public static volatile SingularAttribute<Medico, Integer> idmedico;
    public static volatile SingularAttribute<Medico, Integer> edadmedico;

}