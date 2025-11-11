import java.util.Scanner; // Import the Scanner class to read user input

class FuelCosts {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double gallonsOfGas;
        double fuelEfficiencyMilesPerGallon;
        double priceOfGasPerGallon;

        System.out.print("Enter the number of gallons of gas in the tank: ");
        gallonsOfGas = input.nextDouble();

        System.out.print("Enter the fuel efficiency in miles per gallon: ");
        fuelEfficiencyMilesPerGallon = input.nextDouble();

        System.out.print("Enter the price of gas per gallon: ");
        priceOfGasPerGallon = input.nextDouble();

        input.close();

        double totalCostOfGasInTank = gallonsOfGas * priceOfGasPerGallon;
        System.out.println("Total cost of gas in the tank: $" + String.format("%.2f", totalCostOfGasInTank));

        double totalMilesCanTravel = gallonsOfGas * fuelEfficiencyMilesPerGallon;
        System.out.println("Total miles the car can travel with current gas: " + String.format("%.2f", totalMilesCanTravel) + " miles");
    }
}