
export class RegistroConsola {

    actualizar(sensor) {

        const mensaje =
            `Se detectó un cambio en ${sensor.tipo}: ` +
            `${sensor.valor} ${sensor.unidad}`;

        // Conservamos el registro por consola.
        console.log(`[REGISTRO] ${mensaje}`);

        // Si estamos en el navegador, mostramos el cambio.
        if (typeof document !== "undefined") {

            const contenedor = document.getElementById("registro");

            if (!contenedor) return;

            const elemento = document.createElement("p");

            elemento.textContent = mensaje;

            contenedor.appendChild(elemento);
        }
    }

}
