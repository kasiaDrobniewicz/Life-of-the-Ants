import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the size of the colony? ");
        int userWidth = userInput.nextInt();
        ColonyOfAnts colony = new ColonyOfAnts(userWidth);
        System.out.println("Enter numbers of workers? ");
        int numberOfWorkers = userInput.nextInt();
        System.out.println("Enter numbers of soldiers? ");
        int numberOfSoldiers = userInput.nextInt();
        System.out.println("Enter numbers of drones? ");
        int numberOfDrones = userInput.nextInt();
        colony.generateAnts(numberOfWorkers, numberOfSoldiers, numberOfDrones);

        System.out.println("_____GENERATE COLONY OF ANTS___________");
        colony.display();

        boolean quit = false;
        while (!quit) {
            printActions();
            int action = userInput.nextInt();
            userInput.nextLine();

            switch (action) {
                case 0:
                    System.out.println("SHUTTING DOWN ...");
                    quit = true;
                    break;
                case 1:
                    System.out.println("_____ COLONY AFTER UPDATE_____");
                    colony.update();
                    colony.display();
                    break;
            }
        }
    }

    private static void printActions () {
        System.out.println("\nChoose action: ");
        System.out.println("0 -> Quit");
        System.out.println("1 -> Update colony");
    }
}





