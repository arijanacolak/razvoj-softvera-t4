package ba.unsa.etf.rs.tut4;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javax.swing.*;

import java.nio.Buffer;

@ExtendWith(ApplicationExtension.class)

class ControllerTest {
    
    @Start
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/artikal.fxml"));
        stage.setTitle("Kasa");
        stage.setScene(new Scene( root,550, 600));
        stage.setResizable(false);
        stage.show();
        stage.toFront();
    }

    @Test
    public void dodajArtikle (FxRobot robot) {
        Button dodaj;
        dodaj = robot.lookup("#dodaj").queryAs(Button.class);
        robot.clickOn("#text1");
        robot.write("HLB00,Hljeb,1.2");
        robot.clickOn("#dodaj");
        TextArea text2 = robot.lookup("#text2").queryAs(TextArea.class);

     /*   assertEquals("HLB00,Hljeb,1.2\n", text2.getText());
        ChoiceBox choiceB = robot.lookup("#choiceB").queryAs(ChoiceBox.class);
        assertNotNull(choiceB);
        //  Platform.runLater(() -> choiceB.show());
        robot.clickOn("HLB00");*/
    }



    @Test
    public void dodajNaRacun(FxRobot robot) {

    }
}