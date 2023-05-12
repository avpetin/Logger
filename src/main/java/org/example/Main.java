package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка: ");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int num = Integer.parseInt(br.readLine());
            System.out.println("Введите верхнюю границу для значений: ");
            int maxValue = Integer.parseInt(br.readLine());
            logger.log("Создаём и наполняем список ");
            Random random = new Random();
            List<Integer> randomData = new ArrayList<>();
            System.out.println("Вот случайный список: ");
            for (int i = 0; i < num; i++) {
                int intData = random.nextInt(maxValue);
                randomData.add(intData);
                System.out.print(intData + " ");
            }
            System.out.println();
            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.println("Введите порог для фильтра: ");
            int threshold = Integer.parseInt(br.readLine());
            logger.log("Запускаем фильтрацию");
            Filter filter = new Filter(threshold);
            List<Integer> filteredData = filter.filterOut(randomData);
            System.out.println("Выводим результат на экран");
            System.out.println("Отфильтрованный список: ");
            for (Integer n : filteredData) {
                System.out.print(n + " ");
            }
            System.out.println();
            logger.log("Завершаем программу");
        } catch (IOException e) {
        }
    }
}