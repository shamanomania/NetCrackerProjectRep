package netcracker.viewsForms.jsonMap.sertificateCreate;

import java.util.Arrays;

/**
 * Created by Sid775 on 23.05.2017.
 */
public class JsonCertificate {

    private String title;

    private Long[] tests;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long[] getTests() {
        return tests;
    }

    public void setTests(Long[] testsId) {
        this.tests = testsId;
    }

    @Override
    public String toString() {
        return "JsonCertificate{" +
                "title='" + title + '\'' +
                ", testsId=" + Arrays.toString(tests) +
                '}';
    }
}
