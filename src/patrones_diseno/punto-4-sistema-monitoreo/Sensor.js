
export class Sensor {

    constructor(tipo, unidad, valorInicial, umbral) {
        this.tipo = tipo;
        this.unidad = unidad;
        this.valor = valorInicial;
        this.umbral = umbral;
        this.observadores = [];
    }

    suscribir(observador) {
        if (!this.observadores.includes(observador)) {
            this.observadores.push(observador);
        }
    }

    desuscribir(observador) {
        this.observadores = this.observadores.filter(
            obs => obs !== observador
        );
    }

    notificar() {
        this.observadores.forEach(observador => {
            observador.actualizar(this);
        });
    }

    actualizarValor(nuevoValor) {
        if (typeof nuevoValor !== "number" || !Number.isFinite(nuevoValor)) {
            throw new Error("El valor del sensor debe ser numerico");
        }

        if (nuevoValor === this.valor) {
        return;
    }

        this.valor = nuevoValor;
        this.notificar();
    }

}
