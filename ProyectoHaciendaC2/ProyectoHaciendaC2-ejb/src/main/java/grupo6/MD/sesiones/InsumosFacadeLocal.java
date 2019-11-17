/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.Insumos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface InsumosFacadeLocal {

    void create(Insumos insumos);

    void edit(Insumos insumos);

    void remove(Insumos insumos);

    Insumos find(Object id);

    List<Insumos> findAll();

    List<Insumos> findRange(int[] range);

    int count();
    
}
