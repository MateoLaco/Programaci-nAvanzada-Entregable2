package config;

public enum EstadosMesas {
    LIBRE,                      /* No tiene clientes y puede ser asignada */
    OCUPADA,                    /* Ya se sentaron los clientes en la mesa pero están eligiendo del menu */
    ESPERANDO_MOZO,             /* Todos eligieron el menu y ahora están esperando al mozo */
    ESPERANDO_COMIDA,           /* El pedido fue tomado, se está esperando a que se prepare */
    COMIENDO,                   /* Todos fueron servidos y están comiendo */
    ESPERANDO_LIMPIEZA          /* Los clientes ya se fueron, pero la mesa todavía no volvió a estar disponible */
}
