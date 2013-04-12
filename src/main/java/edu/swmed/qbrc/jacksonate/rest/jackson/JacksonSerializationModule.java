package edu.swmed.qbrc.jacksonate.rest.jackson;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.reflections.Reflections;

public abstract class JacksonSerializationModule extends SimpleModule {
	
	public JacksonSerializationModule(final ReflectionFactory reflectionFactory, final Reflections reflections, final RestBaseUrl restBaseUrl) {
		super("JacksonSerializationModule", new Version(1, 0, 0, null));
	}
	
}