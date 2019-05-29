package bootcamp.mii.bootcamp.mii;

import bootcamp.mii.bootcamp.mii.testapi.JSONService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
                JSONService jsons = new JSONService();
                System.out.println("JSON OBJECT ===================================");
                System.out.println(jsons.getJsonObject("http://localhost:8088/json/actor/all/get").deepCopy());
                System.out.println("JSON OBJECT ===================================");
                System.out.println("JSON ELEMENT ===================================");
                System.out.println(jsons.getJsonElement("http://localhost:8088/json/actor/all/get"));
                System.out.println("JSON ELEMENT ===================================");
	}

}
