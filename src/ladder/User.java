package ladder;

public class User {
	// 用户的昵称
	private String name;
	// 用户的登录名
	private String loginName;
	// 用户的登录密码
	private String passwd;
	// 用户的累计积分
	private int point;
	// 用户所在的阶，通过point计算而来
	private String rank;

	// 获取用户当前的累计积分
	public int getPoint() {
		return point;
	}
	// 设置用户的累计积分，point是用户一次比赛的得分，需要和原积分累计
	public String setPoint(int point) {
		this.point = this.point + point;
		return "";
	}
	// 设置用户的累计积分,直接传入比赛，从比赛得分中累计
	public String setPoint(Game game) {
		if (!game.user.loginName.equals(this.loginName)) {
			return "您传入的比赛信息与当前用户不符合";
		}
		if (game.project.status != "进行中") {
			return "抱歉，您提交的项目信息已经结束，不能再传入point";
		}
		this.point = this.point + game.point;
		return "";
	}
	// 根据当前积分，实时计算用户的Rank
	public String getRank() {
		if (point >= 100 && point < 300) {
			return "青铜";
		} else if  (point >= 300) {
			return "白银";
		} 
		return "未知";
	}
	// 用户注册，用于初始化用户
	public String reg(String name, String loginName, String passwd, String rePasswd) {
		if (name.length() < 2) {
			return "用户名不符合规范";
		}
		if (!passwd.equals(rePasswd)) {
			return "您2次输入的密码不一致";
		}
		//好多验证
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