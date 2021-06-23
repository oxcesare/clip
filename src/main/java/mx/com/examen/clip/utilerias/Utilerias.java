package mx.com.examen.clip.utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Utilerias {

	public final static String FECHATIMESTAMP = "yyyyMMddHHmmssSSS";

	public static String formatFechaTransaccion(Date date) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		String format = formatter.format(date);

		return format;
	}

	public static String getTimeStamp(final String formatDate) {
		return new SimpleDateFormat(formatDate).format(new Date());
	}

	public static String convertToJson(Object object) throws JsonProcessingException {

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(object);

		return json;

	}

}
