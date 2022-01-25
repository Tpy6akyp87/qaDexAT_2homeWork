package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTestAimshenik {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize="1920x1080";
    }

    @Test
    void successTest(){
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Imshenik");
        $("#lastName").setValue("Anatoly");
        $("#userEmail").setValue("ichi111@yandex.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("9268885522");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__month-select]").click();
        $(byText("May")).click();
        $("[class=react-datepicker__year-select]").click();
        $(byText("1987")).click();
        $(byText("16")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        File file =new File("src/test/resources/vannila-dwarf.jpg");
        Selenide.$(byId("uploadPicture")).uploadFile(file);
        $("#currentAddress").setValue("на работе");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Lucknow").pressEnter();

        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);

        $("[class=table-responsive]").shouldHave(text("Imshenik"));
        $("[class=table-responsive]").shouldHave(text("Anatoly"));
        $("[class=table-responsive]").shouldHave(text("ichi111@yandex.ru"));
        $("[class=table-responsive]").shouldHave(text("Male"));
        $("[class=table-responsive]").shouldHave(text("9268885522"));
        $("[class=table-responsive]").shouldHave(text("16 May,1987"));
        $("[class=table-responsive]").shouldHave(text("Maths"));
        $("[class=table-responsive]").shouldHave(text("Reading"));
        $("[class=table-responsive]").shouldHave(text("на работе"));
        $("[class=table-responsive]").shouldHave(text("Uttar Pradesh"));
        $("[class=table-responsive]").shouldHave(text("Lucknow"));
        $("[class=table-responsive]").shouldHave(text("vannila-dwarf.jpg"));

    }

}
