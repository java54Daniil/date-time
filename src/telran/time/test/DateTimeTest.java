package telran.time.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.*;

import org.junit.jupiter.api.Test;

import telran.time.BarMizvaAdjuster;

class DateTimeTest {

	@Test
	void barMizvaAdjusterTest() {
		LocalDate birtdate = LocalDate.parse("1799-06-06");
		LocalDate expected = LocalDate.of(1812, 6, 6);
		assertEquals(expected, birtdate.with(new BarMizvaAdjuster()));
	}
	@Test 
	void nextFriday13Test() {
		//TODO
	}
	@Test
	void friday13RangeTest() {
		//TODO
	}
	@Test
	void displayCurrentDateTimeTest() {
		//The following test implies printing out 
		//all current date/time in Time Zones containing string Canada
		displayCurrentDateTime("Canada");
	}
	private void displayCurrentDateTime(String zonePart) {
		//TODO
		//format <year>-<month number>-<day>-<hh:mm>-<zone name>
		//prints out current date/time in all zones containing zonePart
		//ZonedDateTime class
		System.out.println("kuku");
	}

}
