package br.com.cpsoftware.avancaif.app.util.constant;

public class PathWebConstants {

    private static final String PUBLIC_PATH = "public/";
    private static final String PRIVATE_PATH = "private/";

    public static final String ADMIN_PATH = PRIVATE_PATH + "admin/";
    public static final String STUDENT_PATH = PRIVATE_PATH + "student/";
    public static final String TEACHER_PATH = PRIVATE_PATH + "teacher/";

    public static final String LOGIN = "/login";
    public static final String LOGIN_PAGE = PUBLIC_PATH + "login.html";

    public static final String LOGOUT = "/logout";

    public static final String REGISTER = "/register";
    public static final String REGISTER_PAGE = PUBLIC_PATH + "register.html";

    public static final String HOME = "/";
    public static final String HOME_PAGE_PUBLIC = PUBLIC_PATH + "home.html";

    public static final String DASH = "/dash";
    public static final String DASH_PAGE = "dash.html";

    public static final String ADMIN_BADGES = "/admin/badges";
    public static final String ADMIN_BADGES_PAGE = ADMIN_PATH + "badges.html";

    public static final String ADMIN_CATEGORIES = "/admin/categories";
    public static final String ADMIN_CATEGORIES_PAGE = ADMIN_PATH + "categories.html";

    public static final String ADMIN_COURSES = "/admin/courses";
    public static final String ADMIN_COURSES_PAGE = ADMIN_PATH + "courses.html";

    public static final String ADMIN_EVALUATORS = "/admin/evaluators";
    public static final String ADMIN_EVALUATORS_PAGE = ADMIN_PATH + "evaluators.html";

    public static final String ADMIN_PROJECTS = "/admin/projects";
    public static final String ADMIN_PROJECTS_PAGE = ADMIN_PATH + "projects.html";

    public static final String ADMIN_REPORTS = "/admin/reports";
    public static final String ADMIN_REPORTS_PAGE = ADMIN_PATH + "reports.html";
}
