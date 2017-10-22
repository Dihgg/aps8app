package unicluster.unip.br.aps8.models;

import org.json.JSONException;
import org.json.JSONObject;

import unicluster.unip.br.aps8.R;
import unicluster.unip.br.aps8.utils.Utils;

public class Line {

	// VARIABLES
	private String name;
	private String color;
	private int number;

	// CONSTRUCTORS
	public Line(JSONObject data) throws JSONException {
		this.name = data.getString("name");
		this.color = data.getString("color");
		this.number = data.getInt("number");
	}
	public  Line(String name, String color , int number) {
		this.name = name;
		this.color = color;
		this.number = number;
	}
	// PUBLIC FUNCTIONS
	public int getColorId() {
		try {
			String id = "metro_" + Utils.stripAccents(this.color).toLowerCase();
			return R.color.class.getField(id).getInt(null);
		} catch (Exception e) {
			return android.R.color.black;
		}
	}
	// GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
