package ru.geekbrains.level_2.lesson_1;

public class Cat extends Team {

    public Cat(String name, int maxRange, int maxJump) {
        super(name, maxRange, maxJump);
    }


    @Override
    public void runTreadmill(Treadmill treadmill) {
        if (treadmill.getRange() <= getMaxRange() )
            System.out.println("Cat " + getName() + " ran " + treadmill.getRange() + " meters" );
        else System.out.println("Cat " + getName() + " could not run " + treadmill.getRange() + " meters");
    }

    @Override
    public void jumpWall(Wall wall) {
        if (wall.getHeight() <= getMaxJump())
            System.out.println("Cat " + getName() + " was able to jump over an obstacle with a height of " + wall.getHeight() + " meters");
        else System.out.println("Cat " + getName() + " could not jump over an obstacle  " + wall.getHeight() + " meters high");
    }
}
