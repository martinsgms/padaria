package br.com.martins.padaria.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    
    static SimpleDateFormat formatter;
    
    public static Date parseToDefault(String data) {
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dataFormatada = null;

        try {
            
            dataFormatada = formatter.parse(data);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return dataFormatada;
    }
}
