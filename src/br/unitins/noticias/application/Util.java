package br.unitins.noticias.application;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {
	public static void addInfoMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(" ",new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	public static void addWarnMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(" ",new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
	}

	public static void addErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(" ",new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}

}
