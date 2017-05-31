package com.ireul.nerf.web.controller;

import com.ireul.nerf.web.server.Request;
import com.ireul.nerf.web.server.Response;
import org.eclipse.jetty.http.HttpMethod;

import java.util.HashMap;

/**
 * Controller interface
 * Something can storage and fetch request response
 * Created by ryan on 5/27/17.
 */
public interface Controller {

    /**
     * Get the {@link Request}
     *
     * @return request
     */
    Request request();

    /**
     * Get the {@link Response}
     *
     * @return response
     */
    Response response();

    /**
     * Set the {@link Request}
     *
     * @param request request
     */
    void request(Request request);

    /**
     * Set the {@link Response}
     *
     * @param response response
     */
    void response(Response response);

    /**
     * will be invoked before action
     */
    void beforeAction();

    default HttpMethod method() {
        return request().method();
    }

    default boolean isGet() {
        return HttpMethod.GET == method();
    }

    default boolean isPost() {
        return HttpMethod.POST == method();
    }

    default boolean isDelete() {
        return HttpMethod.DELETE == method();
    }

    default boolean isPut() {
        return HttpMethod.PUT == method();
    }

    default String queryString() {
        return request().queryString();
    }

    default HashMap<String, String> namedPaths() {
        return request().namedPaths();
    }

    default String namedPath(String name) {
        return request().namedPath(name);
    }

    default void header(String name, String value) {
        response().header(name, value);
    }

    default void status(int status) {
        response().status(status);
    }

    default void type(String type) {
        response().type(type);
    }

    default void length(long length) {
        response().length(length);
    }

    default void body(String body) {
        response().body(body);
    }

    default void body(char[] chars) {
        response().body(chars);
    }

    default void bodyPlain(String string) {
        response().bodyPlain(string);
    }

    default void bodyJson(Object object) {
        response().bodyJson(object);
    }

    default void bodyHtml(String html) {
        response().bodyHtml(html);
    }

    default void redirect(String location, int status) {
        response().redirect(location, status);
    }

    default void redirect(String location) {
        response().redirect(location);
    }

}
