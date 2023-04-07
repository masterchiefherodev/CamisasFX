package fes.ico.camisasfx.helpers;

public enum Descuentos {
    HASTA(2, 0.00f),
    ENTRE(5, 0.05f),
    MASDE(-1, 0.08f);

    private final int limite;
    private final float descuento;

    private Descuentos(int limite, float descuento) {
        this.limite = limite;
        this.descuento = descuento;
    }

    public int getLimite() {
        return limite;
    }

    public float getDescuento() {
        return descuento;
    }
}
