package phms_se.database.bean;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class Schedule {
	
	private final static String tableSchema = "work_day,work_from,work_till,hourly_rate,vac_days,username";
	private Date workDay;
	private Time from, to;
	private BigDecimal hourRate;
	private int vacationDays;
	private String username;
	
	public Schedule(){}

	public Date getWorkDay() {
		return workDay;
	}

	public void setWorkDay(Date workDay) {
		this.workDay = workDay;
	}

	public Time getFrom() {
		return from;
	}

	public void setFrom(Time from) {
		this.from = from;
	}

	public Time getTo() {
		return to;
	}

	public void setTo(Time to) {
		this.to = to;
	}

	public BigDecimal getHourRate() {
		return hourRate;
	}

	public void setHourRate(BigDecimal hourRate) {
		this.hourRate = hourRate;
	}

	public int getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static String getTableSchema() {
		return tableSchema;
	}

	@Override
	public String toString() {
		return "Schedule [workDay=" + workDay + ", from=" + from + ", to=" + to
				+ ", hourRate=" + hourRate + ", vacationDays=" + vacationDays
				+ ", username=" + username + "]";
	}
}
