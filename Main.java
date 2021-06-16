package ru.geekbrains.level_2.lesson_5;

import java.util.Arrays;

public class Main {

    static final int size = 10_000_000;
    static final int half = size / 2;

    public static void main(String[] args) {
        Main main = new Main();
        main.FirstMethod();
        main.SecondMethod();
    }

    private void FirstMethod(){
        System.out.println("Running the first method");
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5.0f) * Math.cos(0.2f + i / 5.0f) * Math.cos(0.4f + i / 2.0f));
        }
        long end = System.currentTimeMillis();
        System.out.printf("Completion of the first method, lead time: %s%n", String.valueOf(end - start));
    }

    private void ThreadMethod(float[] arr, int thread_number){
        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5.0f) * Math.cos(0.2f + i / 5.0f) * Math.cos(0.4f + i / 2.0f));
        }
        long end = System.currentTimeMillis();
        System.out.printf("Thread execution time %d: %s%n", thread_number, String.valueOf(end - start));
    }

    private void SecondMethod(){
        System.out.println("Running the second method");
        float[] arr = new float[size];
        float[] arr1 = new float[half];
        float[] arr2 = new float[half];
        Arrays.fill(arr, 1.0f);
        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);
        long split = System.currentTimeMillis();
        System.out.printf("Execution time for splitting an array: %s%n", String.valueOf(split - start));

        Thread thread1 = new Thread(() ->this.ThreadMethod(arr1, 1));
        Thread thread2 = new Thread(() ->this.ThreadMethod(arr2, 2));

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            System.out.printf("Exception in threads: %s%n", e.getMessage());
        }

        long connect = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);
        long end = System.currentTimeMillis();
        System.out.printf("Execution time for gluing an array: %s%n", String.valueOf(end - connect));
        System.out.printf("Completion of the second method, lead time: %s%n", String.valueOf(end - start));
    }
}
