package com.daniil.tests;

import com.codeborne.selenide.Configuration;
import com.daniil.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тест пятого урока")
public class StudentRegistrationFormWithPageObjectsAndJavaFaker {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String secondName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String gender = "Other";
    String subject = "History";
    String hobby = "Sports";
    String imagePath = "img/1.jpg";
    String address = faker.address().streetAddress();
    String state = "NCR";
    String city = "Delhi";

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void studentRegistrationFormTestWithJavaFaker(){
        registrationPage.openPage();

        registrationPage.typeFirstName(firstName);
        registrationPage.typeSecondName(secondName);
        registrationPage.typeEmail(email);
        registrationPage.typePhoneNumber(phoneNumber);
        registrationPage.selectGender(gender);
        registrationPage.calendarComponent.setDate("06", "June", "1992");
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

