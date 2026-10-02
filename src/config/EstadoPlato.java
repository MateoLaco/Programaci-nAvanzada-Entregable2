package config;

public enum EstadoPlato {
    PEDIDO,     /* El plato recién fue pedido, ni siquiera lo tomó un mozo */
    CON_MOZO,   /* El plato está en manos del mozo */
    PENDIENTE,  /* El plato está en la cocina esperando a que lo tome un cocinero */
    COCINANDO,  /* El plato lo tiene un cocinero y lo está cocinando en este momento */
    PRONTO      /* El plato está pronto y esperando a un mozo */
}
