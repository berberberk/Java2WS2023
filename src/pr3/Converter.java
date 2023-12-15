package pr3;
import java.util.HashMap;

public class Converter {
    private String inputCurrency;
    private String outputCurrency;
    private double inputValue;
    private double outputValue;
    private HashMap<String, Double> Currencies;
    public Converter(String inputCurrency, String outputCurrency, double inputValue) {
        Currencies = new HashMap<>();{
            Currencies.put("USD", 1.);
            Currencies.put("RUB", .01);
            Currencies.put("EUR", 1.07);
            Currencies.put("GBP", 1.23);
            Currencies.put("СNY", .14);
            Currencies.put("GEL", .37);
            Currencies.put("KZT", .0021);
            Currencies.put("AMD", .0026);
        }
        this.inputCurrency = inputCurrency;
        this.outputCurrency = outputCurrency;
        this.inputValue = inputValue;
    }
    public double convert() {
        this.outputValue = (inputValue * this.Currencies.get(inputCurrency)) / this.Currencies.get(outputCurrency);
        return outputValue;
    }
    @Override
    public String toString() {
        return ("" + this.inputValue + " " + this.inputCurrency + " = " + this.convert() + " " + this.outputCurrency);
    }
}
