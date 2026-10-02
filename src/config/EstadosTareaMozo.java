package config;

public enum EstadosTareaMozo {
    TOMAR_PEDIDO,   /* El mozo tiene que ir a una mesa a levantar el pedido de los clientes y se los da a la cocina */
    RECOGER_PLATO,  /* El mozo tiene que ir a la cocina a buscar los platos de los clientes y se los da en la mesa */
    LIMPIAR_MESA    /* El mozo va a la mesa y la limpia para dejarla libre para usar nuevamente */
}
