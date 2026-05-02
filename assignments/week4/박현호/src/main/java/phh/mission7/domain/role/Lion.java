package phh.mission7.domain.role;

public class Lion extends Role {
    public String stuId;

    public Lion(String name, String major, int generation, String part, String stuId) {
        super(name, major, generation, part);
        this.stuId = stuId;
    }

    @Override
    public String information() {
        return "역할: 아기사자\n" + super.information() +
                "학번: " + stuId +
                "\n----------------";
    }
}