# Práctica 1 Modelado y Programación 
## Equipo: Pumalacticos
- Ihebel Luro Tenorio
- Danjiro Cisneros Álvarez
- Oscar Manuel Teniente Ornelas

**Objetivo:** El objetivo de esta práctica es implementar adecuadamente los patrones Strategy y Observer en la resolución del problema propuesto. Su solución debe estar integrada en un solo diagrama de clases así como una sola implementación.

### Diagrama:
Se oganiza en 3 ramas principales: Usuario (Usr), Simulador (SubsSimulator) y servicios (Service).
- **SubsSimulator:** Clase Principal donde el progama crea la simulación. Crea los Usuarios *(Usr)* y simula el paso de los meses *updateUsers()*, indicando cuando se deben hacer los cobros y enviar las notificaciones a los Usuarios. (La lista de los usuarios es estática *[users: static List<Usr>]*)
-  **Usr:** Viene siendo los usuarios, representa el Cliente. Implementa la interfaz *Observer*, donde cada usuario gestiona su dinero(*money*), su nombre(*usrName) y las suscripciones en las que está (*services: HashMap<String, Service>*)
-  **Service:** (Interfaz) Define las operaciones para conocer el precio (*getPrice*), recomendación (*getRecomendation*) y el estado de suscripción (*getStatus*,*setStatus*). Funciona como el **SUJETO** en Observer
-  Los servicios (*Memeflix,Momazon,Spootify,HVO,Thisney*): son las implementaciones concretas de la interfaz *Service*. Cada una representa una plataforma con sus propios precios y sus recomendaciones. Se encargan de notificar a sus suscriptores (*Usr*) sobre cobros mensuales o cambios de cobros.

 **Flujo del Diagrama:**
 1. La clase **SubsSimulator** inicializa a todos los usuarios (**Usr**) con su dinero inicial (ya dado)
 2. Los usuarios **Usr** se suscriben a diferentes servicios (*Memeflix,Momazon,Spootify,HVO,Thisney*) usando *subscribe(Service service)* Al suscribirse, el usuario **(Observer)** queda registrado en la lista de suscriptores del servicio **(Sujeto)**
 3. Cada mes se implementa *updateUsers()*, que a su vez le pide a cada servicio que notifique a sus usuarios.
 4. Cada servicio, al recibir la orden, invoca el método *Update()* de cada *Usr* tiene registrado.
 5. *Usr* reacciona a esta notificación y ejecuta el método *cashIn(Service service)* para descontar el dinero de su cuenta y procesa el mensaje.

### Patrones de Diseño:
**OBSERVER:** Es fundamental para la comunicación entre los servicios de streaming y los usuarios. Permite que los servicios notifiquen automáticamente a todos sus suscriptores cuando ocurre un evento (como el cobro mensual).
- Sujeto: La interfaz *Service* y sus implementaciones concretas (Memeflix, Thisney, etc.). Son los objetos que tienen la información y cuyo estado interesa a otros. Mantienen una lista de sus observadores.
- Observador (Observer): La clase *Usr*. Es el objeto que desea ser notificado de los cambios en el Sujeto. Implementa el método Update() para reaccionar cuando recibe una notificación del servicio.
Se usa cada mes cuando un servicio de streaming realiza el cobro. El servicio no le cobra directamente al usuario, sino que "publica" una notificación, y todos los usuarios suscritos (sus observadores) reaccionan a ella pagando su mensualidad. También se utiliza para enviar mensajes de bienvenida, cancelación o recomendaciones.

**STRATEGY:** Permite definir una familia de algoritmos, encapsular cada uno de ellos y hacerlos intercambiables. En esta práctica, se utiliza para manejar las diferentes formas de cobro que tiene cada servicio.
- Contexto (Context): Cada clase de servicio (Memeflix, HVO, etc.) actúa como el contexto. Es la clase que necesita ejecutar un algoritmo de cobro.
- Estrategia (Strategy): La "estrategia" es el algoritmo de cobro en sí mismo. *CobroStrategy* la lógica de cobro está encapsulada dentro del método *getPrice()* de cada clase de servicio, lo que cumple con el propósito del patrón. Cada servicio decide cuánto cobrar basándose en su estado interno (el plan del usuario, el número de meses suscrito, etc.).\

El patrón se aplica en la lógica de precios de cada servicio:
- Memeflix: Su estrategia de cobro depende del número de dispositivos contratados ($120, $170 o $200).
- Momazon/Spootify: Su estrategia cambia entre un plan normal/gratuito y uno premium, cada uno con un precio distinto.
-Thisney/HVO: Su estrategia es dinámica y depende del tiempo. Tienen un precio promocional durante los primeros meses y luego cambia a una tarifa estándar
Cada servicio ejecuta su propia "estrategia" de cobro sin que el usuario tenga que conocer los detalles, cumpliendo así el principio de encapsular algoritmos que varían.

### Estructura de Datos:
- **Listas(List<Usr>):** Se utiliza para guardar los usuarios en la clase principal (SubsSimulator/Classname).
- **HashMaps(HashMap<String, Service>):** Se utilizó un HashMap en la clase Usr para gestionar las suscripciones activas de un usuario. La clave es el identificador del servicio (String) y el valor es el objeto Service correspondiente.









