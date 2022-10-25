package ru.netology.delivery.data;
import jdk.jfr.DataAmount;
import lombok.Data;

public class Registration {
    @Data
    public class RegistrationInfo{
        private final String name;
        private final String phone;
        private final String city;

    }

}
