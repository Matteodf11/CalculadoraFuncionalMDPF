module com.mycompany.calculadorafuncionalmdpf {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.calculadorafuncionalmdpf to javafx.fxml;
    exports com.mycompany.calculadorafuncionalmdpf;
}
