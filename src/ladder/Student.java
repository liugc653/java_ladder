package ladder;

public class Student extends User {
	Student(String userType) {
		super(userType);
		// TODO Auto-generated constructor stub
	}

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
		if (!game.user.getLoginName().equals(this.loginName)) {
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
		} else if (point >= 300) {
			return "白银";
		}
		return "未知";
	}
}
