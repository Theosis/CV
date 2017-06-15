
public class Email {
	//TODO: Use real-world validator for email address format, 
	//		then test they are real against mail server.
}

/*
 * Apache validator - good but slow RegEx
 * 
import org.apache.commons.validator.EmailValidator;
public class Email {

EmailValidator validator = EmailValidator.getInstance();
if (validator.isValid(email)) {
   // is valid, do something
} else {
   // is invalid, do something
}
}
*/

/*
 * 
 * Best email validator - deferring its use for simplicity
 * as it would require dealing with IDE configuration issues.
 *
 *
import javax.mail.Address;
public class Email {
	public static boolean validEmail(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}
}
*/