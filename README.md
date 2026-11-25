# TP integrador 2 - Metodologia de Sistemas II

Codigo del punto de Refactoring (clase Videojuego).

- `src/refactoring/antes`: el codigo original de la consigna (solo se arreglaron los errores para que compile)
- `src/refactoring/despues`: el codigo refactorizado

Para correrlo (Java 17):

```
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out refactoring.antes.Main
java -cp out refactoring.despues.Main
```
