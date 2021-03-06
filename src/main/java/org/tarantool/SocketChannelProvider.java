package org.tarantool;

import java.nio.channels.SocketChannel;

public interface SocketChannelProvider {

    int RETRY_NO_LIMIT = -1;
    int NO_TIMEOUT = 0;

    /**
     * Provides socket channel to init restore connection.
     * You could change hosts on fail and sleep between retries in this method
     * @param retryNumber number of current retry. Reset after successful connect.
     * @param lastError   the last error occurs when reconnecting
     * @return the result of SocketChannel open(SocketAddress remote) call
     */
    SocketChannel get(int retryNumber, Throwable lastError);
}
