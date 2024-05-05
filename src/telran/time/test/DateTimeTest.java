package telran.time.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.*;
import java.time.format.DateTimeFormatter;


import org.junit.jupiter.api.Test;

import telran.time.BarMizvaAdjuster;
import telran.time.Friday13Range;
import telran.time.NextFriday13;

class DateTimeTest {

	@Test
	void barMizvaAdjusterTest() {
		LocalDate birtdate = LocalDate.parse("1799-06-06");
		LocalDate expected = LocalDate.of(1812, 6, 6);
		assertEquals(expected, birtdate.with(new BarMizvaAdjuster()));
	}
	@Test 
	void nextFriday13Test() {
		  NextFriday13 nextFriday13 = new NextFriday13();
	        LocalDate dateofFriday13 = LocalDate.of(2024, 9, 13);
	        LocalDate date2 = LocalDate.of(2024, 10, 13);
	        LocalDate expected = LocalDate.of(2024, 12, 13);
	        assertEquals(expected, LocalDate.from(nextFriday13.adjustInto(dateofFriday13)));
	        assertEquals(expected, LocalDate.from(nextFriday13.adjustInto(date2)));

	}
	@Test
	void friday13RangeTest() {
		//TODO
	
		 Friday13Range range = new Friday13Range(LocalDate.of(2023, 1, 1), LocalDate.of(2024, 12, 31));

	        // Expected Friday 13ths within the range (manually identify or use a library)
	        LocalDate[] expected = new LocalDate[]{
	                LocalDate.of(2023, 10, 13),
	                LocalDate.of(2024, 9, 13)
	        };
	        assertEquals(expected, range);
	        
	}
	@Test
	void displayCurrentDateTimeTest() {
		//The following test implies printing out 
		//all current date/time in Time Zones containing string Canada
		displayCurrentDateTime("Canada");
	}
	private void displayCurrentDateTime(String zonePart) {
		//format <year>-<month number>-<day>-<hh:mm>-<zone name>
		//prints out current date/time in all zones containing zonePart
		//ZonedDateTime class
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("<yyyy>-<MM>-<dd> -<hh:mm>-<zzzz>");
		    ZoneId.getAvailableZoneIds().stream()
		           .filter(zoneId -> zoneId.contains(zonePart))
		           .forEach(zoneId -> {
		                ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of(zoneId));
		                System.out.println(formatter.format(zdt) + " - " + zoneId);
		            });
	}

}
