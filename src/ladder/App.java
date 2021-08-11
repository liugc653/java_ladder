package ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	public static Game[] games = new Game[10];

	public static void main(String[] args) {
		// 写入项目
		Project[] projects = new Project[10];
		Project proj = new Project();
		proj.name = "构筑实训环境";
		proj.desc = "大家需要依次装好以下环境";
		projects[0] = proj;
		proj = new Project();
		proj.name = "思维导图";
		proj.desc = "找出关键类及其属性，行为";
		projects[1] = proj;
		// 遍历每个项目
		for (int x = 0; x < projects.length; x++) {
			if (projects[x] != null) {
				System.out.println(projects[x].name);
			}
		}
		// 写入用户
		User[] users = new User[10];
		User user = new Teacher("Admin");
		user.reg("超级管理员", "228228", "225225", "225225");
		users[1] = user;
		user = new Student("");
		user.reg("超级ChaoHe", "ChaoHe", "ChaoHe225", "ChaoHe225");
		users[0] = user;
		// 教师登录-userType是管理员的教师才能登录成功，如果构造时将userType设置成！=Admin，即使用户名，密码正确则无法登录成功
		User teacher = new Teacher("");
		teacher.reg("超级管理员", "228228", "225225", "225225");
		teacher.setLoginInfo("228228", "225225");
		boolean teacherLogin = false;
		for (int x = 0; x < users.length; x++) {
			// method overloading
			if (users[x] != null && users[x].checkLogin(teacher)) {
				teacherLogin = true;
				break;
			}
		}
		if (teacherLogin) {
			System.out.println(teacher.getName() + "登录成功！");
		} else {
			System.out.println(teacher.getLoginName() + "登录失败，请检查用户名，密码是否正确！");
		}
		// 用户登录
		Student loginuser = new Student("");
		loginuser.reg("ChaoHe", "ChaoHe", "ChaoHe225", "ChaoHe225");
		loginuser.setLoginInfo("ChaoHe", "ChaoHe225");
		// loginuser.modPasswd("ChaoHe22", "ChaoHe228", "ChaoHe228");
		boolean flgLogin = false;
		for (int x = 0; x < users.length; x++) {
			// method overloading
			if (users[x] != null && users[x].checkLogin(loginuser)) {
				flgLogin = true;
				break;
			}
		}
		if (flgLogin) {
			System.out.println(loginuser.getName() + "登录成功！");
		} else {
			System.out.println(loginuser.getLoginName() + "登录失败，请检查用户名，密码是否正确！");
		}
		/*
		 * System.out.println("请输入loginName"); BufferedReader buf = new
		 * BufferedReader(new InputStreamReader(System.in)); try { loginuser.loginName =
		 * buf.readLine(); } catch (IOException e) { e.printStackTrace(); }
		 * System.out.println("请输入passwd"); buf = new BufferedReader(new
		 * InputStreamReader(System.in)); try { loginuser.passwd = buf.readLine(); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */		
		// 写入loginuser比赛成绩

		Game game = new Game();
		game.user = loginuser;
		game.project = projects[0];
		// loginuser提交项目
		String err = game.submit("loginuser提交项目");
		if (err.length() > 0) {
			System.out.println(err);
		} else {
			// 给loginuser评分
			err = game.score("提交项目评分", 200);
			if (err.length() > 0) {
				System.out.println(err);
			} else {
				// 分数被成功提交，要修改用户的分数
				loginuser.setPoint(game);
				System.out.println(loginuser.getPoint());
				System.out.println(loginuser.getRank());
			}
		}
		games[0] = game;
		System.out.println(game.user.getName() + "同学在【" + game.project.name + "】项目中获得" + game.point + "分");
		// loginuser参加第二个项目
		game = new Game();
		game.user = loginuser;
		game.project = projects[1];
		// loginuser提交项目
		err = game.submit("loginuser提交项目2");
		if (err.length() > 0) {
			System.out.println(err);
		} else {
			// 给loginuser评分
			err = game.score("提交项目2评分", 180);
			if (err.length() > 0) {
				System.out.println(err);
			} else {
				// 分数被成功提交，要修改用户的分数
				loginuser.setPoint(game);
				System.out.println(loginuser.getPoint());
				System.out.println(loginuser.getRank());
			}
		}
		games[1] = game;
		// 遍历所有比赛
		System.out.println(game.user.getName() + "同学在【" + game.project.name + "】项目中获得" + game.point + "分");
		for (int x = 0; x < games.length; x++) {
			if (games[x] != null) {
				System.out.println(
						games[x].user.getName() + "同学在【" + games[x].project.name + "】项目中获得" + games[x].point + "分");
			}
		}
	}
}
