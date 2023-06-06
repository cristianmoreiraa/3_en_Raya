# Proyecto  3 en Raya


¡Hola a todos!

Somos Jorge Usatorre y Cristian Moreira, dos entusiastas estudiantes de DAM1 (Desarrollo de Aplicaciones Multiplataforma). Estamos emocionados de anunciar que nos hemos embarcado en un emocionante proyecto: el desarrollo del juego "3 en Raya" utilizando el lenguaje Java y aplicando el patrón MVC (Modelo-Vista-Controlador).

El juego "3 en Raya" es un clásico que muchos de ustedes pueden recordar de su infancia. Nuestro objetivo es recrear esta experiencia en un entorno digital, aprovechando las capacidades del lenguaje Java y la estructura MVC para crear un juego interactivo y atractivo.

El patrón MVC, que significa Modelo-Vista-Controlador, es una forma de organizar el código de una aplicación para separar las responsabilidades y facilitar su mantenimiento y evolución. En nuestro caso, utilizaremos este patrón para dividir claramente las partes del juego: el modelo se encargará de la lógica y el estado del juego, la vista mostrará la interfaz gráfica al jugador y el controlador manejará las interacciones del usuario.

Estamos emocionados de poner en práctica nuestros conocimientos adquiridos en el curso y aplicarlos a un proyecto real. Además, esta será una excelente oportunidad para mejorar nuestras habilidades de programación y trabajar en equipo.

Esperamos crear un juego "3 en Raya" atractivo y divertido que pueda ser disfrutado por todos. Estamos comprometidos a trabajar arduamente y asegurarnos de que el juego sea de alta calidad y brinde una experiencia gratificante.

¡Estén atentos a futuras actualizaciones! Estamos seguros de que tendremos mucho progreso que compartir y esperamos que se unan a nosotros en esta emocionante aventura de desarrollo de juegos.

¡Gracias por su apoyo y nos vemos pronto!

Jorge Usatorre y Cristian Moreira

## Diagrama de Flujo

```mermaid
classDiagram
    class Leaderboard {
        +setVisible(boolean): void
    }
    class Game {
        +casilla1: JButton
        +casilla2: JButton
        +casilla3: JButton
        +casilla4: JButton
        +casilla5: JButton
        +casilla6: JButton
        +casilla7: JButton
        +casilla8: JButton
        +casilla9: JButton
    }
    class Juego {
        +realizarMovimiento(int, int): boolean
        +verificarGanador(): boolean
    }
    class controlerGame {
        +marcarCasilla(JButton): void
        +reiniciarJuego(): void
    }

    Leaderboard --> Game
    Game --> Juego
    controlerGame --> Game
    controlerGame --> Juego
```

# Diagrama de Secuencia


```mermaid
sequenceDiagram
    autonumber

    participant Leaderboard
    participant Game
    participant Juego
    participant controlerGame

    Leaderboard->>Game: new Game()
    Game->>Game: initComponents()
    Game->>Leaderboard: Game creado

    Leaderboard->>controlerGame: crearInstanciaJuego()
    controlerGame->>Juego: new Juego()
    Juego->>controlerGame: Juego creado
    controlerGame->>Leaderboard: Juego creado

    Leaderboard->>Game: setVisible(true)
    Game->>Leaderboard: Game visible

    Game->>Game: casilla1ActionPerformed()
    Game->>controlerGame: realizarMovimiento(casilla1)
    controlerGame->>Juego: realizarMovimiento(casilla1)
    Juego->>controlerGame: Movimiento realizado
    controlerGame->>Game: Movimiento realizado
    Game->>Leaderboard: Actualizar interfaz

    Game->>Game: casilla8ActionPerformed()
    Game->>controlerGame: realizarMovimiento(casilla8)
    controlerGame->>Juego: realizarMovimiento(casilla8)
    Juego->>controlerGame: Movimiento realizado
    controlerGame->>Game: Movimiento realizado
    Game->>Leaderboard: Actualizar interfaz

    alt Ganador encontrado
        Juego-->>Juego: Verificar ganador
        Juego-->>controlerGame: Ganador encontrado
        controlerGame->>Game: Ganador encontrado
        Game->>Leaderboard: Ganador encontrado
    else Empate encontrado
        Juego-->>Juego: Verificar empate
        Juego-->>controlerGame: Empate encontrado
        controlerGame->>Game: Empate encontrado
        Game->>Leaderboard: Empate encontrado
    end
Game->>Game: casilla1ActionPerformed()
    Game->>controlerGame: realizarMovimiento(casilla1)
    controlerGame->>Juego: realizarMovimiento(casilla1)
    Juego->>controlerGame: Movimiento realizado
    controlerGame->>Game: Movimiento realizado
    Game->>Leaderboard: Actualizar interfaz

    Game->>controlerGame: reiniciarJuego()
    controlerGame->>Juego: reiniciarJuego()
    Juego->>controlerGame: Juego reiniciado
    controlerGame->>Game: Juego reiniciado
    Game->>Leaderboard: Juego reiniciado

```

