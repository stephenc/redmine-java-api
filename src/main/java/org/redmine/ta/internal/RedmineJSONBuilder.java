package org.redmine.ta.internal;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.redmine.ta.beans.Issue;
import org.redmine.ta.beans.Project;

/**
 * Builder for requests to Redmine in JSON format.
 */
public class RedmineJSONBuilder {

    public static String toJSON(Project project) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\"project\":").append(new Gson().toJson(project)).append("}");
        return jsonBuilder.toString();
    }
    
}
