
public class App {

    public static boolean isValidPassword(String password) 
    {
        
        if (password.length() < 8 || password.length() > 16) 
        {
            return false;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        String lowerCasePattern = ".*[a-z].*";
        String upperCasePattern = ".*[A-Z].*";
        String digitPattern = ".*[0-9].*";
        String specialPattern = ".*[~!@#$%^&*()\\-=+_].*";

        if (password.matches(lowerCasePattern)) 
        {
            hasLower = true;
        }
        if (password.matches(upperCasePattern)) 
        {
            hasUpper = true;
        }
        if (password.matches(digitPattern)) 
        {
            hasDigit = true;
        }
        if (password.matches(specialPattern)) 
        {
            hasSpecial = true;
        }

        int categoryCount = 0;
        if (hasLower) categoryCount++;
        if (hasUpper) categoryCount++;
        if (hasDigit) categoryCount++;
        if (hasSpecial) categoryCount++;

        return categoryCount >= 3;
    }

    public static void main(String[] args) 
    {
        String[] testPasswords = 
        {
            "Password123!",   
            "password123",    
            "12345678",       
            "Password@",      
            "Pass123",        
            "Pass1234567890@",
            "P@ssword1"       
        };

        
        for (String password : testPasswords) 
        {
            System.out.println("Password: \"" + password + "\" is " + (isValidPassword(password) ? "valid" : "invalid"));
        }
    }
}

