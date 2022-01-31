package com.daniil.tests;

import com.codeborne.selenide.Configuration;
import com.daniil.pages.RegistrationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("dakravchenko")
@Feature("Registration")
@Story("Регистрация")
@DisplayName("Регистрация")
@Severity(SeverityLevel.BLOCKER)
public class StudentRegistrationFormWithPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Daniil";
    String secondName = "Kravchenko";
    String email = "secret@mail.com";
    String gender = "Other";
    String phoneNumber = "8999696969";
    String subject = "History";
    String hobby = "Sports";
    String imagePath = "img/1.jpg";
    String address = "Mohadisha Temple";
    String state = "NCR";
    String city = "Delhi";
    
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void studentRegistrationFormTestWithPageObject(){
        registrationPage.openPage();

        registrationPage.typeFirstName(firstName);
        registrationPage.typeSecondName(secondName);
        registrationPage.typeEmail(email);
        registrationPage.selectGender(gender);
        registrationPage.typePhoneNumber(phoneNumber);
        registrationPage.calendarComponent.setDate("06", "June", "1992"); // разобраться с методом
        registrationPage.selectSubject(subject); // попробовать вызвать несколько таких методов
        registrationPage.selectHobby(hobby);
        //registrationPage.uploadPicture(imagePath);
        registrationPage.typeAddress(address);
        registrationPage.openPossibleStates();
        registrationPage.selectStateOrCity(state);
        registrationPage.openPossibleCities();
        registrationPage.selectStateOrCity(city);
        registrationPage.submit();

        registrationPage.checkValue(firstName)
                        .checkValue(secondName)
                        .checkValue(email)
                        .checkValue(gender)
                        .checkValue(phoneNumber)
                        .checkValue("06 June,1992")
                        .checkValue(subject)
                        .checkValue(hobby)
                        .checkValue(address)
                        .checkValue(state)
                        .checkValue(city);
    }
}

