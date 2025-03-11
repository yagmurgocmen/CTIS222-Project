package MainAndSystemClasses;

import java.awt.print.Book;
import java.io.FileNotFoundException;

import GUI.*;

public class BookITMain {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		BookITSys.readBooks();
		BookITSys.readUsers();
		HomePage hp = new HomePage();
		hp.setVisible(true);
	}

}