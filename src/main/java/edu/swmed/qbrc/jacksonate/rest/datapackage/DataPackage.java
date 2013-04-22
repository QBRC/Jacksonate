package edu.swmed.qbrc.jacksonate.rest.datapackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import edu.swmed.qbrc.jacksonate.rest.datapackage.DataPackage.DataPackageClass;

@DataPackageClass(url="/datapackage.json")
public class DataPackage {

	private final String name;
	private final String title;
	private final String description;
	
	public DataPackage(final String name, final String title, final String description) {
		this.name = name;
		this.title = title;
		this.description = description;
	}
	
	
	public String getName() {
		return name;
	}


	public String getTitle() {
		return title;
	}


	public String getDescription() {
		return description;
	}


	@Retention(RetentionPolicy.RUNTIME)
	public @interface DataPackageClass {
		String url();
	}	

	@Retention(RetentionPolicy.RUNTIME)
	public @interface DataPackageForeignKey {
		Class<?> foreignClass();
		String keyField() default "id";
	}	

}
