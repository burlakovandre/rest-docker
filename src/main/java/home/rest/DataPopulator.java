//package home.rest;
//
//import home.rest.model.Car;
//import home.rest.model.Engine;
//import home.rest.repository.CarRepository;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class DataPopulator {
//    @Bean
//    RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//
//    @Bean
//    public ApplicationRunner populateData(RestTemplate restTemplate) {
//        return args -> {
//            Engine engine1 = new Engine(null, 3.0, 300, "benzin");
//            Engine engine2 = new Engine(null, 3.0, 350, "diesel");
//
//            // Зберігаємо двигуни через REST API і отримуємо їх з присвоєними ID
////            restTemplate.postForObject("http://localhost:8080/rst/engines", engine1, Engine.class);
////            engine1 = restTemplate.getForObject("http://localhost:8080/rst/engines", Engine.class);
////            System.out.println(engine1);
////            engine2 = restTemplate.postForObject("http://localhost:8080/rst/engines", engine2, Engine.class);
//
//            // Використовуємо оновлені об'єкти Engine для створення автомобілів
//            Car car1 = new Car(null, "bmw", "x6", engine1);
//            Car car2 = new Car(null, "audi", "q8", engine2);
//
//            // Зберігаємо автомобілі через REST API
//            car1 = restTemplate.postForObject("http://localhost:8080/rst/cars", car1, Car.class);
//            System.out.println(car1);
//            restTemplate.postForObject("http://localhost:8080/rst/cars", car2, Car.class);
//
//            System.out.println("Initial data loaded.");
//        };
//    }
//}
//
//
