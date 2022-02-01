package internationalization;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.*;

import static java.lang.System.out;

public class Task25 {
    private static final String FOLDER = "ApplicationMessages";
    public static void main(String[] args) {
        ResourceBundle bundle;
        Scanner console = new Scanner(System.in);
        out.println("\tCountry");
        out.println("1.England");
        out.println("2.France");
        out.println("3.Sweden");
        out.print("Choose a country:");
        switch (console.nextInt()) {
            case 1:
                bundle = ResourceBundle.getBundle(FOLDER);
                break;
            case 2:
                bundle = ResourceBundle.getBundle(FOLDER, Locale.FRANCE);
                break;
            case 3:
                bundle = ResourceBundle.getBundle(FOLDER, new Locale("sv", "SE"));
                break;
            default:
                out.println();
                bundle = ResourceBundle.getBundle(FOLDER);
        }
        printMessages(bundle);
    }

    private static void printMessages(ResourceBundle bundle) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, bundle.getLocale());
        out.println("CountryName : " + bundle.getString("CountryName") + bundle.getLocale());
        out.println("CurrencyCode: " + bundle.getString("CurrencyCode"));
        out.println("Today: " + dateFormat.format(new Date()));
        out.println("Base currency: " + Currency.getInstance(bundle.getLocale()).getDisplayName() + ", " +
                NumberFormat.getCurrencyInstance(bundle.getLocale()).format(1));
    }

}