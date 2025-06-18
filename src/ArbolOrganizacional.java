
/**
 *
 * @author Evelyn Martinez
 */
public class ArbolOrganizacional {

    private Nodo raiz;

    private void insertar(Nodo nuevo) {
        //Insertar la empresa como tal
        if (nuevo.getElemento().getCodigoPadre() == 0) {
            if (raiz != null) {
                throw new IllegalStateException("Ya existe un nodo raíz");
            }
            raiz = nuevo;
        } else {
            //Se busca al padre segun el identificador y se agrega a la lista de hijos de ese padre
            Nodo padre = buscarPorCodigo(raiz, nuevo.getElemento().getCodigoPadre());

            if (padre == null) {
                throw new IllegalArgumentException("No se encontró el padre");
            }
            padre.addHijo(nuevo);
        }

    }
    
    public void add(Departamento d){
         Nodo nodo = new Nodo(d);
        insertar(nodo); 
    }

    //Busqueda recursiva de un Departamento por Codigo
    public Nodo buscarPorCodigo(Nodo actual, int id) {
        if (actual == null) {
            return null;
        }
        if (actual.getElemento().getCodigo() == id) {
            return actual;
        }

        for (Nodo hijo : actual.getHijos()) {
            Nodo encontrado = buscarPorCodigo(hijo, id);
            //Si lo encuentra entonces deja de ser nulo, por lo que lo retorna para no seguir buscando
            if (encontrado != null) {
                return encontrado;
            }
        }

        return null;
    }

    //Metodo a usar en busquedas / consultas
    public Nodo buscarNombre(String nombre) {
        if (raiz == null) {
            throw new IllegalArgumentException("No existe una raiz");
        }

        return buscarPorNombreR(raiz, nombre);
    }

    //Busqueda de un departamento por nombre
    private Nodo buscarPorNombreR(Nodo nodo, String nombre) {
        //Si es el departamento padre que lo retorne
        if (nodo.getElemento().getNombre().equals(nombre)) {
            return nodo;
        }

        //Sino que busque entre los hijos
        for (Nodo hijo : nodo.getHijos()) {
            Nodo encontrado = buscarPorNombreR(hijo, nombre);

            if (encontrado != null) {
                return encontrado;
            }
        }

        return null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    //Metodo para eliminar 
    public boolean remove(int idDepartamentoEliminar, int nuevoDepartamento, boolean removeAll) {
        if (raiz == null) {
            return false;
        }

        //Si se elimina la raiz se cae la estructura, por eso se evita eliminar la raiz
        if (raiz.getElemento().getCodigo() == idDepartamentoEliminar) {
            throw new IllegalArgumentException("No se puede eliminar este Departamento porque es el Id de la Empresa");
        }

        //Buscar el departamento a eliminar
        Nodo departmentToRemove = buscarPorCodigo(raiz, idDepartamentoEliminar);
        if (departmentToRemove == null) {
            throw new IllegalArgumentException("Departamento no encontrado");
        }

        Nodo padre = departmentToRemove.getPadre();
        if (padre == null) {
            return false;
        }

        //Verificar si tiene hijos
        if (!departmentToRemove.getHijos().isEmpty()) {
            if (!removeAll) {
                // Mover los hijos al nuevo padre
                Nodo nuevoPadre = buscarPorCodigo(raiz, nuevoDepartamento);

                if (nuevoPadre == null) {
                    throw new IllegalArgumentException("Departamento no encontrado");
                }

                // Validar que estén al mismo nivel (misma longitud de código)
                int longitudAEliminar = String.valueOf(departmentToRemove.getElemento().getCodigo()).length();
                int longitudNuevoPadre = String.valueOf(nuevoPadre.getElemento().getCodigo()).length();

                if (longitudAEliminar != longitudNuevoPadre) {
                    throw new IllegalStateException("No se puede mover a este departamento ya que no es del mismo nivel");
                }

                // Mover los hijos al nuevo padre
                for (Nodo hijo : departmentToRemove.getHijos()) {
                    nuevoPadre.addHijo(hijo);
                }
            }
        }
       
       //Despues de todas las validaciones se elimina el departamento
      padre.removeHijo(departmentToRemove);
      return true;  
      
    }
    
    //Metodo prueba de arbol jerarquico
    public void mostrarJerarquia(Nodo nodo, String prefijo) {
        if (nodo == null) {
            return;
        }

        System.out.println(prefijo + "- " + nodo.getElemento().getNombre() +
                " (Departamento Padre: " + nodo.getPadre()
                + " ,Codigo: " + nodo.getElemento().getCodigo()
                + ", Nivel: " + nodo.getNivel() + ")");

        for (Nodo hijo : nodo.getHijos()) {
            mostrarJerarquia(hijo, prefijo + "  "); 
        }
    }


}
