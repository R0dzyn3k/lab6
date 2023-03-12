package pl.edu.wsiz.lab3;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    @FXML private TableColumn col_id;
    @FXML private TableColumn col_imie;
    @FXML private TableColumn col_nazwisko;
    @FXML private TableView tabela;
    @FXML private TextField inputNazwisko;
    @FXML private TextField inputImie;
    @FXML private Button buttonDodajOsoba;

    @FXML public void initialize() {
        try {
            col_id.setCellValueFactory( new PropertyValueFactory<>("id"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        col_imie.setCellValueFactory( new PropertyValueFactory<>("imie"));
        col_nazwisko.setCellValueFactory( new PropertyValueFactory<>("nazwisko"));

    
    ObservableList<Osoba> lista=FXCollections.observableArrayList();

        lista.add(new Osoba("Adam", "Małysz"));
        lista.add(new Osoba("Damian", "Kowalski"));
        lista.add(new Osoba("Jakub", "Szczepan"));

    //dodaj elementy listy
    tabela.getItems().addAll(lista);
    }

    @FXML
    private void dodajObobe(){
        String firstName = inputImie.getText();
        String lastName = inputNazwisko.getText();
        if(firstName.length() < 3 || lastName.length() < 3)
            return;

        tabela.getItems().add(new Osoba(firstName, lastName));

        inputImie.setText("");
        inputNazwisko.setText("");

    }

}
