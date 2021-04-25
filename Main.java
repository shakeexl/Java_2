package ru.geekbrains.level_2.lesson_3;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.

2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров. В этот
телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по
фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять лишний функционал (дополнительные поля
(имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода
результатов проверки телефонного справочника.
 */

import java.util.*;

public class Main {
    public static void main(String[] args){

        System.out.println("Task 1:\n");

        List<String> words = Arrays.asList(
                "Python", "JavaScript", "Java", "C++", "Golang",
                "C#", "SQL", "Dart", "C++", "Golang",
                "JavaScript", "Audi", "C++", "C#", "Golang",
                "Python", "JavaScript", "Java", "Java", "SQL"
        );

        Set<String> unique = new HashSet<>(words);

        System.out.println("Initial array:");
        System.out.println(words);

        System.out.println("Unique words:");
        System.out.println(unique);

        System.out.println("Frequency:");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key) + "\n");
        }

        System.out.println("Task 2:\n");

        Phonebook phonebook = new Phonebook();
        List<String> surnames = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Miller");
        List<String> phones = Arrays.asList("202-555-0146", "202-555-0129", "202-555-0157", "202-555-0198", "202-555-0103");

        for (int i = 0, j = 0; i < surnames.size() && j < phones.size(); i++, j++) {
            phonebook.add(surnames.get(i), phones.get(j));
        }

        System.out.println(phonebook.get("Smith"));
        System.out.println(phonebook.get("Miller"));
    }
}
