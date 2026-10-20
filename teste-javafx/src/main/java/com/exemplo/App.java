package com.exemplo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {
    
    private final int GRID_SIZE = 10;

    @Override
    public void start(Stage stage) {

        /* V/H Boxes / Labels
        Label label = new Label("Clique:");
        Button botao = new Button("Aqui");
        HBox hbox = new HBox(10, label, botao); // espaçamento 10
        hbox.setAlignment(Pos.CENTER); // import javafx.geometry.Pos
        stage.setScene(new Scene(hbox, 400, 300));
        */

        //GRID
        GridPane grid = new GridPane(2, 2);
        //grid.setGridLinesVisible(true);
        
        for (int i = 0; i < GRID_SIZE; i++)                     //for para adicionar os botões nas linhas (i)/colunas (j)
            for (int j = 0; j < GRID_SIZE; j++) {
                int coluna = j;
                int linha = i;
                char letra = (char)('A' + coluna);
                Button botao = new Button(" ");
                botao.setPrefSize(50, 50);
                botao.setOnAction(e -> botao.setText("" + letra + (linha + 1)));   //Ativa cada botão -> morre com o loop, mas o grid salva
                grid.add(botao, coluna, linha);                                //Adiciona botão .add(node, coluna, linha) do grid
            }

        stage.setScene(new Scene(grid, 500, 500));
        stage.setTitle("Teste JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}