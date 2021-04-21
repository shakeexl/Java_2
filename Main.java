package ru.geekbrains.level_2.lesson_1;

/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и
прыгать (методы просто выводят информацию о действии в консоль).

2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие
действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).

3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.

4. У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 */

public class Main {

    public static void Trial(Team[] team, Treadmill treadmill, Wall wall) {
        for (int i = 0; i < 3; i++) {
            team[i].runTreadmill(treadmill);
        }
        for (int j = 0; j < 3; j++) {
            team[j].jumpWall(wall);
        }
        System.out.println("Trial is over");
    }

    public static void main(String[] args) {

        Team[] team = new Team[3];
        team[0] = new Robot("Robi", 500, 10);
        team[1] = new Cat("Cati", 300, 7);
        team[2] = new Human("John", 200, 3);

        Treadmill treadmill = new Treadmill(400);
        Wall wall = new Wall(5);

        Trial(team, treadmill, wall);
    }
}
