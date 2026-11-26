
export class PanelAlertas {

    actualizar(sensor) {

        // Mostramos el resultado por consola.
        if (sensor.valor > sensor.umbral) {
            console.log(
                `[ALERTA] ${sensor.tipo}: valor de ${sensor.valor} ${sensor.unidad} supera el umbral de ${sensor.umbral} ${sensor.unidad}`
            );
        } else {
            console.log(
                `[SIN ALERTA] ${sensor.tipo}: valor dentro de los limites normales`
            );
        }

        // Si estamos en el navegador, actualizamos el panel de alertas.
        if (typeof document !== "undefined") {

            const contenedor = document.getElementById("alertas");
            const id = sensor.tipo.toLowerCase().replaceAll(" ", "-");

            if (!contenedor) return;

            let alerta = contenedor.querySelector(
                `[data-sensor="${id}"]`
            );

            if (sensor.valor > sensor.umbral) {

                if (!alerta) {
                    alerta = document.createElement("p");
                    alerta.dataset.sensor = id;
                    contenedor.appendChild(alerta);
                }

                alerta.textContent =
                    `${sensor.tipo}: ${sensor.valor} ${sensor.unidad}. ` +
                    `Supera el umbral de ${sensor.umbral} ${sensor.unidad}.`;

            } else if (alerta) {
                alerta.remove();
            }

            // Administramos el mensaje cuando no hay alertas.
            const mensajeInicial = contenedor.querySelector(".mensaje-inicial");

            if (contenedor.querySelector("[data-sensor]")) {

                if (mensajeInicial) {
                    mensajeInicial.remove();
                }

            } else if (!mensajeInicial) {

                const mensaje = document.createElement("p");
                mensaje.className = "mensaje-inicial";
                mensaje.textContent = "No hay alertas registradas.";

                contenedor.appendChild(mensaje);
            }
        }
    }

}
