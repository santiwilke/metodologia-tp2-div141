# TP integrador 2 - Metodologia de Sistemas II

## Sistema de gestión de transacciones bancarias (Punto 1)

El sistema usa el patrón **Strategy** para elegir entre depósito, extracción y transferencia. La operación se puede cambiar antes de confirmar. En el [README del punto 1](punto-1-sistema-de-gestion/README.md) están las instrucciones de ejecución, el [diagrama UML](punto-1-sistema-de-gestion/uml/transacciones.png) y la [demostración en consola](punto-1-sistema-de-gestion/demo-consola.png).

## Sistema de Monitoreo Ambiental (Punto 4)

Implementación del sistema de monitoreo ambiental utilizando el patrón de diseño Observer.

Para ejecutar el proyecto (Node.js):

```bash
node servidor.js
```

Luego, abrir en el navegador:

```text
http://localhost:3000
```


## Refactoring

Codigo del punto de Refactoring (clase Videojuego).

- `src/refactoring/antes`: el codigo original de la consigna (solo se arreglaron los errores para que compile)
- `src/refactoring/despues`: el codigo refactorizado

Para correrlo (Java 17):

```
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out refactoring.antes.Main
java -cp out refactoring.despues.Main
```
