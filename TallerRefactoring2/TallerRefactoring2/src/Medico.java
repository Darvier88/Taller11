public class Medico extends Persona {

public Medico(String nombre, int edad, String genero, String direccion, String telefono, String correoElectronico) {
super(nombre, edad, genero, direccion, telefono, correoElectronico);
}

public void realizarConsulta(Paciente paciente, HistorialMedico historialMedico, SistemaAtencionMedico sistemaAtencionMedico) {
	String tratamiento; 
	System.out.println("Realizando consulta a " +paciente.getNombre() +" (Solo se usa el objeto persona en este método...)");
	tratamiento = "Conservador...";
	prescribirTratamiento(paciente, tratamiento);
}

private void prescribirTratamiento(Paciente paciente, String tratamiento) {
// Implementación para prescribir un tratamiento al paciente.
System.out.println("Prescribiendo tratamiento... " +
"(Este método solo debe ser utilizado en esta clase, nadie más lo puede utilizar)");
}

public void administrarMedicamento(Paciente paciente, String medicamento) {
// Implementación para administrar medicamentos al paciente.
}
}
