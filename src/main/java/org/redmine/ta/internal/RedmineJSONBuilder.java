package org.redmine.ta.internal;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.redmine.ta.beans.Issue;
import org.redmine.ta.beans.Project;

/**
 * Builder for requests to Redmine in JSON format.
 * TODO use maps for keys common to builder and parser
 */
public class RedmineJSONBuilder {

    /**
     * Creates a Redmine-compatible JSON representation of a {@link Project}.
     * @param project the {@link Project}
     * @return the Redmine-compatible JSON representation of the {@link Project}
     */
    public static String toJSON(Project project) {
        return wrapJSONProperty("project",new Gson().toJson(project));
    }

    /**
     * Creates a Redmine-compatible JSON representation of a {@link Issue}.
     * @param projectKey the ID of the {@link Project}
     * @param issue the {@link Issue}
     * @return the Redmine-compatible JSON representation of the {@link Issue}
     */
    public static String toJSON(String projectKey,Issue issue) {
        // TODO we need IDs here for the member entities (project, etc)
        return wrapJSONProperty("issue",new Gson().toJson(issue));
    }

    private static String wrapJSONProperty(String property,String jsonEntity) {
        StringBuilder jsonPropertyWrapper = new StringBuilder();
        jsonPropertyWrapper.append("{\"").append(property).append("\":").append(jsonEntity).append("}");
        return jsonPropertyWrapper.toString();
    }
}
