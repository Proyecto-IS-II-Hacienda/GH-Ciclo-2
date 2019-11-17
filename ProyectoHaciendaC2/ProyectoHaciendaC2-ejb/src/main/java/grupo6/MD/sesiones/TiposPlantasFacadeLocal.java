/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.TiposPlantas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo_Echeverria
 */
@Local
public interface TiposPlantasFacadeLocal {

    void create(TiposPlantas tiposPlantas);

    void edit(TiposPlantas tiposPlantas);

    void remove(TiposPlantas tiposPlantas);

    TiposPlantas find(Object id);

    List<TiposPlantas> findAll();

    List<TiposPlantas> findRange(int[] range);

    int count();
    
}
