public class Paciente extends Persona {
    private HistorialMedico historialMedico;
    public Paciente(String nombre, int edad, String genero, String direccion, String telefono, String correoElectronico) {
        super(nombre, edad, genero, direccion, telefono, correoElectronico);
        this.historialMedico = new HistorialMedico();
    }

    public boolean esAdultoMayor(){
        return super.getEdad()>=65;
    }
    public HistorialMedico getHistorialMedico() {
    	return this.historialMedico;
    }
    public void setHistorialMedico(HistorialMedico hm) {
    	this.historialMedico=hm;
    }
}