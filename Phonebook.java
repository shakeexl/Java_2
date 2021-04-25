package ru.geekbrains.level_2.lesson_3;

import java.util.*;

public class Phonebook {

    private final HashMap<String, List<String>> book;

    public Phonebook(){
        this.book = new HashMap<>();
    }

    public void add(String surname, String number){
        if(book.containsKey(surname)){
            List<String> numbers = book.get(surname);
            if(!numbers.contains(number)){
                numbers.add(number);
                System.out.printf("Number %s added for surname %s%n", number, surname);
            } else {
                System.out.printf("Number %s already exists for surname %s%n", number, surname);
            }
        } else {
            book.put(surname, new ArrayList<>(Collections.singletonList(number)));
            System.out.printf("Number %s added for surname %s%n", number, surname);
        }
    }

    public List<String> get(String surname){
        if(book.containsKey(surname)){
            return book.get(surname);
        } else {
            System.out.printf("There is no value for surname %s in the phonebook %n", surname);
            return new ArrayList<>();
        }
    }
}
