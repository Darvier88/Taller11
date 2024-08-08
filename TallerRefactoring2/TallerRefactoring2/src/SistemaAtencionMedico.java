import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class SistemaAtencionMedico {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<ServicioMedico> serviciosMedicos;
    private static final double DESCUENTO_ADULTO_MAYOR = 0.25;
    private static final int TERCERA_EDAD=65;

    public SistemaAtencionMedico() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.serviciosMedicos = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void agregarServicioMedico(ServicioMedico servicioMedico) {
        serviciosMedicos.add(servicioMedico);
    }

    public List<Paciente> getPacientes() {
        return Collections.unmodifiableList(pacientes);
    }

    public List<Medico> getMedicos() {
        return Collections.unmodifiableList(medicos);
    }

    public List<ServicioMedico> getServiciosMedicos() {
        return Collections.unmodifiableList(serviciosMedicos);
    }
    public void eliminarPaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }
    public void eliminarMedico(Medico medico) {
        medicos.remove(medico);
    }
    public void eliminarServicioMedico(ServicioMedico servicioMedico) {
        serviciosMedicos.remove(servicioMedico);
    }
    public void agendarConsulta(Paciente paciente, Consulta consulta){
        double costoConsulta = this.calcularValorFinalConsulta(consulta);
        System.out.println("Se han cobrado "+ costoConsulta+ " dolares de su tarjeta de credito");
        paciente.getHistorialMedico().addConsulta(consulta); //Hacer esto es incorrecto
    }

    public double calcularValorFinalConsulta(Consulta consulta){
    	double costoConsulta = consulta.getServicioMedico().getCosto();
        double valorARestar = 0;
        if (consulta.getPaciente().getEdad() >= TERCERA_EDAD) {
            valorARestar = costoConsulta * DESCUENTO_ADULTO_MAYOR;
        }
        return costoConsulta - valorARestar;
    }

    // se puede parametrizar (obtener...)
    public <T> T obtenerEntidadPorNombre(List<T> lista, String nombre, Function<T, String> nombreExtractor) {
        for (T entidad : lista) {
            if (nombreExtractor.apply(entidad).equals(nombre)) {
                return entidad;
            }
        }
        return null;
    }

    public Paciente obtenerPaciente(String nombrePaciente) {
        return obtenerEntidadPorNombre(pacientes, nombrePaciente, Paciente::getNombre);
    }

    public ServicioMedico obtenerServicioMedico(String nombreServicio) {
        return obtenerEntidadPorNombre(serviciosMedicos, nombreServicio, ServicioMedico::getNombre);
    }

    public Medico obtenerMedico(String nombreMedico) {
        return obtenerEntidadPorNombre(medicos, nombreMedico, Medico::getNombre);
    }
}
