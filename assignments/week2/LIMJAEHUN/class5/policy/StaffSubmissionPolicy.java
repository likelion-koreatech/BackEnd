package policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {

    @Override
    public boolean check() {
        return false;
    }
}
