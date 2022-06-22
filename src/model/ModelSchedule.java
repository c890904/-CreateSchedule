package model;

import java.sql.Time;
import java.sql.Date;

public class ModelSchedule {
	private Date Date;
	private Time Start;
	private Time End;
	
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public Time getStart() {
		return Start;
	}
	public void setStart(Time start) {
		Start = start;
	}
	public Time getEnd() {
		return End;
	}
	public void setEnd(Time end) {
		End = end;
	}
	
	
}
