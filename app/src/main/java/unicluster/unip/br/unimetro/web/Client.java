package unicluster.unip.br.unimetro.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import unicluster.unip.br.unimetro.constants.Api;

public class Client {

	private String execute(String _url) {
		try {
			URL url = new URL(_url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.connect();

			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuilder sb = new StringBuilder();

			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();

			return sb.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String update() {
		return execute(Api.UPDATE);
	}

	public String status() {
		return execute(Api.STATUS);
	}

	public  String status(int line) { return execute(Api.STATUS + "?line=" + line); }

	public  String logs() {
		return execute(Api.LOGS);
	}

	public  String logs(int line) {
		return execute(Api.LOGS + "?line=" + line);
	}
}
