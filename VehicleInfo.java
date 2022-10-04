import java.util.Scanner;

public class VehicleInfo {
    
    public static final String WELCOME_MESSAGE = "Welcome to the VehicleInfo program!";
    public static final String MAKE_PROMPT = "What is the vehicle's make?";
    public static final String MODEL_PROMPT = "What is the vehicle's model?";
    public static final String COUNTRY_PROMPT = "Where was the vehicle manufactured?";
    public static final String PRICE_PROMPT = "What was the price (in Dollars) of the vehicle?";
    public static final String DURATION_PROMPT = "How many years has the vehicle been owned for?";
    public static final String VEHICLE_TYPE_PROMPT = "Is the vehicle a car, van, truck, or motorcycle?";
    public static final String PURCHASE_TYPE_PROMPT = "Was the vehicle purchased new or pre-owned?";
    public static final String USER_COUNT_PROMPT = "How many people regularly drive/ride this vehicle?";
    public static final String ITH_PERSON_PROMPT = "What is the name of person number ";
    public static final String REPAIR_COUNT_PROMPT = "How many times did the vehicle need to be repaired?";
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println(WELCOME_MESSAGE);
        System.out.println(MAKE_PROMPT);
        String make = scan.nextLine();
        System.out.println(MODEL_PROMPT);
        String model = scan.nextLine();
        System.out.println(COUNTRY_PROMPT);
        String country = scan.nextLine();
        System.out.println(PRICE_PROMPT);
        float price = scan.nextFloat();
        System.out.println(DURATION_PROMPT);
        int years = scan.nextInt();
        scan.nextLine();
        System.out.println(VEHICLE_TYPE_PROMPT);
        String type = scan.nextLine();
        System.out.println(PURCHASE_TYPE_PROMPT);
        String purchased = scan.nextLine();
        System.out.println(USER_COUNT_PROMPT);
        int users = scan.nextInt();
        scan.nextLine();
        String[] theUsers = new String[users];
        for (int i = 0; i < users; i++){
            int x = i + 1;
            System.out.println(ITH_PERSON_PROMPT + x);
            String currentPerson = scan.nextLine();
            theUsers[i] = currentPerson;
        }
        System.out.println(REPAIR_COUNT_PROMPT);
        int repair = scan.nextInt();
        
        String one = make.toUpperCase().substring(0,1);
        String two = model.toUpperCase().substring(0,1);
        
        String three = country.toUpperCase().substring(0,2);
        String four = country.toUpperCase().substring(country.length()-2);
        
        String five = "";
        
        if (price <= 10000.00){
            five = "LOW";    
        }
        
        else if (price < 40000.00 && price > 10000.00){
            five = "MID";    
        }
        
        else if (price > 40000.00){
            five = "HIGH";    
        }
        
        String six = String.valueOf(years);
        String seven = type.toLowerCase();
        
        String eight = "";
        
        if (purchased.toLowerCase().equals("new")){
            eight = "N";    
        }
        
        else if (purchased.toLowerCase().equals("pre-owned")){
            eight = "PO";
        }
        
        String nine = "{";
        
        for (int d = 0; d < theUsers.length; d++){
            if (d == theUsers.length - 1){
                nine = nine + theUsers[d];    
            }
            else{
                nine = nine + theUsers[d] + ", "; 
            }
        }
        
        nine = nine + "}";
        
        String ten = "";
        if (repair <= 2){
            ten = "EXCELLENT";            
        }
        
        else if (repair > 2 && repair <= 8){
            ten = "AVERAGE";    
        }
        
        else if (repair > 8){
            ten = "POOR";    
        }
        
        System.out.println(one + two + "_" + three + four + "_" + five + "_" + six + "_" + seven + "_" + eight + nine + "_" + ten + ";");  
    }

}
