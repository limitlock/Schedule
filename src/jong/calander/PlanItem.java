package jong.calander;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	public Date planDate;
	public String detail;
	public String peoples = "";

	public static Date getDatefromString(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-mm-dd").parse(strDate);
		} catch (ParseException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		return date;
	}

	public PlanItem(String date, String detail) {
		this.planDate = getDatefromString(date);
		this.detail = detail;

	}

	public Date getDate() {
		return planDate;
	}

	public void addPeople(String name) {
		peoples += name + ",";

	}

}
