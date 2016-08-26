/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.pojo.MedicoPojo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jonatanjavier
 */
@Remote
public interface EJBSaludGuruMedicoRemote {
    public void crear(MedicoPojo medico);
    public List<MedicoPojo> consulta();
    public void Eliminar(MedicoPojo medico);
    public void Actualizar(MedicoPojo medico);
}
