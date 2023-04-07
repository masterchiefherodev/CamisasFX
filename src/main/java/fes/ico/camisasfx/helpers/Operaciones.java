package fes.ico.camisasfx.helpers;

public class Operaciones {

    public static String calcularPrecioDeLista(int camisas, float precio) {
        return Float.toString(camisas * precio);
    }

    public static String calcularDescuento(int camisas, float precio) {
        if (camisas <= Descuentos.HASTA.getLimite()) {
            return Float.toString(precio * camisas * Descuentos.HASTA.getDescuento());
        } else if (camisas <= Descuentos.ENTRE.getLimite()) {
            return Float.toString(precio * camisas * Descuentos.ENTRE.getDescuento());
        }
        return Float.toString(precio * camisas * Descuentos.MASDE.getDescuento());
    }

    public static String calcularPrecioFinal(int camisas, float precio) {
        float precioLista = camisas * precio;
        float descuento;
        if (camisas <= Descuentos.HASTA.getLimite()) {
            descuento = precio * camisas * Descuentos.HASTA.getDescuento();
        } else if (camisas <= Descuentos.ENTRE.getLimite()) {
            descuento = precio * camisas * Descuentos.ENTRE.getDescuento();
        } else {
            descuento = precio * camisas * Descuentos.MASDE.getDescuento();
        }
        return Float.toString(precioLista - descuento);
    }
}
