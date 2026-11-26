
import { createServer } from "node:http";
import { readFile } from "node:fs/promises";
import { join } from "node:path";

const puerto = 3000;

// Archivos que puede solicitar el navegador.
const archivos = {
    "/": "public/index.html",
    "/index.html": "public/index.html",
    "/styles.css": "public/styles.css",

    // Archivo principal.
    "/main.js": "main.js",

    // Clases del sistema Observer.
    "/Sensor.js": "Sensor.js",
    "/PanelPrincipal.js": "PanelPrincipal.js",
    "/PanelAlertas.js": "PanelAlertas.js",
    "/RegistroConsola.js": "RegistroConsola.js",
    "/PanelHistorico.js": "PanelHistorico.js"
};

const servidor = createServer(async (req, res) => {

    try {

        const rutaArchivo = archivos[req.url];

        if (!rutaArchivo) {
            res.writeHead(404);
            res.end("Archivo no encontrado");
            return;
        }

        const archivo = join(process.cwd(), rutaArchivo);
        const contenido = await readFile(archivo);

        const extension = rutaArchivo.split(".").pop();

        const tipos = {
            html: "text/html; charset=utf-8",
            css: "text/css; charset=utf-8",
            js: "text/javascript; charset=utf-8"
        };

        res.writeHead(200, {
            "Content-Type": tipos[extension] || "text/plain"
        });

        res.end(contenido);

    } catch (error) {

        console.error(error);

        res.writeHead(404);
        res.end("No se pudo encontrar el archivo");
    }
});

servidor.listen(puerto, () => {
    console.log(`Servidor iniciado en http://localhost:${puerto}`);
});
