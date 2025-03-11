package Is_A_Classes;

import java.util.HashSet;

import MainAndSystemClasses.BookITSys;
import Has_A_Classes.*;

public class Admin extends User {	
	public Admin() {
		super();
	}

    public Admin(int userID, String name, String email, String password, String userType) {
        super(userID, name, email, password, userType);
    }

	@Override
	public String toString() {
		return super.toString();
	}
    
}