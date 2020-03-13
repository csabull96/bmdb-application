package com.example.bmdb.app;

import com.example.bmdb.app.App;
import com.example.bmdb.database.Database;
import com.example.bmdb.service.Service;

public class Client {
	public static void main(String[] args) {
		Database database = new Database();
		Service service = new Service(database);
		View view = new View();
		App application = new App(service, view);
		application.play();
	}
}
