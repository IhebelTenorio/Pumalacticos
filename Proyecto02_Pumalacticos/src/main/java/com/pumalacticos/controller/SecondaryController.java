package com.pumalacticos.controller;

import java.io.IOException;

import com.pumalacticos.OdinApp;

import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        OdinApp.setRoot("primary");
    }
}
