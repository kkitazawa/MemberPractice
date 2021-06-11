package jp.co.aforce.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Member implements Serializable{
	
	Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("JST"));
	SimpleDateFormat format =  new SimpleDateFormat("yyMMddhhmmss");
	 
	String formatDate = "A" + format.format(calendar.getTime());
	//TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");
	
	
	private String memberNo = formatDate;
	private String name;
	private String age;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	

	public String getMemberNo() {
		return memberNo;
	}
	
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	
	public String getBirthMonth() {
		return birthMonth;
	}
	
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	public String getBirthDay() {
		return birthDay;
	}
	
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
}
