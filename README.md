TP Macowins
===========

Este es el código base del TP de Macowins, cuyo enunciado [se puede encontrar acá](https://docs.google.com/document/d/1mjWKl9YH9Bb39iIUl1bQj_xhx_-CjCAMpcAXRqKhVjU/edit#heading=h.ijowozxsedv6)

# ¿Cómo resolver el TP?

1. Leé el enunciado atentamente
2. Tratá de resolverlo en orden
3. Mientras vas implementando el código que resuelve el problema, codificá casos de prueba que validen la solución. Ya te dejamos algunos para que completes y te sirvan como punto de partida, pero no son suficientes y deberás agregar los tuyos.

# ¿Cómo configurar el IDE?

 1. Tabular con dos espacios
 2. Instalar y configurar Checkstyle
 3. Usar fin de linea unix


# ¿Cómo ejecutar los tests?

```
mvn test
```

# ¿Cómo validar el proyecto?

```
mvn verify
```

Este comando hará lo siguiente:

 1. Ejecutará los tests
 2. Validará las convenciones de formato mediante checkstyle
 3. Detectará la presencia de (ciertos) code smells
 4. Validará la cobertura del proyecto

# Entrega del proyecto

Para entregar el proyecto, crear un tag llamado `entrega-final`. Es importante que antes de realizarlo se corra la validación
explicada en el punto anterior. Se recomienda hacerlo de la siguiente forma:

```
mvn verify && git tag entrega-final && git push origin HEAD --tags
```
