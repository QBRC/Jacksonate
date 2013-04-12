package edu.swmed.qbrc.jacksonate.rest.datapackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import edu.swmed.qbrc.jacksonate.rest.datapackage.DataPackage.DataPackageClass;

@DataPackageClass(url="/datapackage.json")
public class DataPackage {
	
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
