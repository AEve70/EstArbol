
/**
 *
 * @author Evelyn Martinez 
 */
public class Departamento {
     private int codigo;
    private String nombre;
    private int codigoPadre;
    private int cantidadEmpleados;
    private double presupuesto;
    private boolean tieneInconsistencias;

    public Departamento() {
    }
    
    //Constructor en beneficio del archivo
    public Departamento(int codigo, String nombre, int codigoPadre, int cantidadEmpleados, int presupuesto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigoPadre = codigoPadre;
        this.cantidadEmpleados = cantidadEmpleados;
        this.presupuesto = presupuesto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoPadre() {
        return codigoPadre;
    }

    public void setCodigoPadre(int codigoPadre) {
        this.codigoPadre = codigoPadre;
    }

    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(int cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public boolean isTieneInconsistencias() {
        return tieneInconsistencias;
    }

    public void setTieneInconsistencias(boolean tieneInconsistencias) {
        this.tieneInconsistencias = tieneInconsistencias;
    }

    @Override
    public String toString() {
        return "Departamentos{" + "codigo=" + codigo + ", nombre=" + nombre + ", codigoPadre=" + codigoPadre + ", cantidadEmpleados=" + cantidadEmpleados + ", presupuesto=" + presupuesto + ", tieneInconsistencias=" + tieneInconsistencias + '}';
    }
    
    
    
    
    
    
}
