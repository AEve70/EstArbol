

/**
 *
 * @author Evelyn Martinez
 */
public class Main {
    public static void main(String [] args){
        ArbolOrganizacional arbol = new ArbolOrganizacional();
        
        
        arbol.add(new Departamento(1, "Empresa Testting", 0, 0, 0));
        
        arbol.add(new Departamento(10, "FINANZAS", 1, 20, 9000));
        arbol.add(new Departamento(11, "Contabilidad", 10, 6, 8000));
        arbol.add(new Departamento(12, "Auditoria", 10, 5, 4000));
        
        arbol.add(new Departamento(20, "RRHH", 1, 5, 5000));
        arbol.add(new Departamento(21, "Reclutamiento", 20, 5, 3000));
        arbol.add(new Departamento(22, "Capacitacion", 20, 5, 2000));
        
        arbol.add(new Departamento(30, "INFORMATICA", 1, 10, 1000));
        arbol.add(new Departamento(31, "Soporte", 30, 5, 9000));
        arbol.add(new Departamento(32, "Desarrollo", 30, 5, 8000));
        
        arbol.add(new Departamento(40, "LOGISTICA", 1, 10, 1000));
        arbol.add(new Departamento(31, "Transporte", 40, 5, 9000));
        arbol.add(new Departamento(32, "Almacen", 40, 5, 8000));
        
        arbol.mostrarJerarquia(arbol.getRaiz(), "");
        
        arbol.remove(40, 10, false);
        
        System.out.println("\n\n");
        arbol.mostrarJerarquia(arbol.getRaiz(), "");
        
        
        
    }
}
