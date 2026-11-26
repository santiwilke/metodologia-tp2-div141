
import { Sensor } from "./Sensor.js";
import { PanelPrincipal } from "./PanelPrincipal.js";
import { PanelAlertas } from "./PanelAlertas.js";
import { RegistroConsola } from "./RegistroConsola.js";
import { PanelHistorico } from "./PanelHistorico.js";

// 1. Creamos los sensores.
const temperatura = new Sensor("Temperatura", "°C", 25, 30);
const humedad = new Sensor("Humedad", "%", 50, 70);
const co2 = new Sensor("CO2", "ppm", 600, 1000);
const luminosidad = new Sensor("Luminosidad", "lux", 500, 800);
const presion = new Sensor("Presion", "hPa", 1013, 1020);

// 2. Creamos los observadores.
const panelPrincipal = new PanelPrincipal();
const panelAlertas = new PanelAlertas();
const registroConsola = new RegistroConsola();
const panelHistorico = new PanelHistorico();

// 3. Guardamos los sensores en una lista.
const sensores = [
    temperatura,
    humedad,
    co2,
    luminosidad,
    presion
];

// 4. Creamos las tarjetas en la interfaz gráfica.
if (typeof document !== "undefined") {

    const contenedor = document.getElementById("sensores");

    sensores.forEach(sensor => {

        const id = sensor.tipo.toLowerCase().replaceAll(" ", "-");

        const tarjeta = document.createElement("div");
        tarjeta.className = "sensor-card";

       
tarjeta.innerHTML = `
    <h3>${sensor.tipo}</h3>

    <p class="sensor-valor" id="valor-${id}">
        ${sensor.valor} ${sensor.unidad}
    </p>

    <p id="estado-${id}" class="estado-normal">
        Normal
    </p>

    <div class="control-valor">
        <label for="nuevo-valor-${id}">Nuevo valor:</label>

        <input
            type="number"
            id="nuevo-valor-${id}"
            step="any"
            value="${sensor.valor}"
        >

        <button type="button" data-actualizar="${id}">
            Actualizar
        </button>
    </div>

    <div class="controles-sensor">
        <p>Paneles activos:</p>

        <label>
            <input type="checkbox" data-observador="principal" checked>
            Panel principal
        </label>

        <label>
            <input type="checkbox" data-observador="alertas" checked>
            Alertas
        </label>

        <label>
            <input type="checkbox" data-observador="historico" checked>
            Historial
        </label>

        <label>
            <input type="checkbox" data-observador="registro" checked>
            Registro
        </label>
    </div>
`;


        contenedor.appendChild(tarjeta);
    });
}

// Controles para modificar los valores de los sensores.
sensores.forEach(sensor => {

    const id = sensor.tipo.toLowerCase().replaceAll(" ", "-");

    const boton = document.querySelector(
        `[data-actualizar="${id}"]`
    );

    const input = document.getElementById(`nuevo-valor-${id}`);

    boton.addEventListener("click", () => {

        const nuevoValor = Number(input.value);

        if (input.value.trim() === "" || !Number.isFinite(nuevoValor)) {
            alert("Ingresá un valor numérico válido.");
            return;
        }

        sensor.actualizarValor(nuevoValor);

    });

});


// 5. Asociamos los nombres con sus observadores.
const observadores = {
    principal: panelPrincipal,
    alertas: panelAlertas,
    historico: panelHistorico,
    registro: registroConsola
};

// 6. Suscribimos los observadores y conectamos las casillas.
sensores.forEach(sensor => {

    // Suscribimos todos los observadores inicialmente.
    Object.values(observadores).forEach(observador => {
        sensor.suscribir(observador);
    });

    // Buscamos la tarjeta del sensor.
    const id = sensor.tipo.toLowerCase().replaceAll(" ", "-");

    const tarjeta = document.querySelector(`#valor-${id}`)
        ?.closest(".sensor-card");

    if (!tarjeta) return;

    // Escuchamos los cambios de las casillas.
    tarjeta.querySelectorAll("[data-observador]").forEach(checkbox => {

        checkbox.addEventListener("change", () => {

            const observador = observadores[checkbox.dataset.observador];

            if (checkbox.checked) {
                sensor.suscribir(observador);

                observador.actualizar(sensor);
                
                console.log(
                    `[SUSCRIPCION] ${observador.constructor.name} activado para ${sensor.tipo}`
                );
            } else {
                sensor.desuscribir(observador);
                console.log(
                    `[DESUSCRIPCION] ${observador.constructor.name} desactivado para ${sensor.tipo}`
                );
            }

        });

    });

});


// 7. Mostramos las mediciones iniciales.
console.log("\n--- ACTUALIZACION DE SENSORES ---\n");

sensores.forEach(sensor => {
    sensor.actualizarValor(sensor.valor);
});