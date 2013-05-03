package edu.swmed.qbrc.jacksonate.rest.jackson;

import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties({"fields"})
public class TableJSONContainer<T> {
	
	private List<T> data;
	private Class<?> clazz;
	
	public TableJSONContainer(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public TableJSONContainer(Class<?> clazz, List<T> data) {
		this.clazz = clazz;
		this.data = data;
	}
	
	public Class<?> getListClass() {
		return clazz;
	}
	
	public List<T> getData() {
		return this.data;
	}
	
	public void setData(List<T> list) {
		this.data = list;
	}
	
}  