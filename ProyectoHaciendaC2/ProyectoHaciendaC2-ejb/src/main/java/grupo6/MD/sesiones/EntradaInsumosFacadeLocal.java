/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.EntradaInsumos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface EntradaInsumosFacadeLocal {

    void create(EntradaInsumos entradaInsumos);

    void edit(EntradaInsumos entradaInsumos);

    void remove(EntradaInsumos entradaInsumos);

    EntradaInsumos find(Object id);

    List<EntradaInsumos> findAll();

    List<EntradaInsumos> findRange(int[] range);

    int count();
    
}
