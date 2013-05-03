package edu.swmed.qbrc.jacksonate.rest.jackson.writers;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import java.math.BigInteger;

public class BigIntegerWriter implements Callable<BigInteger> {
	@Override
	public void call(Object param, JsonGenerator jgen) throws JsonGenerationException, IOException {
		if (param != null) 
			jgen.writeNumber((BigInteger)param);
		else
			jgen.writeNull();
	}
}