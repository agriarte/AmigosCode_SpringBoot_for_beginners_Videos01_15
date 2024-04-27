package com.amigosce.proyecto01;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Proyecto01Application {

    public static void main(String[] args) {
        SpringApplication.run(Proyecto01Application.class, args);
        System.out.println("**** EMPEZAMOS ***** com.amigosce.proyecto01.Proyecto01Application.main()");
    }

    @GetMapping("/greet")
    public String greet() {
        return "Hello";
    }

    // VIDEO 14
    // Endpoint que maneja las solicitudes GET en la ruta /greet2 y devuelve un objeto GreetResponse
    // Recibe un parámetro 'saludo', que se utiliza para construir un objeto GreetResponse
    @GetMapping("/greet2")
    public GreetResponse2 llamaSaludo2(String saludo) {
        return new GreetResponse2("Hola"); // {"saludo":"Hola"}
    }

    // Clase que representa una respuesta de saludo, utilizando la característica 'record' de Java 14
    // Un 'record' en Java es una forma concisa de definir clases de datos inmutables (tipo 'final') Se usa para Apis, DTOs (objetos de transferencia de datos), eventos,...
    record GreetResponse2(String saludo) {

    }

    // VIDEO 15 
    @GetMapping("/greet3")
    public GreetResponse3 llamaSaludo3(String saludo) {
        return new GreetResponse3(
                "Hola",
                List.of("Java", "PHP", "JavaScript"),
                new Person("Pedro","Barcelona")); // {"saludo":"Hola"}
    }

    record GreetResponse3(String saludo, List<String> listProgrammingLanguages, Person person) {

    }
    
    record Person (String name, String city) {

    }

// *** CODIGO EQUIVALENTE SIN USAR record GreetResponse(String saludo) {}
// 
// clase que devuelve json y implementa metodos sobreescritos equivalente a un simple record GreetResponse(String saludo) {}
//    class GreetResponse {
//
//        private final String saludo2;
//
//        public GreetResponse(String salu2) {
//            this.saludo2 = salu2;
//        }
//
//        public String getGreet4() {
//            return saludo2; // El json devuelto {"greet4":"Hola"}. El nombre del atributo será el del método quitando "get"
//        }
//
//        @Override
//        public String toString() {
//            return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            return super.equals(obj); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//        }
//
//        @Override
//        public int hashCode() {
//            return super.hashCode(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//        }
//
//    }
}
