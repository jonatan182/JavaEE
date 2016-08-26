/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.pojo.CitaPojo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jonatanjavier
 */
@Remote
public interface EJBSaludGuruCitasRemote {
    
    public void crear(CitaPojo medico);
    public List<CitaPojo> consulta();
    public void Eliminar(CitaPojo medico);
    public void Actualizar(CitaPojo medico);
    public CitaPojo buscar(CitaPojo c);
}
