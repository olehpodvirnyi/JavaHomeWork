package internationalization;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.*;

import static java.lang.System.out;
import static java.text.DateFormat.FULL;
import static java.util.Locale.*;
import static java.util.ResourceBundle.*;

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
                bundle = getBundle(FOLDER);
                break;
            case 2:
                bundle = getBundle(FOLDER, FRANCE);
                break;
            case 3:
                bundle = getBundle(FOLDER, new Locale("sv", "SE"));
                break;
            default:
                out.println();
                bundle = getBundle(FOLDER);
        }
        printMessages(bundle);
    }

    private static void printMessages(ResourceBundle bundle) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(FULL, FULL, bundle.getLocale());
        out.println("CountryName : " + bundle.getString("COUNTRY_NAME") + bundle.getLocale());
        out.println("CurrencyCode: " + bundle.getString("CURRENCY_CODE"));
        out.println("Today: " + dateFormat.format(new Date()));
        out.println("Base currency: " + Currency.getInstance(bundle.getLocale()).getDisplayName() + ", " +
                NumberFormat.getCurrencyInstance(bundle.getLocale()).format(1));
    }

}