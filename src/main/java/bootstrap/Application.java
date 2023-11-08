package bootstrap;

import entity.AvailabilityOfDrug;
import entity.GeneraleRecipeKey;
import entity.Recipe;
import entity.User;
import service.AuthorisationService;
import service.FileUtils;
import service.Menu;

import java.util.List;
import java.util.Scanner;

public class Application {
 //   public final List<SalesJournal> salesJournals;
    public final List<User> users;
    public final List<GeneraleRecipeKey> generaleRecipeKeys;
    public final List<AvailabilityOfDrug> availabilityOfDrugs;
    public final Recipe recipe;



    public Application() {
        users = FileUtils.readFileUser("src\\Users");
        generaleRecipeKeys = FileUtils.readGeneraleRecipeKey("src\\GeneraleRecipeKey");
        availabilityOfDrugs = FileUtils.readAvailabilityOfDrug("src\\AvailabilityOfDrug");
        recipe = FileUtils.readRecipe("src\\Recipe");
    }

    public static void runApplication() {
        Application a = new Application();
        System.out.println(a.users);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите ваше ФИО");
        String login = keyboard.nextLine();
        System.out.println("Введите ваш пароль");
        String password = keyboard.nextLine();
        AuthorisationService authorisationService = new AuthorisationService();
        while (!authorisationService.tryToAuthoriseUser(login, password, a.users)) {
            System.out.println("Введите ваш пароль");
            password = keyboard.nextLine();
        }
        System.out.println("Выберите один из пунктов");
        Menu menu = new Menu();
        menu.printMenu();
         String input = keyboard.nextLine();
        while (!(input.equals("1")) & !(input.equals("2"))) {
            System.out.println("Введите 1 или 2");
            input = keyboard.nextLine();
        }
        if (input.equals("1")) {

        }
    }
}
