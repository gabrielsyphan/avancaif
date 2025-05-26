package br.com.cpsoftware.avancaif.app.util.constant;

public class PathWebConstants {

    private static final String PUBLIC_PATH = "public/";
    private static final String PRIVATE_PATH = "private/";

    public static final String LOGIN = "/login";
    public static final String LOGIN_PAGE = PUBLIC_PATH + "login.html";

    public static final String REGISTER = "/register";
    public static final String REGISTER_PAGE = PUBLIC_PATH + "register.html";

    public static final String HOME = "/";
    public static final String HOME_PAGE_PUBLIC = PUBLIC_PATH + "home.html";

    public static final String DASH = "/dash";
    public static final String DASH_PAGE = PRIVATE_PATH + "dash.html";

    public static final String USERS = "/users";
    public static final String LIST_USERS_PAGE = DASH + "/user/list.html";
}
