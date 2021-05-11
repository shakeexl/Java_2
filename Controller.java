package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    TextField msgField;

    @FXML
    TextArea mainTextArea;

    public void clickSendBtn(ActionEvent actionEvent) {
        mainTextArea.appendText(msgField.getText() + "\n");
        msgField.clear();
    }
}