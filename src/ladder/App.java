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
		User user = new User();
		user.name = "超级管理员";
		user.loginName = "228228";
		user.passwd = "225225";
		users[0] = user;
		user = new User();
		user.name = "ChaoHe";
		user.loginName = "ChaoHe";
		user.passwd = "ChaoHe225";
		users[1] = user;
		// 用户登录
		User loginuser = new User();
		loginuser.loginName = "ChaoHe";
		loginuser.passwd = "ChaoHe225";
		/*
		 * System.out.println("请输入loginName"); BufferedReader buf = new
		 * BufferedReader(new InputStreamReader(System.in)); try { loginuser.loginName =
		 * buf.readLine(); } catch (IOException e) { e.printStackTrace(); }
		 * System.out.println("请输入passwd"); buf = new BufferedReader(new
		 * InputStreamReader(System.in)); try { loginuser.passwd = buf.readLine(); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */
		boolean flgLogin = false;
		for (int x = 0; x < users.length; x++) {
			// method overloading
			if (users[x] != null && users[x].checkLogin(loginuser.loginName, loginuser.passwd)) {
				loginuser = users[x];
				flgLogin = true;
				break;
			}
		}
		if (flgLogin) {
			System.out.println(loginuser.name + "登录成功！");
		} else {
			System.out.println(loginuser.loginName + "登录失败，请检查用户名，密码是否正确！");
		}
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
			}
		}
		games[0] = game;
		System.out.println(game.user.name + "同学在【" + game.project.name + "】项目中获得" + game.point + "分");
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
			}
		}
		games[1] = game;
		// 遍历所有比赛
		System.out.println(game.user.name + "同学在【" + game.project.name + "】项目中获得" + game.point + "分");
		for (int x = 0; x < games.length; x++) {
			if (games[x] != null) {
				System.out.println(games[x].user.name + "同学在【" + games[x].project.name + "】项目中获得" + games[x].point + "分");
			}
		}
	}
}
