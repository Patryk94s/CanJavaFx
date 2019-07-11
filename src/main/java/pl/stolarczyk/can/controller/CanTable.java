package pl.stolarczyk.can.controller;

import javafx.beans.property.SimpleStringProperty;

public class CanTable {

	private final SimpleStringProperty id;
	private final SimpleStringProperty ext;
	private final SimpleStringProperty rtr;

	private final SimpleStringProperty length;

	private final SimpleStringProperty data;

	public CanTable(String id, String ext, String rtr, String length, String data) {
		super();
		this.id = new SimpleStringProperty(id);
		this.ext = new SimpleStringProperty(ext);
		this.rtr = new SimpleStringProperty(rtr);
		this.length = new SimpleStringProperty(length);
		this.data = new SimpleStringProperty(data);
	}

	public String getId() {
		return id.get();
	}

	public String getLength() {
		return length.get();
	}

	public String getData() {
		return data.get();
	}

	public String getExt() {
		return ext.get();
	}

	public String getRtr() {
		return rtr.get();
	}

}
