package edu.swmed.qbrc.jacksonate.rest.jackson.writers;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;

public class FloatWriter implements Callable<Float> {
	@Override
	public void call(Object param, JsonGenerator jgen) throws JsonGenerationException, IOException {
		if (param != null) 
			jgen.writeNumber((Float)param);
		else
			jgen.writeNull();
	}
}