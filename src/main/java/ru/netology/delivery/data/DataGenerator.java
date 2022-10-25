package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {

    }


    private static Faker faker;

    static void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    public static String generateDate(int days) {
        String date = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        return date;
    }

    public static String generateCity(String locale) {
        var city = new String[]{"Горно-Алтайск", "Гатчина", "Санкт-Петербург", "Ярославль", "Якутск", "Южно-Сахалинск", "Элиста",
                "Чита", "Черкесск", "Челябинск", "Чебоксары", "Ханты-Мансийск", "Хабаровск", "Уфа", "Ульяновск", "Улан-Удэ",
                "Тюмень", "Тула", "Томск", "Тверь", "Тамбов", "Сыктывкар", "Ставрополь", "Смоленск", "Симферополь",
                "Севастополь", "Саратов", "Саранск", "Санкт-Петербург", "Самара", "Салехард", "Рязань", "Ростов-на-Дону", "Псков",
                "Петропавловск-Камчатский", "Петрозаводск", "Пермь", "Пенза", "Оренбург", "Орёл", "Омск", "Новосибирск",
                "Нижний Новгород", "Нарьян-Мар", "Нальчик", "Мурманск", "Москва", "Махачкала", "Майкоп", "Магас", "Магадан",
                "Липецк", "Кызыл", "Курск", "Курган", "Красноярск", "Краснодар", "Кострома", "Киров",
                "Кемерово", "Калуга", "Калининград", "Казань", "Йошкар-Ола", "Иркутск", "Ижевск", "Иваново", "Екатеринбург",
                "Грозный", "Воронеж", "Вологда", "Волгоград", "Владимир", "Владикавказ", "Владивосток", "Великий Новгород",
                "Брянск", "Благовещенск", "Биробиджан", "Белгород", "Барнаул", "Астрахань", "Архангельск", "Анадырь", "Абакан"};

        return city[new Random().nextInt(city.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));

            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}