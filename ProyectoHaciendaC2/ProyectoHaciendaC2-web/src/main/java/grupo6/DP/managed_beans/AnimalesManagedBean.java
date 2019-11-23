/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.managed_beans;

import grupo6.DP.entidades.Animales;
import grupo6.MD.sesiones.AnimalesFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Albert
 */
@Named(value = "animalesManagedBean")
@ViewScoped
public class AnimalesManagedBean implements Serializable {
    @EJB
    private AnimalesFacadeLocal animalesFacadeLocal;
    private List <Animales> animalesList;
    

    /**
     * Creates a new instance of AnimalesManagedBean
     */
    public AnimalesManagedBean() {
    }
    
    
     @PostConstruct
    public void init(){
        animalesList=animalesFacadeLocal.findAll();
    }

    public List<Animales> getAnimalesList() {
        return animalesList;
    }

    public void setAnimalesList(List<Animales> animalesList) {
        this.animalesList = animalesList;
    }
    
     public void seleccionar(Animales animal){
        PrimeFaces.current().dialog().closeDynamic(animal);
    }
    
}
