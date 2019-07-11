package pl.stolarczyk.can.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CanFrame {

	private StringProperty sendAarea = new SimpleStringProperty();

	private StringProperty fieldCanID = new SimpleStringProperty();

	private BooleanProperty booleanFieldCanID = new SimpleBooleanProperty(false);
	private BooleanProperty booleanFieldByte1 = new SimpleBooleanProperty(true);
	private BooleanProperty booleanFieldByte2 = new SimpleBooleanProperty(true);
	private BooleanProperty booleanFieldByte3 = new SimpleBooleanProperty(true);
	private BooleanProperty booleanFieldByte4 = new SimpleBooleanProperty(true);
	private BooleanProperty booleanFieldByte5 = new SimpleBooleanProperty(true);
	private BooleanProperty booleanFieldByte6 = new SimpleBooleanProperty(true);
	private BooleanProperty booleanFieldByte7 = new SimpleBooleanProperty(true);
	private BooleanProperty booleanFieldByte8 = new SimpleBooleanProperty(true);

	public BooleanProperty getBooleanFieldByte1() {
		return booleanFieldByte1;
	}

	public void setBooleanFieldByte1(BooleanProperty booleanFieldByte1) {
		this.booleanFieldByte1 = booleanFieldByte1;
	}

	public BooleanProperty getBooleanFieldByte2() {
		return booleanFieldByte2;
	}

	public void setBooleanFieldByte2(BooleanProperty booleanFieldByte2) {
		this.booleanFieldByte2 = booleanFieldByte2;
	}

	public BooleanProperty getBooleanFieldByte3() {
		return booleanFieldByte3;
	}

	public void setBooleanFieldByte3(BooleanProperty booleanFieldByte3) {
		this.booleanFieldByte3 = booleanFieldByte3;
	}

	public BooleanProperty getBooleanFieldByte4() {
		return booleanFieldByte4;
	}

	public void setBooleanFieldByte4(BooleanProperty booleanFieldByte4) {
		this.booleanFieldByte4 = booleanFieldByte4;
	}

	public BooleanProperty getBooleanFieldByte5() {
		return booleanFieldByte5;
	}

	public void setBooleanFieldByte5(BooleanProperty booleanFieldByte5) {
		this.booleanFieldByte5 = booleanFieldByte5;
	}

	public BooleanProperty getBooleanFieldByte6() {
		return booleanFieldByte6;
	}

	public void setBooleanFieldByte6(BooleanProperty booleanFieldByte6) {
		this.booleanFieldByte6 = booleanFieldByte6;
	}

	public BooleanProperty getBooleanFieldByte7() {
		return booleanFieldByte7;
	}

	public void setBooleanFieldByte7(BooleanProperty booleanFieldByte7) {
		this.booleanFieldByte7 = booleanFieldByte7;
	}

	public BooleanProperty getBooleanFieldByte8() {
		return booleanFieldByte8;
	}

	public void setBooleanFieldByte8(BooleanProperty booleanFieldByte8) {
		this.booleanFieldByte8 = booleanFieldByte8;
	}

	private StringProperty propertyByte1 = new SimpleStringProperty();
	private StringProperty propertyByte2 = new SimpleStringProperty();
	private StringProperty propertyByte3 = new SimpleStringProperty();
	private StringProperty propertyByte4 = new SimpleStringProperty();
	private StringProperty propertyByte5 = new SimpleStringProperty();
	private StringProperty propertyByte6 = new SimpleStringProperty();
	private StringProperty propertyByte7 = new SimpleStringProperty();
	private StringProperty propertyByte8 = new SimpleStringProperty();

	public StringProperty getSendAarea() {
		return sendAarea;
	}

	public void setSendAarea(StringProperty sendAarea) {
		this.sendAarea = sendAarea;
	}

	public StringProperty getFieldCanID() {
		return fieldCanID;
	}

	public void setFieldCanID(StringProperty fieldCanID) {
		this.fieldCanID = fieldCanID;
	}

	public BooleanProperty getBooleanFieldCanID() {
		return booleanFieldCanID;
	}

	public void setBooleanFieldCanID(BooleanProperty booleanFieldCanID) {
		this.booleanFieldCanID = booleanFieldCanID;
	}

	public StringProperty getPropertyByte2() {
		return propertyByte2;
	}

	public void setPropertyByte2(StringProperty propertyByte2) {
		this.propertyByte2 = propertyByte2;
	}

	public StringProperty getPropertyByte3() {
		return propertyByte3;
	}

	public void setPropertyByte3(StringProperty propertyByte3) {
		this.propertyByte3 = propertyByte3;
	}

	public StringProperty getPropertyByte4() {
		return propertyByte4;
	}

	public void setPropertyByte4(StringProperty propertyByte4) {
		this.propertyByte4 = propertyByte4;
	}

	public StringProperty getPropertyByte5() {
		return propertyByte5;
	}

	public void setPropertyByte5(StringProperty propertyByte5) {
		this.propertyByte5 = propertyByte5;
	}

	public StringProperty getPropertyByte6() {
		return propertyByte6;
	}

	public void setPropertyByte6(StringProperty propertyByte6) {
		this.propertyByte6 = propertyByte6;
	}

	public StringProperty getPropertyByte7() {
		return propertyByte7;
	}

	public void setPropertyByte7(StringProperty propertyByte7) {
		this.propertyByte7 = propertyByte7;
	}

	public StringProperty getPropertyByte8() {
		return propertyByte8;
	}

	public void setPropertyByte8(StringProperty propertyByte8) {
		this.propertyByte8 = propertyByte8;
	}

	public StringProperty getPropertyByte1() {
		return propertyByte1;
	}

	public void setPropertyByte1(StringProperty propertyByte1) {
		this.propertyByte1 = propertyByte1;
	}

}
