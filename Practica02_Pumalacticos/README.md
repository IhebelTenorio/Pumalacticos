# Práctica 02 - Pumalacticos

## Integrantes
- *321671958*: Cisneros Álvarez Danjiro
- *422083399*: Teniente Ornelas Oscar Manuel
- *422109167* : Tenorio Reyes Ihebel Luro

## Java y Compilación
Esta práctica fue hecha con Java 17 y se compila con los siguientes
comandos (en Linux): 
- javac -d . src/**/*.java java
- pizzabot.Pizzabot

## Patrones de Diseño
Se implementaron los patrones State, Template y Decorator de la siguiente forma:
- **State**: Ya que el robot va haciendo cosas diferentes, cambia su estado interno, por lo tanto aquí implementamos State.
- **Template**: Como las pizas se hacen siguiendo mas o menos la misma forma, se pueden delegar dichos pasos en Template.
- **Decorator**: Ya que los helados pueden tener distintos agregados según un helado base, decorator es la mejor opcion para esto.
