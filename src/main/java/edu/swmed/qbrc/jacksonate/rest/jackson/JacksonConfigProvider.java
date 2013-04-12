package edu.swmed.qbrc.jacksonate.rest.jackson;

import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.codehaus.jackson.map.ObjectMapper;
import com.google.inject.Inject;

@Provider
@Produces("application/json")
public class JacksonConfigProvider implements ContextResolver<ObjectMapper> {

	private ObjectMapper objectMapper;

	@Inject
	public JacksonConfigProvider(final JacksonSerializationModule jacksonSerializationModule) {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.registerModule(jacksonSerializationModule);
	}
	
	@Override
	public ObjectMapper getContext(Class<?> objectType) {
		return objectMapper;
	}
	
}