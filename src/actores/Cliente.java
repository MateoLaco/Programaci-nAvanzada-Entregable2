package actores;

import lugares.Mesa;

public class Cliente {
    private int id;
    private Mesa mesaAsignada;

    Cliente(int id) {
        this.id = id;
    }

    public Mesa getMesaAsignada() {
        return mesaAsignada;
    }

    public void setMesaAsignada(Mesa mesaAsignada) {
        this.mesaAsignada = mesaAsignada;
    }
}
