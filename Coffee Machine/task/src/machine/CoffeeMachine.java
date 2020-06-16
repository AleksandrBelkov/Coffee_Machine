package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void currentStatus(int a, int b, int c, int d, int e) {

        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(a + " of water");
        System.out.println(b + " of milk");
        System.out.println(c + " of coffee beans");
        System.out.println(d + " of disposable cups");
        System.out.println(e + " of money");

    }

    public static String buyCoffee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String inputType = scanner.nextLine();
        return inputType;
    }

    public static boolean checkResourse(int a, int b, int c, int d) {

        if (a > 0 && b > 0 && c > 0 && d > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static int takeCM(int money) {
        System.out.println("I gave you $" + money);
        money = 0;
        return money;
    }


    public static void main(String[] args) {


        /*System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");*/

        Scanner scanner = new Scanner(System.in);

        /*System.out.println("Write how many cups of coffee you will need:");

        int cupsNumber = scanner.nextInt();

        System.out.println("For " + cupsNumber + " cups of coffee you will need:");
        System.out.println(cupsNumber * 200 +" ml of water");
        System.out.println(cupsNumber * 50 + " ml of milk");
        System.out.println(cupsNumber * 15 + " g of coffee beans");*/

        //step 3

        /*
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        int waterCups = water / 200;
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        int milkCups = milk / 50;
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();
        int beansCups = beans / 15;
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int minCups;

        minCups = (waterCups <= milkCups) ? (waterCups <= beansCups ? waterCups : beansCups) : (milkCups <= beansCups ? milkCups : beansCups);

        if (minCups == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (minCups > cups) {
            int delta = minCups - cups;
            System.out.println("Yes, I can make that amount of coffee (and even " + delta +" more than that)");
        } else {
            System.out.println("No, I can make only " + minCups + " cup(s) of coffee");
        }*/

        //Step 4
        int currentWater = 400;
        int currentMoney = 550;
        int currentMilk = 540;
        int currentBeans = 120;
        int currentCups = 9;
        String typeCoffee;
        int deltaWater, deltaMilk, deltaBeans, deltaCups;
        boolean flag = true;

        while (flag) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();

            switch (action) {
                case "buy":
                    typeCoffee = buyCoffee();
                    switch (typeCoffee) {
                        case "1":
                            currentWater -= 250;
                            currentBeans -= 16;
                            currentMoney += 4;
                            currentCups--;
                            if (!checkResourse(currentWater, currentMilk, currentBeans, currentCups)) {
                                System.out.println("I have enough resources, making you a coffee!");
                                currentWater += 250;
                                currentBeans += 16;
                                currentMoney -= 4;
                                currentCups++;
                            } else {
                                break;
                            }
                        case "2":
                            currentWater -= 350;
                            currentMilk -= 75;
                            currentBeans -= 20;
                            currentMoney += 7;
                            currentCups--;
                            if (!checkResourse(currentWater, currentMilk, currentBeans, currentCups)) {
                                System.out.println("I have enough resources, making you a coffee!");
                                currentWater += 350;
                                currentMilk += 75;
                                currentBeans += 20;
                                currentMoney -= 7;
                                currentCups++;
                            } else {
                                break;
                            }
                        case "3":
                            currentWater -= 200;
                            currentMilk -= 100;
                            currentBeans -= 12;
                            currentCups--;
                            currentMoney += 6;
                            if (!checkResourse(currentWater, currentMilk, currentBeans, currentCups)) {
                                System.out.println("I have enough resources, making you a coffee!");
                                currentWater += 200;
                                currentMilk += 100;
                                currentBeans += 12;
                                currentMoney -= 6;
                                currentCups++;
                            } else {
                                break;
                            }
                        case "back":
                            break;
                        default:
                            System.out.println("Wrong type of Coffee");
                    }
                    break;
                case "fill":
                    System.out.println();
                    System.out.println("Write how many ml of water do you want to add:");
                    deltaWater = scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    deltaMilk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    deltaBeans = scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    deltaCups = scanner.nextInt();
                    currentWater += deltaWater;
                    currentMilk += deltaMilk;
                    currentBeans += deltaBeans;
                    currentCups += deltaCups;
                    break;
                case "take":
                    currentMoney = takeCM(currentMoney);
                    break;
                case "remaining":
                    currentStatus(currentWater, currentMilk, currentBeans, currentCups, currentMoney);
                    break;
                case "exit":
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong action");
            }
        }
    }
}
