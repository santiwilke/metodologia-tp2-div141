
export class PanelHistorico {

    constructor() {
        this.historial = [];
    }

    actualizar(sensor) {

        const registro = {
            tipo: sensor.tipo,
            valor: sensor.valor,
            unidad: sensor.unidad
        };

        // Guardamos la medición en el historial.
        this.historial.push(registro);

        console.log(
            `[HISTORIAL] ${registro.tipo}: ${registro.valor} ${registro.unidad}`
        );

        // Si estamos en el navegador, mostramos la medición.
        if (typeof document !== "undefined") {

            const contenedor = document.getElementById("historial");

            if (!contenedor) return;

            const elemento = document.createElement("p");

            elemento.textContent =
                `${registro.tipo}: ${registro.valor} ${registro.unidad}`;

            contenedor.appendChild(elemento);
        }
    }

    mostrarHistorial() {

        console.log("\n--- HISTORIAL DE MEDICIONES ---");

        this.historial.forEach(registro => {
            console.log(
                `${registro.tipo}: ${registro.valor} ${registro.unidad}`
            );
        });
    }

}
