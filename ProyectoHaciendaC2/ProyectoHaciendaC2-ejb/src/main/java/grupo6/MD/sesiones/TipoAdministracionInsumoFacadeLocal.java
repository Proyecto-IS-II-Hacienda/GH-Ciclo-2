/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.TipoAdministracionInsumo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marce
 */
@Local
public interface TipoAdministracionInsumoFacadeLocal {

    void create(TipoAdministracionInsumo tipoAdministracionInsumo);

    void edit(TipoAdministracionInsumo tipoAdministracionInsumo);

    void remove(TipoAdministracionInsumo tipoAdministracionInsumo);

    TipoAdministracionInsumo find(Object id);

    List<TipoAdministracionInsumo> findAll();

    List<TipoAdministracionInsumo> findRange(int[] range);

    int count();
    
}
