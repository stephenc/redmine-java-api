package org.redmine.ta;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.redmine.ta.RedmineManager.INCLUDE;
import org.redmine.ta.beans.Issue;
import org.redmine.ta.beans.IssueRelation;
import org.redmine.ta.beans.Project;
import org.redmine.ta.beans.SavedQuery;
import org.redmine.ta.beans.TimeEntry;
import org.redmine.ta.beans.User;
import org.redmine.ta.internal.RedmineXMLGenerator;
import org.redmine.ta.internal.logging.Logger;
import org.redmine.ta.internal.logging.LoggerFactory;

public class Simple {
//	private static String redmineHost = "https://www.hostedredmine.com";
//	private static String apiAccessKey = "a3221bfcef5750219bd0a2df69519416dba17fc9";
//	private static String projectKey = "taskconnector-test";

    private static Logger logger = LoggerFactory.getLogger(Simple.class);

    //	private static String redmineHost = "http://192.168.0.30:3030";
    private static String redmineHost = "http://org.redmine.ta-dev.dyndns.biz:3030";
    //    private static String apiAccessKey = "e4e0fa8083e85ff787f2fd30e28ff7e285bff346";
    private static String login = "admin";
    private static String password = "zzz666";

//	private static String redmineHost = "http://192.168.0.64:3000";
//    private static String login = "admin";
//    private static String password = "admin";

    private static String projectKey = "test";

    private static Integer queryId = null; // any

    public static void main(String[] args) {
        RedmineManager mgr = new RedmineManager(redmineHost, login, password);
//		RedmineManager mgr = new RedmineManager(redmineHost, apiAccessKey);
        try {
//			getIssueWithRelations(mgr);
//			tryCreateIssue(mgr);
//			tryGetIssues(mgr);
            tryGetAllIssues(mgr);
//			printCurrentUser(mgr);
//			generateXMLForUser();
//			generateXMLForTimeEntry();
//			getSavedQueries(mgr);
//			getProjects(mgr);
//			tryCreateRelation(mgr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void tryCreateRelation(RedmineManager mgr) throws IOException, AuthenticationException, NotFoundException, RedmineException {
        IssueRelation r = mgr.createRelation(49, 50, IssueRelation.TYPE.precedes.toString());
        logger.debug("Created relation " + r);
    }

    private static void getProjects(RedmineManager mgr) throws IOException, AuthenticationException, RedmineException {
        List<Project> projects = mgr.getProjects();
        logger.debug("Retrieved projects " + projects);

    }

    private static void getSavedQueries(RedmineManager mgr) throws IOException, AuthenticationException, NotFoundException, RedmineException {
        List<SavedQuery> savedQueries = mgr.getSavedQueries("test");
        logger.debug("Retrieved queries " + savedQueries);

    }

    private static void getIssueWithRelations(RedmineManager mgr) throws IOException, AuthenticationException, NotFoundException, RedmineException {
        Issue issue = mgr.getIssueById(24580, INCLUDE.relations);
        List<IssueRelation> r = issue.getRelations();
        logger.debug("Retrieved relations " + r);

    }

    private static void tryCreateIssue(RedmineManager mgr) throws IOException, AuthenticationException, NotFoundException, RedmineException {
        Issue issue = new Issue();
        issue.setSubject("test123");
        mgr.createIssue(projectKey, issue);
    }

    private static void generateXMLForTimeEntry() {
        TimeEntry o = new TimeEntry();
        o.setId(13);
        o.setIssueId(45);
        o.setActivityId(3);
        o.setProjectId(55);
        o.setUserId(66);
        o.setHours(123f);
        o.setComment("text here");
        o.setSpentOn(new Date());
        String xml = RedmineXMLGenerator.toXML(o);
        logger.debug(xml);
    }

    private static void generateXMLForUser() {
        User u = new User();
        u.setLogin("newlogin");
        String xml = RedmineXMLGenerator.toXML(u);
        logger.debug(xml);

    }

    private static void tryGetIssues(RedmineManager mgr) throws Exception {
        List<Issue> issues = mgr.getIssues(projectKey, queryId);
        for (Issue issue : issues) {
            logger.debug(issue.toString());
        }
    }

    private static void tryGetAllIssues(RedmineManager mgr) throws Exception {
        List<Issue> issues = mgr.getIssues(projectKey, null);
        for (Issue issue : issues) {
            logger.debug(issue.toString());
        }
    }

    private static void printCurrentUser(RedmineManager mgr) throws Exception {
        User currentUser = mgr.getCurrentUser();
        logger.debug("user=" + currentUser.getMail());

        currentUser.setMail("ne@com123.com");
        mgr.updateUser(currentUser);
        logger.debug("updated user");

        User currentUser2 = mgr.getCurrentUser();
        logger.debug("updated user's mail: " + currentUser2.getMail());

    }
}
