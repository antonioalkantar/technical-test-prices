package com.indra.inditex.prices.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * @author Antonio Alcantar Valencia
 *
 */
public class Response <T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6572069479971752600L;

	private HttpStatus code;
	private String message;
	private List<T> data;
	
	/**
	 * @return the code
	 */
	public HttpStatus getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(HttpStatus code) {
		this.code = code;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
