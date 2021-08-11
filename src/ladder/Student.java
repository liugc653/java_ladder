package ladder;

public class Student extends User {
	Student(String userType) {
		super(userType);
		// TODO Auto-generated constructor stub
	}

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
		if (!game.user.getLoginName().equals(this.loginName)) {
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
		} else if (point >= 300) {
			return "����";
		}
		return "δ֪";
	}
}
