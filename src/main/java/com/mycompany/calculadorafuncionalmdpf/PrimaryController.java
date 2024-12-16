package com.mycompany.calculadorafuncionalmdpf;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class PrimaryController {

    @FXML
    private TextField textfieldcalculadora;
   

    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void botoncSetOnAction(ActionEvent event) {
        textfieldcalculadora.setText("0");
        Digito = false;

    }

    @FXML
    private void clickbotondividir(ActionEvent event) {
        evaluarOperador("/");
    }

    @FXML
    private void clickbotonmultiplicar(ActionEvent event) {
        evaluarOperador("*");
    }

    @FXML
    private void clickbotonrestar(ActionEvent event) {
        evaluarOperador("-");
    }

    @FXML
    private void clickboton7(ActionEvent event) {
        digitoPantalla("7");
    }

    @FXML
    private void clickboton8(ActionEvent event) {
        digitoPantalla("8");
    }

    @FXML
    private void clickboton9(ActionEvent event) {
        digitoPantalla("9");
    }

    @FXML
    private void clickbotonsumar(ActionEvent event) {
        evaluarOperador("+");
    }

    @FXML
    private void clickboton4(ActionEvent event) {
        digitoPantalla("4");
    }

    @FXML
    private void clickboton1(ActionEvent event) {
        digitoPantalla("1");
    }

    @FXML
    private void clickboton0(ActionEvent event) {
        digitoPantalla("0");
    }

    @FXML
    private void clickboton2(ActionEvent event) {
        digitoPantalla("2");
    }

    @FXML
    private void clickbotoncoma(ActionEvent event) {
        if (!Punto && !Digito) {
            textfieldcalculadora.setText("0.");
            Digito = true;
        } else if (!Punto) {
            String valActual = textfieldcalculadora.getText();
            textfieldcalculadora.setText(valActual + ".");
        }
        Punto = true;
    }

    @FXML
    private void clickbotonresultado(ActionEvent event) {
        evaluarOperador("=");
    }

    @FXML
    private void clickboton3(ActionEvent event) {
        digitoPantalla("3");
    }

    @FXML
    private void clickboton5(ActionEvent event) {
        digitoPantalla("5");
    }

    @FXML
    private void clickboton6(ActionEvent event) {
        digitoPantalla("6");
    }

    private boolean Digito = false;
    private boolean Punto = false;
    private int numOperandos = 0;
    private double Operando1, Operando2;
    private char Operador = ' ';

    private void digitoPantalla(String numero) {

        if (!Digito) {
            textfieldcalculadora.setText("");
            Punto = false;
        }

        String valActual = textfieldcalculadora.getText();
        textfieldcalculadora.setText(valActual + numero);
        Digito = true;
    }

    private void evaluarOperador(String Operador) {
        if (Digito) {
            numOperandos++;
        }

        if (numOperandos == 1) {
            Operando1 = Double.parseDouble(textfieldcalculadora.getText());
        }
        if (numOperandos == 2) {
            Operando2 = Double.parseDouble(textfieldcalculadora.getText());
            switch (this.Operador) {
                case '+':
                    Operando1 = Operando1 + Operando2;
                    break;
                case '-':
                    Operando1 = Operando1 - Operando2;
                    break;
                case '/':
                    Operando1 = Operando1 / Operando2;
                    break;
                case '*':
                    Operando1 = Operando1 * Operando2;
                    break;
                case '=':
                    Operando1 = Operando2;
                    break;
                default:
                    throw new AssertionError();
            }
            textfieldcalculadora.setText(String.valueOf(Operando1));
            numOperandos = 1;
            Punto = false;
        }
        Digito = false;
        this.Operador = Operador.charAt(0);

    }

}
