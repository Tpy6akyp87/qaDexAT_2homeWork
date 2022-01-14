package Tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTestAimshenik {
    @Test
    void successTest(){
        open("https://demoqa.com/automation-practice-form");
        //lastName
        //userEmail
        //class="col-md-9 col-sm-12"
        //userNumber
        //dateOfBirthInput  react-datepicker__month-select  May   react-datepicker__year-select   react-datepicker__day react-datepicker__day--016 react-datepicker__day--selected react-datepicker__day--weekend
        //subjects-auto-complete__control css-yk16xz-control
        //col-md-9 col-sm-12    hobbies-checkbox-1
        //uploadPicture
        //Current Address
        // css-1wa3eu0-placeholder  css-1uccc91-singleValue  Uttar Pradesh
        // css-yk16xz-control    css-1uccc91-singleValue    Lucknow

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
        $("[class=subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3]").setValue("Maths").pressEnter();
        $("[class=col-md-9 col-sm-12]").$("#hobbies-checkbox-1").click();
        //$("#uploadPicture").click();
        File file = $("#uploadPicture").uploadFile(new File("src/test/resources/vannila-dwarf.jpg"));
        $("#currentAddress").scrollTo().setValue("на работе");
        $("[class= css-1wy0on6]").$("#Uttar Pradesh").click();
        $("[class= css-yk16xz-control]").$("#Lucknow").click();

        $("#submit").scrollTo().click();
        $("#example-modal-sizes-title-lg").shouldBe(visible);

        $("[class=table table-dark table-striped table-bordered table-hover]").shouldHave(text("Anatoly"));




    }






}
