/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.CuidadosPlantas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface CuidadosPlantasFacadeLocal {

    void create(CuidadosPlantas cuidadosPlantas);

    void edit(CuidadosPlantas cuidadosPlantas);

    void remove(CuidadosPlantas cuidadosPlantas);

    CuidadosPlantas find(Object id);

    List<CuidadosPlantas> findAll();

    List<CuidadosPlantas> findRange(int[] range);

    int count();
    
}
