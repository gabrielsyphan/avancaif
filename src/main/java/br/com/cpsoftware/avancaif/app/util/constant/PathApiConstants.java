package br.com.cpsoftware.avancaif.app.util.constant;

public class PathApiConstants {

    public static final String API_V1 = "/api/v1";

    public static final String LOGIN = "/login";
    public static final String API_V1_LOGIN = API_V1 + LOGIN;

    public static final String REGISTER = "/register";
    public static final String API_V1_REGISTER = API_V1 + REGISTER;

    public static final String USERS = "/users";
    public static final String API_V1_USERS = API_V1 + USERS;

    public static final String USERS_CREATE = "/create";
    public static final String API_V1_USERS_CREATE = API_V1_USERS + USERS_CREATE;
    public static final String USERS_RETRIEVE_ALL = "/all";
    public static final String API_V1_USERS_RETRIEVE_ALL = API_V1_USERS + USERS_RETRIEVE_ALL;

    public static final String BADGES_CREATE = "/badges/create";
    public static final String API_V1_BADGE_CREATE = API_V1 + BADGES_CREATE;

    public static final String BADGES_RETRIEVE_ALL = "/badges/all";
    public static final String API_V1_BADGES_RETRIEVE_ALL = API_V1 + BADGES_RETRIEVE_ALL;

    public static final String BADGES_UPDATE = "/badges/update";
    public static final String API_V1_BADGES_UPDATE = API_V1 + BADGES_UPDATE;

    public static final String BADGES_DELETE = "/badges/delete";
    public static final String API_V1_BADGES_DELETE = API_V1 + BADGES_DELETE;
}
