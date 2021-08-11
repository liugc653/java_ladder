package ladder;

public class Teacher extends User {
	
	Teacher(String userType) {
		super(userType);
		// TODO Auto-generated constructor stub
	}

	public boolean checkLogin(User user) {
		if (user.loginName.equals(this.loginName) && user.passwd.equals(this.passwd)) {
			if (user.userType.equals("Admin")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
