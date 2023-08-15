import java.util.Random;
import java.util.Scanner;

public class Game {

    // constants
    private static int width = 10;
    private static int length = 10;
    private final static String WALL_CHARACTER = "M";
    private final static String EMPTY_CHARACTER = " ";

    private final Scanner console = new Scanner(System.in);
    private Hero hero;
    private Treasure treasureOne;
    private Treasure treasureTwo;
    private Monster monster;
    private boolean isOver;

//    for (Hero h : heroes) {

    public void run() {
        setUp();
        while (!isOver) {
            printWorld();
            moveHero();
            moveMonster();
        }
        printWorld();
    }

    private void setUp() {
        System.out.print("What is the name of your hero?: ");
        String name = console.nextLine();

        System.out.print("What symbol do you want your hero?: ");
        char symbol = console.nextLine().charAt(0);

        System.out.print("How wide do you want this dungeon to be? ");
        this.width = Integer.parseInt(console.nextLine());

        System.out.print("How long do you want this dungeon to be? ");
        this.length = Integer.parseInt(console.nextLine());


        Random rand = new Random();
        int x = rand.nextInt(width);
        int y = rand.nextInt(length);

        hero = new Hero(name, symbol, x, y);

        do {
            x = rand.nextInt(width);
            y = rand.nextInt(length);
        } while (x == hero.getX() && y == hero.getY());

        treasureOne = new Treasure(x, y);

        do {
            x = rand.nextInt(width);
            y = rand.nextInt(length);
        } while (x == hero.getX() && x == treasureOne.getX() && y == hero.getY() && y == treasureOne.getY());

        treasureTwo = new Treasure(x, y);

        do {
            x = rand.nextInt(width);
            y = rand.nextInt(length);
        } while (x == hero.getX() && x == treasureOne.getX() && x == treasureTwo.getX() &&
                y == hero.getY() && y == treasureOne.getY() && x == treasureTwo.getX());

        monster = new Monster(x, y);
    }


    private void printWorld() {
        // top wall border
        System.out.println(WALL_CHARACTER.repeat(width + 2));

        for (int row = 0; row < width; row++) {
            // left wall border
            System.out.print(WALL_CHARACTER);
            for (int col = 0; col < length; col++) {
                if (row == hero.getY() && col == hero.getX()) {
                    System.out.print(hero.getSymbol());
                } else if (row == monster.getY() && col == monster.getX()) {
                    System.out.print(monster.getSymbol());
                } else if (row == treasureOne.getY() && col == treasureOne.getX() && !treasureOne.getIsFound()) {            ////Gotta fix this also
                    System.out.print("T");
                } else if (row == treasureTwo.getY() && col == treasureTwo.getX() && !treasureTwo.getIsFound()) {
                    System.out.print("T");
                } else {
                    System.out.print(EMPTY_CHARACTER);
                }
            }

            // right wall border
            System.out.println(WALL_CHARACTER);
        }

        // bottom wall border
        System.out.println(WALL_CHARACTER.repeat(width + 2));
    }

    private void moveHero() {

        System.out.print(hero.getName() + ", move [WASD]: ");
        String move = console.nextLine().trim().toUpperCase();

        if (move.length() != 1) {
            return;
        }

        switch (move.charAt(0)) {
            case 'W':
                hero.moveUp();
                break;
            case 'A':
                hero.moveLeft();
                break;
            case 'S':
                hero.moveDown();
                break;
            case 'D':
                hero.moveRight();
                break;
        }

        if (hero.getX() < 0 || hero.getX() >= width
                || hero.getY() < 0 || hero.getY() >= width) {
            System.out.println(hero.getName() + " touched lava! You lose.");
            isOver = true;
        } else if (hero.getX() == treasureOne.getX() && hero.getY() == treasureOne.getY()) {
            treasureOne.setIsFound(true);
        } else if (hero.getX() == treasureTwo.getX() && hero.getY() == treasureTwo.getY()) {
            treasureTwo.setIsFound(true);
        }

        if (treasureOne.getIsFound() && treasureTwo.getIsFound()) {
            System.out.println(hero.getName() + " found the treasure! You win.");
            isOver = true;
        }
    }

    public void moveMonster() {
        Random rand = new Random();
        int randomMove = rand.nextInt(5);

        switch (randomMove) {
            case 1:
                monster.moveUp();
                break;
            case 2:
                monster.moveLeft();
                break;
            case 3:
                monster.moveDown();
                break;
            case 4:
                monster.moveRight();
                break;
        }

        if (monster.getX() == hero.getX() && monster.getY() == hero.getY()) {
            System.out.println(hero.getName() + " touched lava! You lose.");
            isOver = true;
        }

    }
}

