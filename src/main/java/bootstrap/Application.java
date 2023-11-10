package bootstrap;

import entity.AvailabilityOfDrug;
import entity.GeneraleRecipeKey;
import entity.Recipe;
import entity.User;
import org.apache.commons.codec.digest.HmacUtils;
import service.AuthorisationService;
import service.FileUtils;
import service.Menu;

import java.util.List;
import java.util.Scanner;

import static entity.GeneraleRecipeKey.getGeneraleRecipeKeyInList;
import static org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_224;

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
        Scanner keyboard = new Scanner(System.in);
//       System.out.println(a.users);
//       System.out.println("Введите ваше ФИО");
//        String login = keyboard.nextLine();
//      System.out.println("Введите ваш пароль");
//        String password = keyboard.nextLine();
//        AuthorisationService authorisationService = new AuthorisationService();
//       while (!authorisationService.tryToAuthoriseUser(login, password, a.users)) {
//           System.out.println("Введите ваш пароль");
//           password = keyboard.nextLine();
//        }
        System.out.println("Выберите один из пунктов");
        Menu menu = new Menu();
        menu.printMenu();
         String input = keyboard.nextLine();
        while (!(input.equals("1")) & !(input.equals("2"))) {
            System.out.println("Введите 1 или 2");
            input = keyboard.nextLine();
        }
        if (input.equals("1")) {
            System.out.println(a.recipe);
            menu.printMenu1();
            String k = keyboard.nextLine();
            while (!k.equals("4")) {
                if (k.equals("1")) {
                 for (GeneraleRecipeKey generale: a.generaleRecipeKeys) {
                     String hashedPassword = new HmacUtils(HMAC_SHA_224, "secret".getBytes()).hmacHex(generale.keyWord);
                     if(hashedPassword.equals(a.recipe.uniqueKey)) {
                         System.out.println("Рецепт прошел проверку на подлинность");
                         break;
                     }
                 }
                }
                if (k.equals("2")) {
                    GeneraleRecipeKey currRecipe = getGeneraleRecipeKeyInList(a.generaleRecipeKeys, a.recipe.uniqueKey);
                    System.out.println(String.format("Введите отпускаемое количество в пределах доступного %d", currRecipe.availableCount));
                    int count = keyboard.nextInt();
                    while (!(count >0 & count<= currRecipe.availableCount)){
                        System.out.println(String.format("Введите отпускаемое количество в пределах доступного %d", currRecipe.availableCount));
                        count = keyboard.nextInt();
                    }
                    currRecipe.setAvailableCount(currRecipe.availableCount - count);
                }
            }

        }
    }
}
