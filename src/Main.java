import Human.Human;
import Flower.Flower;
import Transport.Car;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        int currentYear = 2022;

        Human maksim = new Human("Максим", "Минск", currentYear - 35, "бренд-менеджер");
        Human anya = new Human("Аня", "Москва", currentYear - 29, "методист образовательных программ");
        Human katya = new Human("Катя", "Калининград", currentYear - 28, "продакт-менеджер");
        Human artyom = new Human("Артём", "Москва", currentYear - 27, "директор по развитию бизнеса");
        Human vladimir = new Human("Владимир", "Казань", currentYear - 21, null);

        printInfo(maksim);
        printInfo(anya);
        printInfo(katya);
        printInfo(artyom);
        printInfo(vladimir);

        System.out.println();

        Flower rose = new Flower("Роза обыкновенная", null, "Голландия", 35.59);
        Flower chrysanthemum = new Flower("Хризантема", null, null, 15, 5);
        Flower peony = new Flower("Пион", null, "Англия", 69.9, 1);
        Flower gypsophila = new Flower("Гипсофила", null, "Турция", 19.5, 10);

        printInfo(rose);
        printInfo(chrysanthemum);
        printInfo(peony);
        printInfo(gypsophila);

        System.out.println();

        printCostOfBouquet(
                rose, rose, rose,
                chrysanthemum, chrysanthemum, chrysanthemum, chrysanthemum, chrysanthemum,
                gypsophila);

        System.out.println();

        Car granta = new Car(
                "Lada",
                "Granta",
                1.7,
                "жёлтый",
                2015,
                "Россия");
        granta.setRegNumber("к501ле102");
        System.out.println(granta.isCorrectRegNumber());


        Car audi = new Car(
                "Audi",
                "A8 50 L TDI quattro",
                3.0,
                "черный",
                2020,
                "Германия");
        audi.setTransmission("автомат");
        audi.setKey(new Car.Key(true, true));

        Car bmw = new Car(
                "BMW",
                "Z8",
                3.0,
                "черный",
                2021,
                "Германия");
        bmw.setSummerTyres(false);
        bmw.setInsurance(new Car.Insurance(LocalDate.now(), 30_000D, "5412369"));
        bmw.getInsurance().checkExpireDate();
        bmw.getInsurance().checkNumber();

        Car kia = new Car(
                "Kia",
                "Sportage 4 поколение",
                2.4,
                "красный",
                2018,
                "Южная Корея");

        Car hyundai = new Car(
                "Hyundai",
                "Avante",
                1.6,
                "оранжевый",
                2016,
                "Южная Корея");

        printInfo(granta);
        printInfo(audi);
        printInfo(bmw);
        printInfo(kia);
        printInfo(hyundai);
    }

    private static void printInfo(Human human) {
        System.out.println("Привет! Меня зовут " + human.name + ". Я из города " + human.getTown() + ". Я родился в " + (human.getYearOfBirth()) + " году. Я работаю на должности " + human.post + ". Будем знакомы!");

    }

    private static void printInfo(Flower flower) {
        System.out.println("Цветок: " + flower.name +
                ", цвет: " + flower.getFlowerColor() +
                ", страна: " + flower.getCountry() +
                ", стоимость за штуку: " + flower.getCost() +
                ", срок стояния цветка: " + flower.lifeSpan);
    }

    private static void printCostOfBouquet(Flower... flowers) {
        double totalCost = 0;
        int minimumLifeSpan = Integer.MAX_VALUE;
        for (Flower flower : flowers) {
            if (flower.lifeSpan < minimumLifeSpan) {
                minimumLifeSpan = flower.lifeSpan;
            }
            totalCost += flower.getCost();
            printInfo(flower);
        }
        totalCost = totalCost * 1.1;
        System.out.println("Стоимость букета: " + totalCost);
        System.out.println("Срок стояния букета: " + minimumLifeSpan);

    }

    private static void printInfo(Car car) {
        System.out.println(
                "Марка автомобиля " + car.getBrand() +
                        ", модель " + car.getModel() +
                        ", год выпуска " + car.getProductionYear() +
                        ", страна производства " + car.getOrigin() +
                        ", цвет " + car.getColor() +
                        ", объем двигателя " + car.getEngineVolume() +
                        ", коробка передач: " + car.getTransmission() +
                        ", тип кузова: " + car.getTypeOfBody() +
                        ", регистрационный номер: " + car.getRegNumber() +
                        ", количество мест: " + car.getSeatsCount() +
                        ", " + (car.isSummerTyres() ? "летняя" : "зимняя") + " резина" +
                        ", " + ((car.getKey().isWithoutKeyAccess()) ? "беcключевой доступ" : "ключевой доступ") +
                        ", " + ((car.getKey().isRemoteRunEngine()) ? "удалённый запуск" : "обычный запуск") +
                        ", номер страховки: " + car.getInsurance().getNumber() +
                        ", стоимость страховки: " + car.getInsurance().getCost() +
                        ", срок действия страховки: " + car.getInsurance().getExpireDate()
        );
    }
}