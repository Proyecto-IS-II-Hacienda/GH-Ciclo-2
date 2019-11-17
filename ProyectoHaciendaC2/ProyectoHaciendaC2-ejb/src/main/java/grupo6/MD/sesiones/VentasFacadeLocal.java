/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Ventas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface VentasFacadeLocal {

    void create(Ventas ventas);

    void edit(Ventas ventas);

    void remove(Ventas ventas);

    Ventas find(Object id);

    List<Ventas> findAll();

    List<Ventas> findRange(int[] range);

    int count();
    
}
