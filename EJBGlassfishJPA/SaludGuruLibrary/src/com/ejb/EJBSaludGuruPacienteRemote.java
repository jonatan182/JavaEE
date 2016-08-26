/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.pojo.PacientePojo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jonatanjavier
 */
@Remote
public interface EJBSaludGuruPacienteRemote {
    public void crear(PacientePojo medico);
    public List<PacientePojo> consulta();
    public void Eliminar(PacientePojo medico);
    public void Actualizar(PacientePojo medico);
}
