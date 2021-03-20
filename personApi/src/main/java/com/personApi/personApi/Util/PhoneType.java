package com.personApi.personApi.Util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public enum PhoneType{

    Home("COMERCIAL"),
    MOBILE("Mobile"),
    COMERCIAL("Comercial");

    public final String  description;

    PhoneType(String description) {
        this.description = description;
    }


}