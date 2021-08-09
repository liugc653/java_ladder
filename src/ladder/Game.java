package ladder;

public class Game {
	public Project project;
	public User user;
	public int point;
	public String desc;
	public String comment;

	
	public String submit(String desc) {
		if (desc.length() < 5) {
			return "���������Ŀ������Ϣ̫��";
		} else {
			this.desc = desc;
			return "";
		}
	}
	
	public String score(String comment, int point) {
		if (comment.length() < 5) {
			return "���������Ŀ������Ϣ̫��";
		} else if (point < 0 || point > 200) {
			return "����������ֱ�����0-200��֮��";
		} else {
			this.comment = comment;
			this.point = point;
			return "";
		}
	}
}