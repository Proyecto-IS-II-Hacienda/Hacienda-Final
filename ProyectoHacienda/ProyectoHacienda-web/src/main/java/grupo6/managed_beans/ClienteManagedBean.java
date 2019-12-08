
package grupo6.managed_beans;



import grupo6.entities.Clientes;
import grupo6.sessions.ClientesFacadeLocal;
import java.util.List;
import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import grupo6.utilitarios.Crud;
import java.util.function.Supplier;


/**
 *
 * @author XavierJC
 */
@Named(value = "clienteManagedBean")
@ViewScoped
public class ClienteManagedBean implements Serializable, Crud<Clientes>{

    
    private Clientes clientes;
    private List<Clientes> clientesList;
    private boolean edicion;

    @EJB
    private ClientesFacadeLocal clientesFacadeLocal;
    
    public ClienteManagedBean() {
    }
    
    @Override
     @PostConstruct
    public void init() {
        clientesList =  clientesFacadeLocal.findAll();
    }
    
    
    @Override
    public void grabar() {

        try {
            
            if (edicion) {
                clientesFacadeLocal.edit(clientes);
            } else {
                clientesFacadeLocal.create(clientes);
            }
            init();
            clientes = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "el cliente sea gravado exitosamente"));
        } catch (Exception e) { 
             notificarError("Ha ocurrido un error al guardar los datos");
            throw new RuntimeException(e);
        }
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    public boolean isEdicion() {
        return edicion;
    }

    public void setEdicion(boolean edicion) {
        this.edicion = edicion;
    }
    
    @Override
    public void nuevo() {
        edicion = false;
        clientes = new Clientes();

    }

    @Override
    public void cancelar() {
        clientes = null;
    }

    public void selecionar(Clientes clientes) {
        edicion = true;
        this.clientes = clientes;
    }

    @Override
    public void eliminar(Clientes clientes) {
        clientesFacadeLocal.remove(clientes);
        init();
    }

    @Override
    public void seleccionar(Clientes clase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
