package com.zubiri.User;

public class User {

	private String username = "UserName";
	private String password = "1234abcd=";

	/**
	 * There is a default user (UserName) With a default password (1234abcd=)
	 */
	public User() {
	}

	public User(String username, String password) {

		if (validUsername(username))

			this.username = username;

		if (validPassword(password))

			this.password = password;

	}

	public void setUsername(String username) {

		if (!username.matches("[a-zA-Z]+")) {
			this.username = username;
		}


	}

	public String getUsername() {

		return username;

	}

	public void setPassword(String password) {

		if (!password.matches("[a-zA-Z]+") && !password.matches("[0-9]+") && !password.matches("[a-zA-Z0-9]+")
				&& password.length() > 7)

			this.password = password;

	}

	public String getPassword() {

		return password;

	}

	/**
	 * 
	 * @param String username. The name that the user is going to have
	 * @param String password. The password that the user is going to have
	 * @return -2: invalid username, -1: invalid password, 0: succesfully
	 *         registered, 1: invalid username and password
	 */

	public int register(String username, String password) {

		int valid = 0;

		if (validUsername(username) && validPassword(password)) {

			this.username = username;
			this.password = password;

			valid = 0;

		} else if (!validUsername(username) && validPassword(password)) {

			valid = -2;

		}

		else if (validUsername(username) && !validPassword(password)) {

			valid = -1;

		}

		else {

			valid = 1;

		}

		return valid;

	}

	/**
	 * 
	 * @param String username: the username to check if it is valid to create a user
	 * @return boolean true: valid, false, invalid
	 */

	public boolean validUsername(String username) {

		boolean validUserneme = true;

		if (!username.matches("[a-zA-Z]+")) {

			validUserneme = false;

		}

		return validUserneme;

	}

	/**
	 * 
	 * @param String password: the password to check if it is valid to create a user
	 * @return boolean true: valid, false, invalid
	 */

	public boolean validPassword(String password) {

		boolean validPassword = false;

		if (!password.matches("[a-zA-Z]+") && !password.matches("[0-9]+") && !password.matches("[a-zA-Z0-9]+")
				&& password.length() > 7) {

			validPassword = true;

		}

		return validPassword;

	}

	/**
	 * 
	 * @param String username
	 * @param String password
	 * @return boolean true: logged in false: username and/or password
	 */

	public boolean logIn(String username, String password) {

		boolean logged = false;

		if (username.matches(this.username) && password.matches(this.password))

			logged = true;

		return logged;

	}

}
