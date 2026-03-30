package policy;

public class StaffSubmissionSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean isSubmit() {
        return false;
    }
}
