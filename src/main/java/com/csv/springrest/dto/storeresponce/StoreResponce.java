package com.csv.springrest.dto.storeresponce;

public class StoreResponce {
	
private boolean error;
private String msg;
private Object data;
public boolean isError() {
	return error;
}
public void setError(boolean error) {
	this.error = error;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
@Override
public String toString() {
	return "StoreResponce [error=" + error + ", msg=" + msg + ", data=" + data + "]";
}
public StoreResponce(boolean error, String msg, Object data) {
	super();
	this.error = error;
	this.msg = msg;
	this.data = data;
}
public StoreResponce() {
	super();
}

}
