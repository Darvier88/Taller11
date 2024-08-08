import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistorialMedico {
    private List<Consulta> consultas;
    private List<RecetaMedica> recetasMedicas;

    public HistorialMedico() {
        this.consultas = new ArrayList<>();
        this.recetasMedicas = new ArrayList<>();
    }

    public List<Consulta> getConsultas() {
        return Collections.unmodifiableList(consultas);
    }

    public void addConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public void removeConsulta(Consulta consulta) {
        this.consultas.remove(consulta);
    }

    public List<RecetaMedica> getRecetasMedicas() {
        return Collections.unmodifiableList(recetasMedicas);
    }

    public void addRecetaMedica(RecetaMedica recetaMedica) {
        this.recetasMedicas.add(recetaMedica);
    }

    public void removeRecetaMedica(RecetaMedica recetaMedica) {
        this.recetasMedicas.remove(recetaMedica);
    }
}

