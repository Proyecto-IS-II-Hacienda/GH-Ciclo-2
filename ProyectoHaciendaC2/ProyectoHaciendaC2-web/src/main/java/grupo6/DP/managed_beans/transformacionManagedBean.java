package grupo6.DP.managed_beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
/**
 *
 * @author XavierJC
 */
@Named(value = "transformacionManagedBean")
@ViewScoped
public class transformacionManagedBean implements Serializable {

    public transformacionManagedBean() {
    }

    public String irAPlanta() {
        return "/procesos/transPlanta.xhtml";
    }

    public String irAAnimal() {
        return "/procesos/transAnimal.xhtml";
    }
}
