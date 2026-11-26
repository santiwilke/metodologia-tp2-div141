package punto5;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Gremio gremioNorte = new Gremio("Gremio del Norte");
        Gremio gremioSur = new Gremio("Gremio del Sur");

        gremioNorte.solicitarReclutamiento(
                new GuerreroFactory("Arthas", "El Inquebrantable", LocalDate.now(), 80, 12, 5)
        );
        gremioSur.solicitarReclutamiento(
                new GuerreroFactory("Kael", "Rompeescudos", LocalDate.now(), 95, 15, 6)
        );
        gremioNorte.solicitarReclutamiento(
                new MagoFactory("Lyra", "Tejedora Arcana", LocalDate.now(), 250)
        );

        Guerrero mejor = gremioNorte.consultarMejorGuerrero();
        if (mejor != null) {
            System.out.println("Mejor guerrero: " + mejor.getNombre() + " (" + mejor.getApodo() + ") - Puntaje: " + mejor.calcularPuntaje());
        }

        System.out.println(gremioSur.solicitarReporteBatalla());
    }
}
