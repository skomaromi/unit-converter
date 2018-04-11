package com.github.skomaromi.unitconverter;

public class UnitConverter {
    public static double Convert(String srcType, double srcValue, String destType) {
        double destValue = 0, siValue = 0,
               kmh, g, degC;

        // length
        switch(srcType) {
            case "m":
                siValue = srcValue;
                break;
            case "mm":
                siValue = srcValue / 1000;
                break;
            case "in":
                siValue = srcValue * 0.0254;
                break;
            case "ft":
                siValue = srcValue * 0.3048;
                break;
            case "mi":
                siValue = srcValue * 1609.344;
                break;
        }

        switch(destType) {
            case "m":
                destValue = siValue;
                break;
            case "mm":
                destValue = siValue * 1000;
                break;
            case "in":
                destValue = siValue / 0.0254;
                break;
            case "ft":
                destValue = siValue / 0.3048;
                break;
            case "mi":
                destValue = siValue / 1609.344;
                break;
        }


        // speed
        switch(srcType) {
            case "m/s":
                siValue = srcValue;
                break;
            case "km/h":
                siValue = srcValue / 3.6;
                break;
            case "mph":
                siValue = srcValue * 0.44704;
                break;
            case "kn":
                kmh = srcValue * 1.852;
                siValue = kmh / 3.6;
                break;
            case "ft/s":
                siValue = srcValue * 0.3048;
                break;
        }

        switch(destType) {
            case "m/s":
                destValue = siValue;
                break;
            case "km/h":
                destValue = siValue * 3.6;
                break;
            case "mph":
                destValue = siValue / 0.44704;
                break;
            case "kn":
                kmh = siValue * 3.6;
                destValue = kmh / 1.852;
                break;
            case "ft/s":
                destValue = siValue / 0.3048;
                break;
        }


        // mass
        switch(srcType) {
            case "kg":
                siValue = srcValue;
                break;
            case "t":
                siValue = srcValue * 1000;
                break;
            case "lb":
                siValue = srcValue * 0.45359237;
                break;
            case "oz":
                g = srcValue * 28.349523125;
                siValue = g / 1000;
                break;
        }

        switch(destType) {
            case "kg":
                destValue = siValue;
                break;
            case "t":
                destValue = siValue / 1000;
                break;
            case "lb":
                destValue = siValue / 0.45359237;
                break;
            case "oz":
                g = siValue * 1000;
                destValue = g / 28.349523125;
                break;
        }


        // temperature
        switch(srcType) {
            case "K":
                siValue = srcValue;
                break;
            case "\u00b0C":
                siValue = srcValue + 273.15;
                break;
            case "\u00b0F":
                degC = (srcValue - 32.0) * (5.0 / 9.0);
                siValue = degC + 273.15;
                break;
            case "\u00b0R":
                degC = (srcValue - 491.67) * (5.0 / 9.0);
                siValue = degC + 273.15;
                break;
        }

        switch(destType) {
            case "K":
                destValue = siValue;
                break;
            case "\u00b0C":
                destValue = siValue - 273.15;
                break;
            case "\u00b0F":
                degC = siValue - 273.15;
                destValue = degC * (9.0 / 5.0) + 32.0;
                break;
            case "\u00b0R":
                degC = siValue - 273.15;
                destValue = (degC + 273.15) * (9.0 / 5.0);
                break;
        }

        return destValue;
    }
}
