# RPG_Game - README

## Descripción

Este proyecto es un juego RPG de texto en el que los jugadores pueden controlar un guerrero, enfrentarse a enemigos y utilizar habilidades como atacar, defender y usar magia. La dificultad es configurable, y el juego utiliza un sistema de turnos para acciones de combate.

### Estructura del código

El juego cuenta con varias clases y funciones que controlan las diferentes mecánicas, como el combate, la recuperación de salud y magia, y la gestión de eventos dentro del juego.### output

Esta función imprime texto en la consola, simulando una salida gradual de caracteres para crear una experiencia más inmersiva. output acepta hasta cinco cadenas de texto y un estado, que representa diferentes opciones y mensajes de advertencia para el jugador en cada etapa del juego.

# Clases y Funciones

## Clase Warrior

La clase Warrior representa a un personaje de combate en el juego. Cada guerrero tiene atributos como salud, resistencia, fuerza, magia y defensa, y métodos para realizar ataques y habilidades.

### Funciones

- *Constructor Warrior(int healt, int resistance, int force, int magic, int defence)*  
   Inicializa un guerrero con valores específicos de salud, resistencia, fuerza, magia y defensa.
   
- *is_attacked(int damage, Warrior attacker)*  
   Calcula el daño que recibe el guerrero cuando es atacado. Toma en cuenta el ataque del oponente (attacker) y sus atributos de defensa y resistencia.
   
- *attack(int damage)*  
   Realiza un ataque básico al oponente, generando daño directo según la fuerza del guerrero.

- *defend()*  
   Activa la defensa del guerrero, que disminuye el daño recibido en el siguiente turno y recupera puntos de magia.

- *magic(String type_magic)*  
   Realiza una habilidad mágica. Dependiendo de type_magic, puede ser un ataque especial que causa daño adicional o una habilidad de curación que restaura la salud del guerrero.

---

## Clase RPG_Game

Esta clase representa el núcleo del juego y controla el flujo de la partida, alternando los turnos entre el héroe y el villano, y aplicando las acciones seleccionadas por cada uno.

### Funciones
#### output

Esta función imprime texto en la consola, simulando una salida gradual de caracteres para crear una experiencia más inmersiva. output acepta hasta cinco cadenas de texto y un estado, que representa diferentes opciones y mensajes de advertencia para el jugador en cada etapa del juego.

java
public static void output(String text_1, String text_2, String text_3, String text_4, String text_warning, int state);


#### Parámetros:
- text_1: Texto principal a mostrar.
- text_2, text_3, text_4: Textos adicionales opcionales.
- text_warning: Mensaje de advertencia opcional.
- state: Número que determina el tipo de entrada o salida de texto (por ejemplo, 0 para presionar enter, 1 para opciones de ataque y defensa).

- *Constructor RPG_Game()*  
   Inicializa el juego, configurando el héroe y el villano con valores base y estableciendo la dificultad.

- *start()*  
   Inicia el juego solicitando al jugador el nombre de su héroe y la dificultad deseada. Luego, llama a load_warriors para inicializar los personajes.

- *load_warriors()*  
   Configura los valores iniciales de salud, resistencia, fuerza, magia y defensa tanto para el héroe como para el villano. Los valores son ajustados en función de la dificultad seleccionada.

- *game()*  
   Controla el flujo principal del juego, ejecutando los turnos de cada personaje hasta que uno de ellos gane. Llama a los métodos de cada turno para gestionar las acciones.

- *menu()*  
   Despliega el menú de opciones del jugador en cada turno. Permite al jugador elegir entre atacar, defenderse, usar magia o ver sus estadísticas y las del villano.

- *attack_select()*  
   Ejecuta el ataque seleccionado por el jugador y aplica el daño correspondiente al villano.

- *defense_select()*  
   Activa la defensa del héroe para el próximo turno, aumentando su defensa y recuperando puntos de magia.

- *magic_select()*  
   Permite al jugador elegir una habilidad mágica, aplicando un ataque especial o curación según la selección del jugador.

- *villan_actions()*  
   Define las acciones del villano en su turno. El villano elige entre atacar, defenderse o usar habilidades de manera básica, según el estado del héroe.

- *process_actions()*  
   Aplica las acciones seleccionadas en el turno actual, tanto del héroe como del villano, y revisa si alguno ha perdido toda su salud para determinar si el juego ha terminado.

- *set_index_villan_difficulty()*  
   Ajusta los valores de estadísticas del villano en función de la dificultad seleccionada. Los valores se incrementan a medida que aumenta la dificultad.

- *enter_to_continue(boolean reset_Scanner, String visible_text)*  
   Pausa el juego hasta que el jugador presione "Enter", mostrando un mensaje (visible_text). Si reset_Scanner es true, reinicia el escáner de entrada.

- *clean_terminal()*  
   Limpia la terminal para mejorar la visibilidad entre turnos.

- *await(int time)*  
   Hace que el juego espere un tiempo específico (en milisegundos), para controlar la velocidad del flujo y permitir pausas naturales en la ejecución.


