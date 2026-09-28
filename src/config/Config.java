package config;

public final class Config {
    /* Tiempo total de simulación */
    public static final int T = 60;

    /* Número de mesas (M) y de personas por mesa (P) */
    public static final int M = 6;
    public static final int P = 4;

    /* Número de mozos (Z), cocineros (C) y cajas (Y) */
    public static final int Z = 4;
    public static final int C = 4;
    public static final int Y = 2;

    /* Tiempos entre llegada de clientes al restaurante */
    public static final int TP_MIN = 1000;
    public static final int TP_MAX = 3000;

    /* Tiempos para elegir algo del menu */
    public static final int TM_MIN = 1000;
    public static final int TM_MAX = 3000;

    /* Tiempo que demoran los clientes en comer */
    public static final int TQ_MIN = 2000;
    public static final int TQ_MAX = 5000;

    private Config(){
    }
}