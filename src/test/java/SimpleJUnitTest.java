import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.TypeOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SimpleJUnitTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Oksana");
        $("#lastName").setValue("Abasheva");
        $("#userEmail").setValue("abasheva@ya.ru");
        //$("#genterWrapper").find(byText("Female")).click();
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue("9935275449");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");//
        $("[class=react-datepicker__year-select]").find(byText("1983")).click();//
        $("[class=react-datepicker__week]").find(byText("4")).click();//
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").find(byText("Sports")).click();
        File file = $("#uploadPicture").uploadFromClasspath("photo_1.jpg");
        $("#currentAddress").setValue("Izhevsk 15");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Oksana Abasheva"),
        (text("abasheva@ya.ru")),
        (text("Female")),
        (text("9935275449")),
        (text("04 February,1983")),
        (text("Maths")),
        (text("Sports")),
        (text("photo_1.jpg")),
        (text("Izhevsk 15")),
        (text("NCR Delhi")));

        $("#closeLargeModal").click();
    }
}