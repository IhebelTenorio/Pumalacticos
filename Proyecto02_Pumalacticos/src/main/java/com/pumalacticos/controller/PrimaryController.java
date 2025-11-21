package com.pumalacticos.controller;

import java.io.IOException;

import com.pumalacticos.OdinApp;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        OdinApp.setRoot("secondary");
    }
}
