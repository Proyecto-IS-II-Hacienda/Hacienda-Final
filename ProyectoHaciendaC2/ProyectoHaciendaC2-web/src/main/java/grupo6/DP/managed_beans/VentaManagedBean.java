package grupo6.DP.managed_beans;

import grupo6.DP.entidades.Cliente;
import grupo6.DP.entidades.ProcesamientoAnimal;
import grupo6.DP.entidades.SalidaProducto;
import grupo6.DP.entidades.Venta;
import grupo6.DP.entidades.VentaPK;
import grupo6.MD.sesiones.ClienteFacadeLocal;
import grupo6.MD.sesiones.ProcesamientoAnimalFacadeLocal;
import grupo6.MD.sesiones.SalidaProductoFacadeLocal;
import grupo6.MD.sesiones.VentaFacadeLocal;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TableColumn.CellEditEvent;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Marcelo_Echeverria
 */
@Named(value = "ventaMB")
@ViewScoped
public class VentaManagedBean implements Serializable {

    @EJB
    private ProcesamientoAnimalFacadeLocal procesamientoanimalFacadeLocal;
    @EJB
    private SalidaProductoFacadeLocal salidaproductoFacadeLocal;
    @EJB
    private VentaFacadeLocal ventaFacadeLocal;
    @EJB
    private ClienteFacadeLocal clienteFacadeLocal;

    private ProcesamientoAnimal producto;
    private List<ProcesamientoAnimal> productos;
    private List<SalidaProducto> productosPreVenta;
    private List<Cliente> clientes;
    private List<Venta> ventas;
    private Cliente cliente;
    private String numFactura;

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ProcesamientoAnimal getProducto() {
        return producto;
    }

    public void setProducto(ProcesamientoAnimal producto) {
        this.producto = producto;
    }

    public List<ProcesamientoAnimal> getProductos() {
        return productos;
    }

    public void setProductos(List<ProcesamientoAnimal> productos) {
        this.productos = productos;
    }

    public List<SalidaProducto> getProductosPreVenta() {
        return productosPreVenta;
    }

    public void setProductosPreVenta(List<SalidaProducto> productosPreVenta) {
        this.productosPreVenta = productosPreVenta;
    }

    public VentaManagedBean() {
    }

    @PostConstruct
    public void onInit() {
        productos = procesamientoanimalFacadeLocal.findAll();
        clientes = clienteFacadeLocal.findAll();
        productosPreVenta = new ArrayList<>();
        ventas = ventaFacadeLocal.findAll();
        numFactura = "";
        cliente = new Cliente();
        productos.stream().map((p) -> {
            SalidaProducto sp = new SalidaProducto();
            sp.setProcesamientoAnimal(p);
            return sp;
        }).forEachOrdered((sp) ->
            productosPreVenta.add(sp)
        );
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    private void equilibrarInventario() {
        throw new UnsupportedOperationException();
    }

    public void productoListener(ValueChangeEvent e) {
        producto = (ProcesamientoAnimal) e.getNewValue();

    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }


    public void vender() {
        productosPreVenta.stream().filter(sp -> sp.getCantidad() > 0 ).map( sp -> {
            salidaproductoFacadeLocal.create(sp);
            return sp;
        }).map((sp) -> {
            sp.getProcesamientoAnimal().setCantidad(sp.getProcesamientoAnimal().getCantidad() - sp.getCantidad());
            return sp;
        }).map((sp) -> {
            procesamientoanimalFacadeLocal.edit(sp.getProcesamientoAnimal());
            return sp;
        }).forEachOrdered((sp) ->
            ventaFacadeLocal.create(new Venta(new VentaPK(numFactura,BigInteger.valueOf(sp.getIdsalidaproducto()), cliente.getCedula())))
        );

    }


    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Registro Actualizado", ((Venta)event.getObject()).getVentaPK().getIdfactura());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel() {
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Venta oldValue = (Venta)event.getOldValue();
        Venta newValue = (Venta)event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {
            ventaFacadeLocal.edit(newValue);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Venta Actualizada", oldValue.getVentaPK().getIdfactura());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void eliminar(Venta v){
    ventaFacadeLocal.remove(v);
    }

    public void nuevoProducto() {
        SalidaProducto salidaProducto = new SalidaProducto();
        try {
            salidaProducto.setProcesamientoAnimal(productos.get(0));
            productosPreVenta.add(salidaProducto);
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

}