import java.util.*;

public class Nodo {
    private Departamento departamento;
    private Nodo padre;
    private List<Nodo> hijos;
    private int nivel;

    public Nodo(Departamento departamento){
        this.departamento = departamento;
        this.hijos = new ArrayList<>();
    }

    public Departamento getElemento(){
        return departamento;
    }

    public List<Nodo> getHijos(){
        return hijos;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
        actualizarNivel();
    }

    public int getNivel() {
        return nivel;
    }

    private void actualizarNivel() {
        if (padre == null) {
            this.nivel = 0;
        } else {
            this.nivel = padre.getNivel() + 1;
        }

        // Actualiza niveles de los hijos también
        for (Nodo hijo : hijos) {
            hijo.actualizarNivel();
        }
    }

    public void addHijo(Nodo hijo){
        hijo.setPadre(this); // importante
        hijos.add(hijo);
    }

    public void removeHijo(Nodo hijo){
        hijos.remove(hijo);
    }

    @Override
    public String toString() {
        return departamento.getNombre() + " (Código: " + departamento.getCodigo() + ", Nivel: " + getNivel() + ")";
    }
}
