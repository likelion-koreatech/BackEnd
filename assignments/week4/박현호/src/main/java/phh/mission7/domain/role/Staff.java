package phh.mission7.domain.role;

public class Staff extends Role {
    public String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public String information() {
        return "역할: 운영진\n" + super.information() +
                "직책: " + position +
                "\n----------------";
    }
}
