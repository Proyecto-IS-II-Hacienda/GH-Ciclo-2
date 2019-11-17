/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.CuidadosAnimales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface CuidadosAnimalesFacadeLocal {

    void create(CuidadosAnimales cuidadosAnimales);

    void edit(CuidadosAnimales cuidadosAnimales);

    void remove(CuidadosAnimales cuidadosAnimales);

    CuidadosAnimales find(Object id);

    List<CuidadosAnimales> findAll();

    List<CuidadosAnimales> findRange(int[] range);

    int count();
    
}
