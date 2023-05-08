package com.FIT5046.assignment;

import java.util.Calendar;

public class CreateAccountClass {
    private String accountName,datePicker,AddressOne,AddressTwo,Cityinput,stateinput,zipinput,countryinput,spinnerforgender;


    public CreateAccountClass(){

    }

    public CreateAccountClass(String accountName, String datePicker, String addressOne, String addressTwo, String cityinput, String stateinput, String zipinput, String countryinput,String spinnerforgender) {
        this.accountName = accountName;
        this.datePicker = datePicker;
        this.AddressOne = addressOne;
        this.AddressTwo = addressTwo;
        this.Cityinput = cityinput;
        this.stateinput = stateinput;
        this.zipinput = zipinput;
        this.countryinput = countryinput;
        this.spinnerforgender = spinnerforgender;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getDatePicker() {
        return datePicker;
    }

    public String getAddressOne() {
        return AddressOne;
    }

    public String getAddressTwo() {
        return AddressTwo;
    }

    public String getCityinput() {
        return Cityinput;
    }

    public String getStateinput() {
        return stateinput;
    }

    public String getZipinput() {
        return zipinput;
    }

    public String getCountryinput() {
        return countryinput;
    }

    public String getSpinnerforgender() {
        return spinnerforgender;
    }
}
