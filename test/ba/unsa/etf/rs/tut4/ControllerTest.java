package ba.unsa.etf.rs.tut4;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
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
    public KeyCode enter = KeyCode.ENTER;
    @Test
    public void dodajArtikleTest (FxRobot robot) {
        Button dodaj = robot.lookup("#dodaj").queryAs(Button.class);
        robot.clickOn("#text1");
        robot.write("HLB00,Hljeb,1.20");
        robot.write("\nMLK11,Mlijeko,1.40");
        robot.clickOn("#dodaj");
        TextArea text2 = robot.lookup("#text2").queryAs(TextArea.class);
        assertEquals(true, text2.getText().contains("HLB00,Hljeb,1.2\nMLK11,Mlijeko,1.4"));
    }

    @Test
    public void dodajNaRacunTest (FxRobot robot) {
        Button dodaj = robot.lookup("#dodaj").queryAs(Button.class);
        robot.clickOn("#text1");
        robot.write("HLB00,Hljeb,1.20");

        robot.press(enter);
        robot.write("MLK11,Mlijeko,1.40");
        robot.write("\nKKA22,Kakao,2.35");
        robot.clickOn("#dodaj");
        robot.clickOn("#racun_kartica");
        ChoiceBox choiceB = robot.lookup("#choiceB").queryAs(ChoiceBox.class);
        assertNotNull(choiceB);
        Platform.runLater(() -> choiceB.show());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.clickOn("HLB00");
        Button dodajRacun = robot.lookup("#dodajRacun").queryAs(Button.class);

        Spinner spinner = robot.lookup("#spinner").queryAs(Spinner.class);
        assertNotNull(spinner);
        spinner.setEditable(true);
        robot.clickOn(spinner);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.eraseText(1);
        robot.write("2");
        robot.clickOn("#dodajRacun");
        TextArea aktuelni_racun = robot.lookup("#aktuelni_racun").queryAs(TextArea.class);
        //assertEquals(true, aktuelni_racun.getText().contains("HLB00 2 2.40\n\nUKUPNO 2.40\n"));
        assertEquals("HLB00 2 2.40\n\nUKUPNO 2.40\n", aktuelni_racun.getText());

        Platform.runLater(() -> choiceB.show());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.clickOn("KKA22");
        spinner.setEditable(true);
        robot.clickOn(spinner);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.eraseText(2);
        robot.write("1");
        robot.clickOn("#dodajRacun");
        //assertEquals(true, aktuelni_racun.getText().contains("HLB00 2 2.40\n\nUKUPNO 2.40\n"));
        assertEquals("HLB00 2 2.40\nKKA22 1 2.35\n\nUKUPNO 4.75\n", aktuelni_racun.getText());
    }

    @Test
    public void cijelaApp (FxRobot robot) {
        Button dodaj = robot.lookup("#dodaj").queryAs(Button.class);
        robot.clickOn("#text1");
        robot.write("HLB00,Hljeb,1.20");
        robot.clickOn("#dodaj");
        TextArea text2 = robot.lookup("#text2").queryAs(TextArea.class);
        assertEquals(true, text2.getText().contains("HLB00,Hljeb,1.2\n"));

        robot.clickOn("#racun_kartica");
     ChoiceBox choiceB = robot.lookup("#choiceB").queryAs(ChoiceBox.class);
        assertNotNull(choiceB);
          Platform.runLater(() -> choiceB.show());
          try {
              Thread.sleep(200);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
        robot.clickOn("HLB00");
          Button dodajRacun = robot.lookup("#dodajRacun").queryAs(Button.class);

        Spinner spinner = robot.lookup("#spinner").queryAs(Spinner.class);
        assertNotNull(spinner);
        spinner.setEditable(true);
        robot.clickOn(spinner);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.eraseText(1);
        robot.write("2");
        robot.clickOn("#dodajRacun");
          TextArea aktuelni_racun = robot.lookup("#aktuelni_racun").queryAs(TextArea.class);
        //assertEquals(true, aktuelni_racun.getText().contains("HLB00 2 2.40\n\nUKUPNO 2.40\n"));
        assertEquals("HLB00 2 2.40\n\nUKUPNO 2.40\n", aktuelni_racun.getText());
    }

}