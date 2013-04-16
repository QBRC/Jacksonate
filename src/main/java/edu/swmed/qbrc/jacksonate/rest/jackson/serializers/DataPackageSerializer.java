package edu.swmed.qbrc.jacksonate.rest.jackson.serializers;

import java.io.IOException;
import java.util.Set;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.reflections.Reflections;

import edu.swmed.qbrc.jacksonate.rest.datapackage.DataPackage;
import edu.swmed.qbrc.jacksonate.rest.datapackage.DataPackage.DataPackageClass;
import edu.swmed.qbrc.jacksonate.rest.jackson.JacksonUtils;
import edu.swmed.qbrc.jacksonate.rest.jackson.ReflectionFactory;
import edu.swmed.qbrc.jacksonate.rest.jackson.RestBaseUrl;

public class DataPackageSerializer extends JsonSerializer<DataPackage> {

	private final ReflectionFactory reflectionFactory;
	private final Reflections reflections;
	private final RestBaseUrl restBaseUrl;
	
	public DataPackageSerializer(final ReflectionFactory reflectionFactory, final Reflections reflections, final RestBaseUrl restBaseUrl) {
		this.reflectionFactory = reflectionFactory;
		this.reflections = reflections;
		this.restBaseUrl = restBaseUrl;
	}

	@Override
	public void serialize(DataPackage dataPackage, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		
		Set<Class<?>> classes = reflections.getTypesAnnotatedWith(DataPackageClass.class);
		
		jgen.writeStartObject();
		jgen.writeArrayFieldStart("resources");
		for (Class<?> annotated : classes) {
			DataPackageClass dp = annotated.getAnnotation(DataPackageClass.class);
			jgen.writeStartObject();
			jgen.writeStringField("path", dp.url().replaceAll("^/", ""));
			jgen.writeStringField("id", annotated.getSimpleName());
			jgen.writeObjectFieldStart("schema");
			JacksonUtils.writeJSONSchema(annotated, jgen, reflectionFactory, restBaseUrl);
			jgen.writeEndObject();
			jgen.writeEndObject();
		}
		jgen.writeEndArray();
		jgen.writeEndObject();

	}
}
