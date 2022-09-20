package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (true) {

            String input = scanner.nextLine();
            coffeeMachine.input(input);
        }
    }

    private int water;
    private int milk;
    private int coffee;
    private int cups;
    private int money;

    /*public CoffeeMachine(int water, int milk, int coffee) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
    }*/
    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffee = 120;
        this.cups = 9;
        this.money = 550;
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }
    private void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                this.makeEspresso();
                break;
            case "2":
                this.makeLatte();
                break;
            case "3":
                this.makeCappuccino();
                break;
            case "back":
                return;
            default:
                System.out.println("wrong command");
        }
    }
    private void fill() {
        System.out.println("\nWrite how many ml of water you want to add: ");
        int input = scanner.nextInt();
        this.water += input;
        System.out.println("Write how many ml of milk you want to add: ");
        input = scanner.nextInt();
        this.milk += input;
        System.out.println("Write how many grams of coffee beans you want to add:");
        input = scanner.nextInt();
        this.coffee += input;
        System.out.println("Write how many disposable cups you want to add: ");
        input = scanner.nextInt();
        this.cups += input;
        //this.showInformation();
    }
    private void take() {
        System.out.printf("I gave you $%d\n", this.money);
        this.money = 0;
        //this.showInformation();
    }
    private void makeEspresso() {
        if (canTakeWater(250) && canTakeCoffee(16) && canTakeCup()) {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= 250;
            this.coffee -= 16;
            this.money += 4;
            this.cups -= 1;
        }
    }
    private void makeLatte() {
        if (canTakeWater(350) && canTakeMilk(75) && canTakeCoffee(20) && canTakeCup()) {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= 350;
            this.milk -= 75;
            this.coffee -= 20;
            this.money += 7;
            this.cups -= 1;
        }
    }

    private void makeCappuccino() {
        if (canTakeWater(200) && canTakeMilk(100) && canTakeCoffee(12) && canTakeCup()) {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= 200;
            this.milk -= 100;
            this.coffee -= 12;
            this.money += 6;
            this.cups -= 1;
        }
    }

    private void showInformation() {
        System.out.printf("\nThe coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n", water, milk, coffee, cups, money);
    }

    private boolean canTakeWater(int water) {
        if (this.water >= water) {

            return true;
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }

    private boolean canTakeCoffee(int coffee) {
        if (this.coffee >= coffee) {

            return true;
        } else {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
    }

    private boolean canTakeMilk(int milk) {
        if (this.milk >= milk) {

            return true;
        } else {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
    }

    private boolean canTakeCup() {
        if (this.cups >= 1) {

            return true;
        } else {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
    }

    public void input(String input) {
        switch (input) {
            case "buy":
                this.buy();
                break;
            case "fill":
                this.fill();
                break;
            case "take":
                this.take();
                break;
            case "remaining":
                this.showInformation();
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("wrong command");
        }
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");

    }

    private static Scanner scanner = new Scanner(System.in);
}
