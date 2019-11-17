/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.DistribucionesAnimales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface DistribucionesAnimalesFacadeLocal {

    void create(DistribucionesAnimales distribucionesAnimales);

    void edit(DistribucionesAnimales distribucionesAnimales);

    void remove(DistribucionesAnimales distribucionesAnimales);

    DistribucionesAnimales find(Object id);

    List<DistribucionesAnimales> findAll();

    List<DistribucionesAnimales> findRange(int[] range);

    int count();
    
}
