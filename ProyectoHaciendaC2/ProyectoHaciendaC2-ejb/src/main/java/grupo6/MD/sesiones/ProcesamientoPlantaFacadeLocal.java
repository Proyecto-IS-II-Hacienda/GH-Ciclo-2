/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.ProcesamientoPlanta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marce
 */
@Local
public interface ProcesamientoPlantaFacadeLocal {

    void create(ProcesamientoPlanta procesamientoPlanta);

    void edit(ProcesamientoPlanta procesamientoPlanta);

    void remove(ProcesamientoPlanta procesamientoPlanta);

    ProcesamientoPlanta find(Object id);

    List<ProcesamientoPlanta> findAll();

    List<ProcesamientoPlanta> findRange(int[] range);

    int count();
    
}
