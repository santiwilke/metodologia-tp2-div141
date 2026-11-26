//OBJETIVO
class MedioDePago {
    pagar(montoTotal, huesped) {
        throw new Error("El método pagar() debe ser implementado por el Adaptador");
    }
}

//ADAPTADOR
class AdaptadorTarjeta extends MedioDePago {
    constructor(tarjetaCredito) {
        super();
        this.tarjeta = tarjetaCredito; 
    }
    // Implementación del método unificado
    pagar(montoTotal, huesped) {
        const numeroTarjeta = huesped.numeroTarjeta;
        
        console.log(`[AdaptadorTarjeta] Iniciando validación para la tarjeta: ${numeroTarjeta}`);
        
        const limiteValido = this.tarjeta.validarLimite(montoTotal, numeroTarjeta);
        
        if (limiteValido) {
            console.log(`[AdaptadorTarjeta] Límite aprobado. Autorizando cargo...`);
            return this.tarjeta.autorizarCargo(montoTotal, numeroTarjeta);
        } else {
            console.log(`[AdaptadorTarjeta] Fondos insuficientes.`);
            return false;
        }
    }
}

//ADAPTADOR
class AdaptadorBilletera extends MedioDePago {
    constructor(billeteraVirtual) {
        super();
        this.billetera = billeteraVirtual; 
    }

    // Implementación del método unificado
    pagar(montoTotal, huesped) {
        const emailHuesped = huesped.email;
        
        console.log(`[AdaptadorBilletera] Iniciando pago con billetera virtual para: ${emailHuesped}`);
        
        // Llamamos al método específico de la billetera virtual
        return this.billetera.pagarConEmail(emailHuesped, montoTotal);
    }
}

// ==========================================
// 3. EJEMPLO DE USO
// ==========================================

// Esto es solo una simulacion para mostrar como lo usaria la clase Reserva.
 
//ADAPTABLES
class TarjetaCredito {
    validarLimite(monto, numeroTarjeta) { return monto <= 1000; }
    autorizarCargo(monto, numeroTarjeta) { return true; }
}
class BilleteraVirtual {
    pagarConEmail(email, monto) { return true; }
}

const huesped = { nombre: "Juan", email: "juan@mail.com", numeroTarjeta: "1234-5678" };

// Instanciamos las clases viejas
const tarjetaVisa = new TarjetaCredito();
const mercadoPago = new BilleteraVirtual();

// Creamos los adaptadores (Envolviendo las clases viejas)
const pagoConTarjeta = new AdaptadorTarjeta(tarjetaVisa);
const pagoConBilletera = new AdaptadorBilletera(mercadoPago);

// La Reserva solo llama a "pagar", no le importa qué adaptador es.
// (Simulando el método pagarCon(medio) de la clase Reserva)
console.log("--- Pagando con Tarjeta ---");
pagoConTarjeta.pagar(500, huesped);

console.log("\n--- Pagando con Billetera ---");
pagoConBilletera.pagar(500, huesped);