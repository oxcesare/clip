package mx.com.examen.clip.utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilerias {
	
	
public static String formatFechaTransaccion(Date date) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");  
	    String format= formatter.format(date);  
	    
	    return format;
	}


}
