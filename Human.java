package ru.geekbrains.level_2.lesson_1;

public class Human extends Team {

    public Human(String name, int maxRange, int maxJump) {
        super(name, maxRange, maxJump);
    }


    @Override
    public void runTreadmill(Treadmill treadmill) {
        if (treadmill.getRange() <= getMaxRange() )
            System.out.println("Human " + getName() + " ran " + treadmill.getRange() + " meters" );
        else System.out.println("Human " + getName() + " could not run " + treadmill.getRange() + " meters");
    }

    @Override
    public void jumpWall(Wall wall) {
        if (wall.getHeight() <= getMaxJump())
            System.out.println("Human " + getName() + " was able to jump over an obstacle with a height of " + wall.getHeight() + " meters");
        else System.out.println("Human " + getName() + " could not jump over an obstacle  " + wall.getHeight() + " meters high");
    }
}
