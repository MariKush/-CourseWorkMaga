package org.masha.utils;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Utility {
    private Utility() {
    }

    public static String toPriceFormat(int price) {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(' ');

        DecimalFormat formatter = new DecimalFormat("###,###.##", symbols);
        return formatter.format(price) + " ₴";
    }
}
