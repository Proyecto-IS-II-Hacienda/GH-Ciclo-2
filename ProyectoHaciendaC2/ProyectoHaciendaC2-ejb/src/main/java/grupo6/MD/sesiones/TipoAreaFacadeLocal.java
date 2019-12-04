/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.TipoArea;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marce
 */
@Local
public interface TipoAreaFacadeLocal {

    void create(TipoArea tipoArea);

    void edit(TipoArea tipoArea);

    void remove(TipoArea tipoArea);

    TipoArea find(Object id);

    List<TipoArea> findAll();

    List<TipoArea> findRange(int[] range);

    int count();
    
}
