package com.epam.olha_yeskina.java.lection10;

/**
 * Написать калькулятор – программа, которая на входе получает два целых числа (число А и число В),выполняет арифметическую операцию
 * («+» - сложение, «-» - вычитание, «*» - умножение, «/» - деление) и выводит результат в консоль.
 * Для каждой операции использовать отдельный метод.
 */



import org.apache.log4j.Logger;

import java.util.Scanner;


public class Calculator {

    final static Logger logger = Logger.getLogger(Calculator.class);

static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int firstValue = getInt();
        char operation = getOperation();
        int secondValue = getInt();
        System.out.println(calc(firstValue,secondValue,operation));

    }

    public static int addition(int firstValue, int secondValue){
        logger.debug("Something");
        return firstValue+secondValue;
    }

    public static int subtraction(int firstValue, int secondValue){
        return firstValue-secondValue;
    }

    public static int multiplication(int firstValue, int secondValue){
        return firstValue*secondValue;
    }

    //пока не делала проверки на 0 и exceptions
    public static int division(int firstValue, int secondValue){


        int divValue;

        try{
            divValue = firstValue/secondValue;
            return divValue;
        }catch (ArithmeticException e){
            logger.error(e.getMessage(), e);

            System.out.println("Error: "+ e.getMessage());
//            secondValue = getInt();
//            System.out.println(calc(firstValue,secondValue,'/'));
        }

        return secondValue;

    }


    public static int getInt(){
        System.out.println("Введите число:");
        int value;
        if(scanner.hasNextInt()){
            value = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            value = getInt();
        }
        return value;
    }

    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    public static double calc(int firstValue, int secondValue, char operation){
        double result;
        switch (operation){
            case '+':
                result = addition(firstValue, secondValue);
                break;
            case '-':
                result = subtraction(firstValue, secondValue);
                break;
            case '*':
                result = multiplication(firstValue, secondValue);
                break;
            case '/':
                result = division(firstValue, secondValue);
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(firstValue, secondValue, getOperation());//рекурсия
        }
        return result;
    }
}
