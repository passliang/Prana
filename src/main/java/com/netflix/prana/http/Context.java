package com.netflix.prana.http;

import io.netty.handler.codec.http.HttpResponseStatus;

import java.util.List;

/**
 * A context is a collection of functions to aid in the request handling process
 */
public interface Context {

    /**
     * Serializes an object and writes the bytes to the response stream
     *
     * @param object response object
     */
    void send(Object object);

    /**
     * Sends a simple text message back through the response stream
     *
     * @param message the message to deliver
     */
    void sendSimple(String message);

    /**
     * Serializes a simple error message back to the response using the supplied status code
     *
     * @param status the status code for the response
     * @param message the message to send back to the caller
     */
    void sendError(HttpResponseStatus status, String message);

    /**
     * Retrieves the value of the specified header
     *
     * @param name the name of the header to retrieve
     * @return the header value
     */
    String getHeader(String name);

    /**
     * Sets the response header value
     *
     * @param name the header's name
     * @param value the value of the header
     */
    void setHeader(String name, String value);

    /**
     * Convenience method for retrieving a query parameter off of the request
     *
     * @param key the query parameter
     * @return the query param value
     */
    String getQueryParam(String key);

    /**
     * Convenience method for retrieving a query parameter off of the request that contains multiple values
     *
     * @param key the name of the query parameter
     * @return the list of values from the query parameter
     */
    List<String> getQueryParams(String key);
}
