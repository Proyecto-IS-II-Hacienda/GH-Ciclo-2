package grupo6.DP.managed_beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "transformacionManagedBean")
@ViewScoped
public class TransformacionManagedBean implements Serializable {

    public TransformacionManagedBean() {
    }

    public String irAPlanta() {
        return "/procesos/transPlanta.xhtml";
    }

    public String irAAnimal() {
        return "/procesos/transAnimal.xhtml";
    }
}
