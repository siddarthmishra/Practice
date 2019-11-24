package org.joda.time;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Example1 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println("date : " + date);
		DateTimeFormatter formatter;
		System.out.println("formatted date : " + date.format(DateTimeFormatter.ofPattern("d MMM yyyy")));
		LocalTime time = LocalTime.now();
		System.out.println("time : " + time);
		System.out.println("formatted time : " + time.format(DateTimeFormatter.ofPattern("hh:mm:ss:SS:nn a")));
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("dateTime : " + dateTime);
		formatter = DateTimeFormatter.ofPattern("dd MMMM uuuu EEEE hh:mm:ss:SS a");
		System.out.println("formatted dateTime : " + dateTime.format(formatter));

		LocalDateTime DOB = LocalDateTime.of(1992, Month.JANUARY, 14, 3, 35);
		System.out.println("Date of Birth : " + DOB);
		System.out.println(
				"formatted Date of Birth : " + DOB.format(DateTimeFormatter.ofPattern("dd MMMM uuuu EEEE hh:mm a")));
		System.out.println("Before 6 Months : " + DOB.minusMonths(6));
		System.out.println("After 6 Months : " + DOB.plusMonths(6));

		LocalDate birthday = LocalDate.of(1992, 1, 14);
		Period p = Period.between(birthday, date);
		System.out.println("period : " + p);
		System.out.printf("Age is %d years %d months %d days", p.getYears(), p.getMonths(), p.getDays());
		System.out.println();

		Year year = Year.now();
		System.out.println("year : " + year);

		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println("System Default Zone : " + zoneId);

		ZoneId la = ZoneId.of("America/Los_Angeles");
		ZonedDateTime dt = ZonedDateTime.now(la);
		System.out.println("America/Los_Angeles : " + dt);

		formatter = DateTimeFormatter.ofPattern("dd MMMM uuuu EEEE hh:mm:ss:SS a");
		System.out.println("formatted dateTime : " + dateTime.format(formatter));

		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		formatter = DateTimeFormatter.ofPattern("dd MMMM uuuu hh:mm:ss:SS a z");
		System.out.println(zonedDateTime.format(formatter));

		Clock clock = Clock.systemDefaultZone();
		System.out.println("clock : " + clock);
		Instant instant = Instant.now();
		System.out.println("instant : " + instant);
		System.out.println("instant1 : " + instant.atZone(ZoneId.systemDefault()));
	}

}
