/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.SalidaInsumos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface SalidaInsumosFacadeLocal {

    void create(SalidaInsumos salidaInsumos);

    void edit(SalidaInsumos salidaInsumos);

    void remove(SalidaInsumos salidaInsumos);

    SalidaInsumos find(Object id);

    List<SalidaInsumos> findAll();

    List<SalidaInsumos> findRange(int[] range);

    int count();
    
}
