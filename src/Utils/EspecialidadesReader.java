package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class EspecialidadesReader {

    public EspecialidadesReader() {
    }

   static JSONParser parser = new JSONParser();
    static final String fileName = "src/assets/especialidades.json";

    public static Object[] getEspecialidades() {

        try (Reader reader = new FileReader(fileName)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray jsonArray = (JSONArray) jsonObject.get("especialidades");

            return jsonArray.toArray();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Parsing: " + fileName;
    }
}
