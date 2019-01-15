
/**
 * 
 */
import com.zubiri.User.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ik013043z1
 *
 */
public class MainMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int loggedIndex = -1;
		boolean finish = false;

		File database = new File("C:\\Users\\ik013043z1\\Desktop\\UserInfo.txt");

		Scanner databaseScanner = new Scanner("C:\\Users\\ik013043z1\\Desktop\\UserInfo.txt");

		ArrayList<User> users = new ArrayList<User>();

		while (databaseScanner.hasNextLine()) {

			String userData = databaseScanner.nextLine();

			String[] separatedUserData = userData.split(" ");

			String username = separatedUserData[0];
			
			User user = new User(username, "1234abcd=");


			//String password = separatedUserData[1];

			//User user = new User(username, password);

			users.add(user);

		}

		while (!finish) {

			System.out.println("Welcome to the log in / register aplication\n" + "What do you want to do?\n"
					+ "\t1- Register\n" + "\t2- Situation\n" + "\t3- Log In\n" + "\t4- Log Out\n" + "\t5- Finish");

			int option = sc.nextInt();
			sc.nextLine();

			switch (option) {

			case 1:

				boolean registered = false;

				while (!registered) {

					System.out.println("Please enter the username and the password you want to use\n");

					String data = sc.nextLine();

					String separateData[] = data.split(" ");

					String username = separateData[0];

					String password = separateData[1];

					User user2 = new User();

					switch (user2.register(username, password)) {

					case -2:

						System.out.println("Invalid username, it must only have letters\n");

						break;

					case -1:

						System.out.println(
								"Invalid password, it must have at least a number, a letter, a symbol and a lenght of 8 characters\n");

						break;
					case 0:

						System.out.println("Your username has been registered\n");

						users.add(user2);

						try {
							// Create a FileWriter with the path of the file we want to write in
							FileWriter fw = new FileWriter(database);
							// Write the scanned text in the file
							fw.write(username + " " + password);

							// Close the writer
							fw.close();

							// ...and if any exception appears...
						} catch (Exception e) {
							// ...print a message with the error
							System.err.println("Error: " + e.getMessage());
						}

						registered = true;

						break;

					case 1:

						System.out.println("Invalid username and password\n" + "\tUsername: it must only have letters\n"
								+ "\tPassword:it must have at least a number, a letter, a symbol and a lenght of 8 characters ");

						break;

					}

				}

			case 2:

				if (loggedIndex != -1) {

					System.out.println("You are loged in as " + users.get(loggedIndex).getUsername() + "\n");

				}

				else {

					System.out.println("You are not logged in\n");

				}

				break;

			case 3:

				System.out.println("Please enter the username and the password\n");

				String data = sc.nextLine();

				String separateData[] = data.split(" ");

				String username = separateData[0];

				String password = separateData[1];

				for (int i = 0; i < users.size(); i++) {

					if (users.get(i).logIn(username, password)) {

						loggedIndex = i;

						System.out.println("You are now loged in as " + users.get(i).getUsername() + "\n");
					}
				}
				break;

			case 4:

				loggedIndex = -1;

				System.out.println("You are now logged out");

				break;

			case 5:

				finish = true;

				break;

			}

		}
	}

}
