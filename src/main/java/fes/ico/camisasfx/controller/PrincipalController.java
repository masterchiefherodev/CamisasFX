package fes.ico.camisasfx.controller;

import fes.ico.camisasfx.helpers.Operaciones;
import fes.ico.camisasfx.helpers.Tipos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {

    @FXML
    private Button btnGenerar;

    @FXML
    private TextField tfdDescuentoCasualML;

    @FXML
    private TextField tfdDescuentoFormalML;

    @FXML
    private TextField tfdDescuentoMC;

    @FXML
    private TextField tfdNumeroCasualML;

    @FXML
    private TextField tfdNumeroFormalML;

    @FXML
    private TextField tfdNumeroMC;

    @FXML
    private TextField tfdPrecioFinalCasualML;

    @FXML
    private TextField tfdPrecioFinalFormalML;

    @FXML
    private TextField tfdPrecioFinalMC;

    @FXML
    private TextField tfdPrecioListaCasualML;

    @FXML
    private TextField tfdPrecioListaFormalML;

    @FXML
    private TextField tfdPrecioListaMC;

    @FXML
    private TextField tfdTotalDescuento;

    @FXML
    private TextField tfdTotalPrecioFinal;

    @FXML
    private TextField tfdTotalPrecioLista;

    @FXML
    private TextField tfdTotalNumero;

    private int numeroMangaCorta = 0;
    private int numeroFormalMangaLarga = 0;

    private int numeroCasualMangaLarga = 0;

    @FXML
    void generarCSV(ActionEvent event) {

    }

    @FXML
    void setDatosCasualMangaLarga(KeyEvent event) {
        String numeroDesdeUI = tfdNumeroCasualML.getText();
        try {
            numeroCasualMangaLarga = Integer.parseInt(numeroDesdeUI);
            //Precio de lista
            tfdPrecioListaCasualML.setText("$" + Operaciones.calcularPrecioDeLista(numeroCasualMangaLarga, Tipos.CASUAL_ML.getPrecio()));
            // Descuento
            tfdDescuentoCasualML.setText("$" + Operaciones.calcularDescuento(numeroCasualMangaLarga, Tipos.CASUAL_ML.getPrecio()));
            // Precio final
            tfdPrecioFinalCasualML.setText("$" + Operaciones.calcularPrecioFinal(numeroCasualMangaLarga, Tipos.CASUAL_ML.getPrecio()));
        } catch (Exception e) {
            numeroCasualMangaLarga = 0;
            tfdNumeroCasualML.setText("");
            tfdPrecioListaCasualML.setText("");
            tfdDescuentoCasualML.setText("");
            tfdPrecioFinalCasualML.setText("");
        }
        llenarTotal();
    }

    @FXML
    void setDatosFormalMangaLarga(KeyEvent event) {
        String numeroDesdeUI = tfdNumeroFormalML.getText();
        try {
            numeroFormalMangaLarga = Integer.parseInt(numeroDesdeUI);
            //Precio de lista
            tfdPrecioListaFormalML.setText("$" + Operaciones.calcularPrecioDeLista(numeroFormalMangaLarga, Tipos.FORMAL_ML.getPrecio()));
            // Descuento
            tfdDescuentoFormalML.setText("$" + Operaciones.calcularDescuento(numeroFormalMangaLarga, Tipos.FORMAL_ML.getPrecio()));
            // Precio final
            tfdPrecioFinalFormalML.setText("$" + Operaciones.calcularPrecioFinal(numeroFormalMangaLarga, Tipos.FORMAL_ML.getPrecio()));
        } catch (Exception e) {
            numeroFormalMangaLarga = 0;
            tfdNumeroFormalML.setText("");
            tfdPrecioListaFormalML.setText("");
            tfdDescuentoFormalML.setText("");
            tfdPrecioFinalFormalML.setText("");
        }
        llenarTotal();
    }

    @FXML
    void setDatosMangaCorta(KeyEvent event) {
        String numeroDesdeUI = tfdNumeroMC.getText();
        try {
            numeroMangaCorta = Integer.parseInt(numeroDesdeUI);
            //Precio de lista
            tfdPrecioListaMC.setText("$" + Operaciones.calcularPrecioDeLista(numeroMangaCorta, Tipos.MANGA_CORTA.getPrecio()));
            // Descuento
            tfdDescuentoMC.setText("$" + Operaciones.calcularDescuento(numeroMangaCorta, Tipos.MANGA_CORTA.getPrecio()));
            // Precio final
            tfdPrecioFinalMC.setText("$" + Operaciones.calcularPrecioFinal(numeroMangaCorta, Tipos.MANGA_CORTA.getPrecio()));
        } catch (Exception e) {
            numeroMangaCorta = 0;
            tfdNumeroMC.setText("");
            tfdPrecioListaMC.setText("");
            tfdDescuentoMC.setText("");
            tfdPrecioFinalMC.setText("");
        }
        llenarTotal();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        desabilitarElementos();
    }

    private void desabilitarElementos() {
        this.tfdPrecioListaMC.setEditable(false);
        this.tfdPrecioListaFormalML.setEditable(false);
        this.tfdPrecioListaCasualML.setEditable(false);
        this.tfdDescuentoCasualML.setEditable(false);
        this.tfdDescuentoFormalML.setEditable(false);
        this.tfdDescuentoMC.setEditable(false);
        this.tfdPrecioFinalCasualML.setEditable(false);
        this.tfdPrecioFinalFormalML.setEditable(false);
        this.tfdPrecioFinalMC.setEditable(false);
        this.tfdTotalDescuento.setEditable(false);
        this.tfdTotalPrecioFinal.setEditable(false);
        this.tfdTotalPrecioLista.setEditable(false);
        this.tfdTotalNumero.setEditable(false);
    }

    public void llenarTotal() {
        tfdTotalNumero.setText(Integer.toString(numeroMangaCorta + numeroCasualMangaLarga + numeroFormalMangaLarga));
        tfdTotalPrecioLista.setText("$" + calcularTotalPrecioLista());
    }

    public String calcularTotalPrecioLista() {
        float mangaCortaPrecioLista = 0.0f;
        float casualMangaLargaPrecioLista = 0.0f;
        float formalMangaLargaPrecioLista = 0.0f;
        if (!tfdPrecioListaMC.getText().equals("")) {
            mangaCortaPrecioLista = Float.parseFloat(tfdPrecioListaMC.getText().replace("$", ""));
        }

        if (!tfdPrecioListaCasualML.getText().equals("")) {
            casualMangaLargaPrecioLista = Float.parseFloat(tfdPrecioListaCasualML.getText().replace("$", ""));
        }

        if (!tfdPrecioListaFormalML.getText().equals("")) {
            formalMangaLargaPrecioLista = Float.parseFloat(tfdPrecioListaFormalML.getText().replace("$", ""));
        }

        return Float.toString(mangaCortaPrecioLista + casualMangaLargaPrecioLista + formalMangaLargaPrecioLista);
    }

}
