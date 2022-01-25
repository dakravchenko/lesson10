package com.daniil.pages;

import com.codeborne.selenide.SelenideElement;
import com.daniil.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        resultTable = $(".table-responsive"),
        emailInput = $("#userEmail"),
        genderRadio = $("#genterWrapper"),
        phoneInput = $("#userNumber"),
        hobbiesCheckbox = $("#hobbiesWrapper"),
        addressInput = $("#currentAddress"),
        possibleStates = $("#state"),
        possibleCities = $("#city"),
        stateOrCityInput = $("#stateCity-wrapper"),
        submit = $("#submit"),
        pictureUpload = $("#uploadPicture"),
        subjectInput = $("#subjectsInput");

    public CalendarComponent calendarComponent = new CalendarComponent();

    public void openPage(){
        open("https://demoqa.com/automation-practice-form");
    }

    public void typeFirstName(String value){
        firstNameInput.setValue(value);
    }
    public void typeSecondName(String value){
        lastNameInput.setValue(value);
    }
    public void typeEmail(String value){
        emailInput.setValue(value);
    }
    public void selectGender(String gender){
        genderRadio.$(byText(String.valueOf(gender))).click();
    }
    public void typePhoneNumber(String value){
        phoneInput.setValue(value);
    }
    public void selectSubject(String value){
        subjectInput.setValue(value).pressEnter();
    }
    public void selectHobby(String value){
        hobbiesCheckbox.$(byText(value)).click();
    }
    public void uploadPicture(String value){
        pictureUpload.uploadFromClasspath(value);
    }
    public void typeAddress(String value){
        addressInput.setValue(value).scrollTo();
    }
    public void openPossibleStates(){
        possibleStates.scrollTo().click();
    }
    public void openPossibleCities(){
        possibleCities.click();
    }
    public void selectStateOrCity(String value){
        stateOrCityInput.$(byText(String.valueOf(value))).click();
    }
    public void submit(){
        submit.click();
    }
    public RegistrationPage checkValue(String value){
        resultTable.shouldHave(text(value));
        return this;
    }
 }
