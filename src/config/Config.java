package config;

public final class Config {
    /* Tiempo total de simulación */
    public static final int TIEMPO_SIMULACION = 60;

    /* Número de mesas (M) y de personas por mesa (P) */
    public static final int NUMERO_DE_MESAS = 6;
    public static final int PERSONAS_POR_MESA = 4;

    /* Número de mozos (Z), cocineros (C) y cajas (Y) */
    public static final int NUMERO_DE_MOZOS = 4;
    public static final int NUMERO_DE_COCINEROS = 4;
    public static final int NUMERO_DE_CAJAS = 2;

    /* Tiempos entre llegada de clientes al restaurante */
    public static final int TIEMPO_DE_LLEGADA_MIN = 1000;
    public static final int TIEMPO_DE_LLEGADA__MAX = 3000;

    /* Tiempos para elegir algo del menu */
    public static final int TIEMPO_PARA_ELEGIR_MIN = 1000;
    public static final int TIEMPO_PARA_ELEGIR_MAX = 3000;

    /* Tiempo que demoran los clientes en comer */
    public static final int TIEMPO_EN_COMER_MIN = 2000;
    public static final int TIEMPO_EN_COMER_MAX = 5000;

    private Config(){
    }
}