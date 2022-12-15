package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
	@DataProvider(name = "invalidCredentials")
	public static Object dataset() {
		Object[][] objects = { { "01811111111", "pass", "Error", "Incorrect username or password." },
				{ "01888888888888", "pass", "Error", "Please enter a valid phone number." },
				{ "018666", "pass", "Error", "Please enter a valid phone number." } };

		return objects;

	}

}
