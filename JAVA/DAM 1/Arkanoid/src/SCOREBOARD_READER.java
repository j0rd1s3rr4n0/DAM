import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SCOREBOARD_READER {
	private String scoreboard_path; // = "scoreboard.json"
	private JSONObject jsonobject;
	private JSONArray datos;
	
	public SCOREBOARD_READER(String scoreboard_path) {
		this.scoreboard_path = scoreboard_path;
		try {
			FileReader lectura = new FileReader(scoreboard_path);
			JSONParser parser = new JSONParser();
			jsonobject = (JSONObject) parser.parse(lectura);
			datos = (JSONArray) jsonobject.get("data");
		} catch (Exception e) {e.printStackTrace();}
	}
	
	
	//RETORNA ARRAY DE STRINGS DE LOS USUARIOS GUARDADOS
	public String[] getusers() {
		String[] names = new String[datos.size()];
		for(int i=0;i<datos.size();i++) {
			JSONObject user = (JSONObject) datos.get(i);
			names[i] = (String) user.get("name");
		}
		return names;
	}
	
	
	public int getpoints(String username) {
		try {
			for(int i=0;i<datos.size();i++) {
				JSONObject user = (JSONObject) datos.get(i);
				String name  = (String) user.get("name");
				if(name.equals(username)) {
					int points = Integer.valueOf(String.valueOf(user.get("score")));
					return points;
				}
			}
		}catch(Exception e) {
			e.getStackTrace();
			return -1;
		}
		return -1;
	}
	
	// MODIFICAR DATOS

	public JSONObject getUserJsonObject(String username) {
		for (int i = 0; i < datos.size(); i++) {
			JSONObject name_jsonobject = (JSONObject) datos.get(i);
			if(String.valueOf(name_jsonobject.get("name")).equalsIgnoreCase(username)) {
				return name_jsonobject;
			}
		}
	return null;
	}

	// VALE PARA CREAR Y GUARDAR DATOS
	// SOLO SE ACTUALIZA EN CODIGO
	@SuppressWarnings("unchecked")
	public void saveUser(String username, int points) {
		JSONObject user = getUserJsonObject(username);
		
		if(user == null) {
			//TODO CREAR USUARIO
			user = new JSONObject();
			user.put("name",username);
			user.put("score",points);
			// añade el json object al datos
			datos.add(user);
		}else {
			//ACTUALIZAR PUNTUACION
			user.put("score",points);
		}
		
		// AQUI ESCRIBIMOS AL ARCHIVO
		try {
			FileWriter escriptura = new FileWriter(scoreboard_path);
			// ESCRIBE EN 
			escriptura.write(jsonobject.toJSONString());
			// CIERRA EL ARCHIVO
			escriptura.close();
			
		}catch(Exception e) {e.printStackTrace();}
	}
}
