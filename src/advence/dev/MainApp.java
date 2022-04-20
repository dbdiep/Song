package advence.dev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainApp {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://625febea53a42eaa07fd62b3.mockapi.io/api/v1/song/songs");
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			int code = urlConnection.getResponseCode();
			if (code != 200) {
				throw new IOException("" + code);
			}
			BufferedReader rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			StringBuffer strBuff = new StringBuffer();
			
			String line;
			while((line = rd.readLine()) != null) {
				strBuff.append(line);
			}
			convertJsonToDto(strBuff.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void convertJsonToDto(String json) {
		List<SongDTO> listDto = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(json);
		for (int i=0; i < jsonArray.length(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
		}
		
	}
}
