package de.appwerft.remotexml;

import org.appcelerator.kroll.common.Log;
import org.json.JSONException;

public class JSON {
	final static String LCAT = "importJSON  🌀️";

	public static Object toJSON(Object value) {
		try {
			if (value instanceof org.json.jsonjava.JSONObject) {
				// Copy if node is object
				org.json.jsonjava.JSONObject foo = (org.json.jsonjava.JSONObject) value;
				org.json.JSONObject bar = new org.json.JSONObject();
				for (String key : foo.keySet()) {
					bar.put(key, toJSON(foo.get(key)));
				}
				Log.d(LCAT + "O", bar.toString());
				return bar;
			} else if (value instanceof org.json.jsonjava.JSONArray) {
				// Copy if node is array
				org.json.jsonjava.JSONArray foo = (org.json.jsonjava.JSONArray) value;
				org.json.JSONArray bar = new org.json.JSONArray();
				for (int i = 0; i < foo.length(); i++) {
					bar.put(toJSON(foo.get(i)));
				}
				Log.d(LCAT + "A", bar.toString());
				return bar;
			} else if (value == org.json.jsonjava.JSONObject.NULL) {
				return null;
			} else if (value instanceof String) {
			}
		} catch (JSONException e) {
			Log.e(LCAT, e.getMessage());
		}

		return value;
	}
}
