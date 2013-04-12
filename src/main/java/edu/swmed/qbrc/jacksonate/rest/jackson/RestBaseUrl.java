package edu.swmed.qbrc.jacksonate.rest.jackson;

import com.google.inject.Inject;

public class RestBaseUrl {
	
	private final String value;
	private final String packageUrl;
	
	@Inject
	public RestBaseUrl(final String value, final String packageUrl) {
		this.value = value;
		this.packageUrl = packageUrl;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getPackageUrl() {
		return packageUrl;
	}
	
}