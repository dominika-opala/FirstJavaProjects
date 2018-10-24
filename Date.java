
public class Date {

	int day;
	int month;
	int year;

	public Date(int myday, int mymonth, int myyear) {
		
		day = myday;
		month = mymonth;
		year = myyear;
	}
	
	public String toString() {
		return "Date " + day + "-" + month + "-" + year + "";
	}

	public boolean isBefore(Date date1) {
		
		if (this.year < date1.year) { // this = 
			return true;
		} else if (this.year == date1.year) {
			if (this.month < date1.month) {
				return true;
			} else if (this.month == date1.month) {
				if (this.day == date1.day) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean isLeapYear() {
		if (day % 4 == 0 && day % 100 == 0 && day % 400 == 0) {
			day = 29;
			return true;
		} else {
			return false;
		}
	}

	public int getDaysOfMonth() {
		
		if (month == 2) {
			return 29;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		} else {
			return 31;
		}

	}

	public boolean isCorrect() {
		
		if (month >= 1 && month <= 12) {
			if (day >= 1 && day <= getDaysOfMonth()) {
				return true;
			}
		}
		return false;
	}

	public Date incrementDay() {
		
		int newday = day + 1;
		int newmonth = month;
		
		if(newday > getDaysOfMonth()) {
			newday = 1;
			newmonth ++;
		}
		
		int newyear = year;
		if(newmonth > 12) {
			newmonth = 1;
			newyear ++;
		}
		return new Date(newday,newmonth,newyear);
	}
	
	public Date incrementMonth() {
		int newmonth = month+1;
		int newyear = year;
		if(newmonth > 12) {
			newmonth = 1;
			newyear++;
		}
		return new Date(day,newmonth,newyear);
	}
	
	public Date incrementYear() {
		int newyear = year + 1;
		return new Date(day,month,newyear);
	}
	
	public int[] calculateDateDifference(Date date1) { // Java doesn’t support multi-value returns, and that's why we need to create an array which will contain the differences. 

		//here you could use isBefore method
		if (this.day >= date1.day && this.month >= date1.month && this.year >= date1.year) {
			
			int[] difference = new int[2]; // here you need 3 elements in an array, not 2
			
			difference[0] = this.day - date1.day;
			difference[1] = this.month - date1.month;
			difference[2] = this.year - date1.year;
			
			return difference;  
			
		} else {
			//you SHOULD NOT return null, it is better to return empty array
			return null;
		}
	}
	
	public String nameDay() {
		
			if  (year >= 1582 && year <= 4902) {
				
				String[] weekDays = {"Monday", "Tuesday", "Wednesday" , "Thursday", "Friday" , "Saturday", "Sunday"};
				
				int startyear = year/100; // here you don't need to cast to int
						
				int endyear = year%100; // here you don't need to cast to int
				
				int result = ((int)((2.6*(double)month - 0.2)) + day + endyear + (endyear/4) + (startyear) - 2*(startyear));
				
				return weekDays[result]; // That's a String, right? YES
			
		} else {
			return "The year is out of scope";
		}
		
	}
	
	
	public static void main(String[] args) {

		Date d = new Date(26, 06, 2018);
		System.out.println(d);
		Date d1 = new Date(21, 07, 2019);
		System.out.println(d1);
		
		boolean myboolean = d.isBefore(d);
		System.out.println(myboolean);
		
		System.out.println(d.isLeapYear());
		System.out.println(d1.isLeapYear());
		
		int m = d.getDaysOfMonth();
		System.out.println(m);
			
		System.out.println(d.incrementDay());
		Date checker = d.incrementDay().incrementMonth().incrementYear(); // we irritate over the loop checking whether the prgram 'correctly' increases the values.  
				
		System.out.println(checker);
		
		System.out.println(d.calculateDateDifference(d));
		
		System.out.println(d.nameDay());

	}

}
