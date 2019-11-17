/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.DistribucionesPlantas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface DistribucionesPlantasFacadeLocal {

    void create(DistribucionesPlantas distribucionesPlantas);

    void edit(DistribucionesPlantas distribucionesPlantas);

    void remove(DistribucionesPlantas distribucionesPlantas);

    DistribucionesPlantas find(Object id);

    List<DistribucionesPlantas> findAll();

    List<DistribucionesPlantas> findRange(int[] range);

    int count();
    
}
