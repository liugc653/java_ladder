package ladder;

public class User {
	// �û����ǳ�
	private String name;
	// �û��ĵ�¼��
	private String loginName;
	// �û��ĵ�¼����
	private String passwd;
	// �û����ۼƻ���
	private int point;
	// �û����ڵĽף�ͨ��point�������
	private String rank;

	// ��ȡ�û���ǰ���ۼƻ���
	public int getPoint() {
		return point;
	}
	// �����û����ۼƻ��֣�point���û�һ�α����ĵ÷֣���Ҫ��ԭ�����ۼ�
	public String setPoint(int point) {
		this.point = this.point + point;
		return "";
	}
	// �����û����ۼƻ���,ֱ�Ӵ���������ӱ����÷����ۼ�
	public String setPoint(Game game) {
		if (!game.user.loginName.equals(this.loginName)) {
			return "������ı�����Ϣ�뵱ǰ�û�������";
		}
		if (game.project.status != "������") {
			return "��Ǹ�����ύ����Ŀ��Ϣ�Ѿ������������ٴ���point";
		}
		this.point = this.point + game.point;
		return "";
	}
	// ���ݵ�ǰ���֣�ʵʱ�����û���Rank
	public String getRank() {
		if (point >= 100 && point < 300) {
			return "��ͭ";
		} else if  (point >= 300) {
			return "����";
		} 
		return "δ֪";
	}
	// �û�ע�ᣬ���ڳ�ʼ���û�
	public String reg(String name, String loginName, String passwd, String rePasswd) {
		if (name.length() < 2) {
			return "�û��������Ϲ淶";
		}
		if (!passwd.equals(rePasswd)) {
			return "��2����������벻һ��";
		}
		//�ö���֤
		this.name = name;
		this.loginName = loginName;
		this.passwd = passwd;
		return "";
	}
	// ��ȡ�û���
	public String getName() {
		return name;
	}
	// ��ȡ��¼��
	public String getLoginName() {
		return loginName;
	}
	// ���õ�¼��Ϣ�����ڵ�¼
	public String setLoginInfo(String loginName, String passwd) {			
		this.loginName = loginName;
		this.passwd = passwd;
		return "";
	}
	// �޸��û���
	public String modName(String name) {
		if (name.length() < 2) {
			return "�û��������Ϲ淶";
		}
		if (this.name.equals(name)) {
			return "�û������ܺ����е��û���һ��";
		}
		this.name = name;
		return "";
	}
	// �޸��û�����
	public String modPasswd(String oldPasswd, String newPasswd, String rePasswd) {
		if (newPasswd.length() < 8) {
			return "���벻���Ϲ淶";
		}
		if (!this.passwd.equals(oldPasswd)) {
			return "������ľ�������������벻һ��";
		}
		if (!newPasswd.equals(rePasswd)) {
			return "��2����������벻һ��";
		}
		this.passwd = newPasswd;
		return "";
	}
	// ����û���¼��Ϣ
	public boolean checkLogin(String loginName, String passwd) {
		if (loginName.equals(this.loginName) && passwd.equals(this.passwd)) {
			return true;
		} else {
			return false;
		}
	}
	// ����û���¼��Ϣ
	public boolean checkLogin(User user) {
		if (user.loginName.equals(this.loginName) && user.passwd.equals(this.passwd)) {
			return true;
		} else {
			return false;
		}
	}
}