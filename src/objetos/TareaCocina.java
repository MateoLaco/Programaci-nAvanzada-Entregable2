package objetos;

public class TareaCocina {
    private final Pedido pedido;
    private final Plato plato;

    public TareaCocina(Pedido pedido, Plato plato){
        this.pedido = pedido;
        this.plato = plato;
    }

    public Pedido getPedido(){
        return this.pedido;
    }

    public Plato getPlato(){
        return this.plato;
    }
}
