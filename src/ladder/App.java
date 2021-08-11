package ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	public static Game[] games = new Game[10];

	public static void main(String[] args) {
		// д����Ŀ
		Project[] projects = new Project[10];
		Project proj = new Project();
		proj.name = "����ʵѵ����";
		proj.desc = "�����Ҫ����װ�����»���";
		projects[0] = proj;
		proj = new Project();
		proj.name = "˼ά��ͼ";
		proj.desc = "�ҳ��ؼ��༰�����ԣ���Ϊ";
		projects[1] = proj;
		// ����ÿ����Ŀ
		for (int x = 0; x < projects.length; x++) {
			if (projects[x] != null) {
				System.out.println(projects[x].name);
			}
		}
		// д���û�
		User[] users = new User[10];
		User user = new Teacher("Admin");
		user.reg("��������Ա", "228228", "225225", "225225");
		users[1] = user;
		user = new Student("");
		user.reg("����ChaoHe", "ChaoHe", "ChaoHe225", "ChaoHe225");
		users[0] = user;
		// ��ʦ��¼-userType�ǹ���Ա�Ľ�ʦ���ܵ�¼�ɹ����������ʱ��userType���óɣ�=Admin����ʹ�û�����������ȷ���޷���¼�ɹ�
		User teacher = new Teacher("");
		teacher.reg("��������Ա", "228228", "225225", "225225");
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
			System.out.println(teacher.getName() + "��¼�ɹ���");
		} else {
			System.out.println(teacher.getLoginName() + "��¼ʧ�ܣ������û����������Ƿ���ȷ��");
		}
		// �û���¼
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
			System.out.println(loginuser.getName() + "��¼�ɹ���");
		} else {
			System.out.println(loginuser.getLoginName() + "��¼ʧ�ܣ������û����������Ƿ���ȷ��");
		}
		/*
		 * System.out.println("������loginName"); BufferedReader buf = new
		 * BufferedReader(new InputStreamReader(System.in)); try { loginuser.loginName =
		 * buf.readLine(); } catch (IOException e) { e.printStackTrace(); }
		 * System.out.println("������passwd"); buf = new BufferedReader(new
		 * InputStreamReader(System.in)); try { loginuser.passwd = buf.readLine(); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */		
		// д��loginuser�����ɼ�

		Game game = new Game();
		game.user = loginuser;
		game.project = projects[0];
		// loginuser�ύ��Ŀ
		String err = game.submit("loginuser�ύ��Ŀ");
		if (err.length() > 0) {
			System.out.println(err);
		} else {
			// ��loginuser����
			err = game.score("�ύ��Ŀ����", 200);
			if (err.length() > 0) {
				System.out.println(err);
			} else {
				// �������ɹ��ύ��Ҫ�޸��û��ķ���
				loginuser.setPoint(game);
				System.out.println(loginuser.getPoint());
				System.out.println(loginuser.getRank());
			}
		}
		games[0] = game;
		System.out.println(game.user.getName() + "ͬѧ�ڡ�" + game.project.name + "����Ŀ�л��" + game.point + "��");
		// loginuser�μӵڶ�����Ŀ
		game = new Game();
		game.user = loginuser;
		game.project = projects[1];
		// loginuser�ύ��Ŀ
		err = game.submit("loginuser�ύ��Ŀ2");
		if (err.length() > 0) {
			System.out.println(err);
		} else {
			// ��loginuser����
			err = game.score("�ύ��Ŀ2����", 180);
			if (err.length() > 0) {
				System.out.println(err);
			} else {
				// �������ɹ��ύ��Ҫ�޸��û��ķ���
				loginuser.setPoint(game);
				System.out.println(loginuser.getPoint());
				System.out.println(loginuser.getRank());
			}
		}
		games[1] = game;
		// �������б���
		System.out.println(game.user.getName() + "ͬѧ�ڡ�" + game.project.name + "����Ŀ�л��" + game.point + "��");
		for (int x = 0; x < games.length; x++) {
			if (games[x] != null) {
				System.out.println(
						games[x].user.getName() + "ͬѧ�ڡ�" + games[x].project.name + "����Ŀ�л��" + games[x].point + "��");
			}
		}
	}
}
