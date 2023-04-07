package fes.ico.camisasfx.helpers;

public enum Tipos {
    MANGA_CORTA("Camisa de manga corta", 190.0f),
    CASUAL_ML("Camisa casual de manga larga", 230.0f),
    FORMAL_ML("Camisa formal de manga larga", 310.0f);

    private final String nombreTipo;
    private final float precio;

    private Tipos(String nombreTipo, float precio) {
        this.nombreTipo = nombreTipo;
        this.precio = precio;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public float getPrecio() {
        return precio;
    }
}
