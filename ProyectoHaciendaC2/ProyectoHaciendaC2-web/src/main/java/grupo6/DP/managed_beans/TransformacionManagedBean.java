/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.DP.managed_beans;

import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author vjose
 */
@Named(value = "transformacionManagedBean")
@ViewScoped
public class TransformacionManagedBean {

    /**
     * Creates a new instance of TransformacionManagedBean
     */
    public TransformacionManagedBean() {
    }
    
    public String irAPlanta(){
        return "/procesos/transPlanta.xhtml";
    }
    
    public String irAAnimal(){
        return "/procesos/transAnimal.xhtml";
    }
}
