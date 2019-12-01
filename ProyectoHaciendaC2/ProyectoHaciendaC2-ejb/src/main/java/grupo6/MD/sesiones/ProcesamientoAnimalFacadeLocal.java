/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.MD.sesiones;

import grupo6.DP.entidades.ProcesamientoAnimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marce
 */
@Local
public interface ProcesamientoAnimalFacadeLocal {

    void create(ProcesamientoAnimal procesamientoAnimal);

    void edit(ProcesamientoAnimal procesamientoAnimal);

    void remove(ProcesamientoAnimal procesamientoAnimal);

    ProcesamientoAnimal find(Object id);

    List<ProcesamientoAnimal> findAll();

    List<ProcesamientoAnimal> findRange(int[] range);

    int count();
    
}
