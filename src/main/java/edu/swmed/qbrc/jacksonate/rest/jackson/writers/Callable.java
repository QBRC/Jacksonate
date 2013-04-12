package edu.swmed.qbrc.jacksonate.rest.jackson.writers;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;

public interface Callable<T> {
	public void call(Object param, JsonGenerator jgen) throws JsonGenerationException, IOException;
}
