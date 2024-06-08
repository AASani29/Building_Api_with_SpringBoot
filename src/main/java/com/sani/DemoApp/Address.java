package com.sani.DemoApp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.PrivateKey;
@Data
@AllArgsConstructor
public class Address {
    private String country;
    private String city;
    private String postCode;


}
