package org.primefaces.examples.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="prodBean")
@SessionScoped
public class ProductCatBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String url;

	public ProductCatBean() {

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String sendRedirect() {
		return "/test.xhtml?faces-redirect=true";
	}
}
