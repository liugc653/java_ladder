package ladder;

public class User {
	// �û����ǳ�
	protected String name;
	// �û��ĵ�¼��
	protected String loginName;
	// �û��ĵ�¼����
	protected String passwd;
	// �û�������
	protected String userType;
	
	User(String userType) {
	    this.userType = userType;
	}

	// �û�ע�ᣬ���ڳ�ʼ���û�
	public String reg(String name, String loginName, String passwd, String rePasswd) {
		if (name.length() < 2) {
			return "�û��������Ϲ淶";
		}
		if (!passwd.equals(rePasswd)) {
			return "��2����������벻һ��";
		}
		// �ö���֤
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