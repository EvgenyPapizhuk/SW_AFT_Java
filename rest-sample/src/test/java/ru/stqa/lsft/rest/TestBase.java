package ru.stqa.lsft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Set;

public class TestBase {


//    boolean isIssueOpen(int issueId) throws IOException {
//        String json = getExecutor().execute(Request
//                .Get("https://bugify.stqa.ru/api/issues.json")).returnContent().asString();
//        JsonElement parsed = new JsonParser().parse(json);
//        JsonElement issues = parsed.getAsJsonObject().get("issues");
//
//        Set<Issue> newIssues = new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {}.getType());
//        for (Issue operationIssue : newIssues) {
//            if (operationIssue.getId() == issueId) {
//                if (operationIssue.getState() == 4) {
//                    return false;
//                }
//                return true;
//            }
//        }
//        return true;
//    }

    boolean isIssueOpen(int issueId) throws IOException {
        String json = getExecutor().execute(Request
                .Get(String.format("https://bugify.stqa.ru/api/issues/%s.json", issueId))).returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");

        Set<Issue> newIssues = new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {}.getType());
//        for (Issue operIssue : newIssues) {
//            System.out.println(operIssue);
//        }
        if (newIssues.iterator().next().getState() == 4) {
            return false;
        }
        return true;
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    protected Executor getExecutor() {
        return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
    }


}
