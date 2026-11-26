package punto5;

import java.util.List;

public class GeneradorReportes {

    public String generarReporte(List<Heroe> heroes) {
        return "Reporte de Batalla - Total de héroes reclutados: " + heroes.size();
    }
}
