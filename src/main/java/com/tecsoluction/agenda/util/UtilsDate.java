package com.tecsoluction.agenda.util;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class UtilsDate {
	
	
	
	
	
	
//	 public static Date toDate(DatePicker datePicker) {
//	        if(datePicker.getValue() == null){
//	            return null;
//	        }
//	        LocalDate ld = datePicker.getValue();
//	        Instant instant = ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
//	        Date date = Date.from(instant);
//
//	        return date;
//	    }

	    /**
	     * Converte Date para LocalDate
	     *
	     * @param d
	     * @return LocalDate
	     */
	    public static LocalDate toLocalDate(Date d) {
	        Instant instant = Instant.ofEpochMilli(d.getTime());
	        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	        return localDate;
	    }
	    
	    
	    
	    
	    public static LocalTime toLocalTime(Date d) {
	        Instant instant = Instant.ofEpochMilli(d.getTime());
	        LocalTime localtime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
	        
	        return localtime;
	    }
	    
	    
	    
	    public static int  toQtdMesesEntreDatas(Date dataini, Date datafim) {
	       
	        LocalDate datainicial = UtilsDate.toLocalDate(dataini);

	        LocalDate datafinal = UtilsDate.toLocalDate(datafim);
	        
	        Period Periodomeses = datainicial.until(datafinal);
	        
	        
	        
	        return Periodomeses.getMonths();
	    }
	    
	    
	    public static int  toQtdDiasEntreDatas(Date dataini, Date datafim) {
		       
	        
	        LocalDate datainicial = UtilsDate.toLocalDate(dataini);

	        LocalDate datafinal = UtilsDate.toLocalDate(datafim);
	        
	        Period Periododias = datainicial.until(datafinal);
	        
	        
	        
	        return Periododias.getDays();
	    }
	    
	    
	    public static int  toQtdAnosDataAtual(Date dataini, Date datafim) {
		       
	        
	        LocalDate datainicial = UtilsDate.toLocalDate(dataini);

	        LocalDate datafinal = UtilsDate.toLocalDate(datafim);
	        
	        Period Periododias = datafinal.until(datainicial);
	        
	        
	        
	        return Periododias.getYears();
	    }
	    
	    public static long  toQtdHorasDataAtual(long dataini, Date datafim) {
		       
	        
	    	Date dt = new Date(dataini);
	    	
	        LocalTime tempoagora = UtilsDate.toLocalTime(dt);
	        
	        
	    	

	        LocalTime tempofinal = UtilsDate.toLocalTime(datafim);
	        
	        
	        long hoursBetween = ChronoUnit.HOURS.between( tempofinal,tempoagora);
	        long minutesBetween = ChronoUnit.MINUTES.between( tempofinal,tempoagora);
	        
	        
//	        Period Periododias = Period.between(datainicial,datafinal);
	        
	        
	        
	        
	        
	        
	        return minutesBetween;
	    }
	    
	    
	    

}
