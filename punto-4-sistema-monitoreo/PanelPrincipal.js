
export class PanelPrincipal {

    actualizar(sensor) {

        // Mostramos el cambio por consola.
        console.log(
            `[PANEL PRINCIPAL] ${sensor.tipo}: ${sensor.valor} ${sensor.unidad}`
        );

        // Si estamos ejecutando en el navegador, actualizamos la interfaz.
        if (typeof document !== "undefined") {

            const id = sensor.tipo.toLowerCase().replaceAll(" ", "-");

            const valor = document.getElementById(`valor-${id}`);
            const estado = document.getElementById(`estado-${id}`);

            if (valor && estado) {

                valor.textContent = `${sensor.valor} ${sensor.unidad}`;

                if (sensor.valor > sensor.umbral) {
                    estado.textContent = "Alerta";
                    estado.className = "estado-alerta";
                } else {
                    estado.textContent = "Normal";
                    estado.className = "estado-normal";
                }

            }
        }
    }

}
