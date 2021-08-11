package ladder;

public class User {
	// 用户的昵称
	protected String name;
	// 用户的登录名
	protected String loginName;
	// 用户的登录密码
	protected String passwd;
	// 用户的类型
	protected String userType;
	
	User(String userType) {
	    this.userType = userType;
	}

	// 用户注册，用于初始化用户
	public String reg(String name, String loginName, String passwd, String rePasswd) {
		if (name.length() < 2) {
			return "用户名不符合规范";
		}
		if (!passwd.equals(rePasswd)) {
			return "您2次输入的密码不一致";
		}
		// 好多验证
		this.name = name;
		this.loginName = loginName;
		this.passwd = passwd;
		return "";
	}

	// 获取用户名
	public String getName() {
		return name;
	}

	// 获取登录名
	public String getLoginName() {
		return loginName;
	}

	// 设置登录信息，用于登录
	public String setLoginInfo(String loginName, String passwd) {
		this.loginName = loginName;
		this.passwd = passwd;
		return "";
	}

	// 修改用户名
	public String modName(String name) {
		if (name.length() < 2) {
			return "用户名不符合规范";
		}
		if (this.name.equals(name)) {
			return "用户名不能和现有的用户名一样";
		}
		this.name = name;
		return "";
	}

	// 修改用户密码
	public String modPasswd(String oldPasswd, String newPasswd, String rePasswd) {
		if (newPasswd.length() < 8) {
			return "密码不符合规范";
		}
		if (!this.passwd.equals(oldPasswd)) {
			return "您输入的旧密码和现有密码不一致";
		}
		if (!newPasswd.equals(rePasswd)) {
			return "您2次输入的密码不一致";
		}
		this.passwd = newPasswd;
		return "";
	}

	// 检测用户登录信息
	public boolean checkLogin(String loginName, String passwd) {
		if (loginName.equals(this.loginName) && passwd.equals(this.passwd)) {
			return true;
		} else {
			return false;
		}
	}

	// 检测用户登录信息
	public boolean checkLogin(User user) {
		if (user.loginName.equals(this.loginName) && user.passwd.equals(this.passwd)) {
			return true;
		} else {
			return false;
		}
	}
}