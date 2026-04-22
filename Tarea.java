import java.util.ArrayList;

public class Tarea {

    int id;
    String descripcion;
    int prioridad;
    boolean completada;

    ArrayList<Tarea> tareas = new ArrayList<>();

    // complejidad de tiempo O(1) para agregar una tarea al final de la lista, ya que ArrayList permite acceso directo por índice.
    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }
    // complejidad de tiempo O(n) para listar todas las tareas, ya que se debe recorrer toda la lista de tareas para imprimir cada una de ellas.
    public void listarTareas() {
        for (Tarea tarea : tareas) {
            System.out.println(tarea);
        }
    }
    // complejidad de tiempo O(n) para buscar una tarea por su ID, 
    // ya que en el peor de los casos (cuando la tarea no existe o está al final de la lista) se deben verificar todas las tareas en la lista.
    public Tarea buscarPorId(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.id == id) {
                return tarea;
            }
        }
        return null;
    }
    // complejidad de tiempo O(n) para marcar una tarea como completada,
    // ya que se debe buscar la tarea por su ID antes de marcarla como completada, lo que implica recorrer la lista de tareas en el peor de los casos.
    public void marcarCompletada(int id) {
        Tarea tarea = buscarPorId(id);
        if (tarea != null) {
            tarea.completada = true;
        }
    }
    // complejidad de tiempo O(n) para eliminar una tarea por su ID,
    // ya que se debe buscar la tarea por su ID antes de eliminarla, lo que implica recorrer la lista de tareas en el peor de los casos.
    public void eliminarTarea(int id) {
        Tarea tarea = buscarPorId(id);
        if (tarea != null) {
            tareas.remove(tarea);
        }
    }
    // complejidad de tiempo O(n) para obtener las tareas pendientes,
    // ya que se debe recorrer toda la lista de tareas para verificar cuáles no están completadas y agregarlas a la lista de tareas pendientes.
    public ArrayList<Tarea> obtenerTareasPendientes() {
        ArrayList<Tarea> pendientes = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (!tarea.completada) {
                pendientes.add(tarea);
            }
        }
        return pendientes;
    }
    // complejidad de tiempo O(n) para obtener las tareas por prioridad,
    // ya que se debe recorrer toda la lista de tareas para verificar cuáles tienen la prioridad especificada y agregarlas a la lista de tareas por prioridad.
    public ArrayList<Tarea> obtenerTareasPorPrioridad(int prioridad) {
        ArrayList<Tarea> porPrioridad = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (tarea.prioridad == prioridad) {
                porPrioridad.add(tarea);
            }
        }
        return porPrioridad;
    }

    @Override
    public String toString() {
        return "Tarea{" +"id = " + id +", descripcion = '" + descripcion + '\'' +", prioridad = " + prioridad +", completada = " + completada +'}';
    }



    public static void main(String[] args) {
        Tarea tarea1 = new Tarea();
        tarea1.id = 1;
        tarea1.descripcion = "Comprar comestibles";
        tarea1.prioridad = 3;
        tarea1.completada = false;

        Tarea tarea2 = new Tarea();
        tarea2.id = 2;
        tarea2.descripcion = "Lavar el auto";
        tarea2.prioridad = 2;
        tarea2.completada = false;

        Tarea tarea3 = new Tarea();
        tarea3.id = 3;
        tarea3.descripcion = "Pagar facturas";
        tarea3.prioridad = 5;
        tarea3.completada = true;

        Tarea gestorTareas = new Tarea();
        gestorTareas.agregarTarea(tarea1);
        gestorTareas.agregarTarea(tarea2);
        gestorTareas.agregarTarea(tarea3);

        System.out.println("Todas las tareas:");
        gestorTareas.listarTareas();

        System.out.println("\nBuscar tarea con ID 2:");
        System.out.println(gestorTareas.buscarPorId(2));

        System.out.println("\nMarcar tarea completada por ID: 1.");
        gestorTareas.marcarCompletada(1);

        System.out.println("\nTareas pendientes:");
        for (Tarea t : gestorTareas.obtenerTareasPendientes()) {
            System.out.println(t);
        }

        System.out.println("\nEliminar tarea con ID 3.");
        gestorTareas.eliminarTarea(3);

        System.out.println("\nTodas las tareas después de eliminar:");
        gestorTareas.listarTareas();
    }
}
