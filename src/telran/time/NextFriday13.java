package telran.time;

import java.time.DayOfWeek; 
import java.time.LocalDate;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextFriday13 implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		LocalDate date = LocalDate.from(temporal);
		date = date.plusDays(1);	
	    while (date.getDayOfWeek() != DayOfWeek.FRIDAY || date.getDayOfMonth() != 13) {
	        date = date.plusMonths(1).withDayOfMonth(13);
	    }
	    return temporal.with(date);
	    
	}

}
