/*
 * Copyright (C), 2015-2020, 壹永科技有限公司
 * FileName: MongoClientOptionProperties
 * Author:   sun
 * Date:     2020/4/17 17:12
 * History:
 * <author>          <time>                <version>
 *   sun         2020/4/17 17:12           v1.0.0
 */
package com.sun.mongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2020/4/17
 * @since v1.0.0
 */
@Validated
@Configuration
public class MongoClientOptionProperties {


    /**
     * 基础连接参数
     */
    private String database;
    private String username;
    private String password;
    @NotNull
    private List<String> address;
    private String authenticationDatabase;

    /**
     * 客户端连接池参数
     */
    @NotNull
    @Size(min = 1)
    private String clientName;
    /**
     * socket连接超时时间
     */
    @Min(value = 1)
    private int connectionTimeoutMs;
    /**
     * socket读取超时时间
     */
    @Min(value = 1)
    private int readTimeoutMs;
    /**
     * 连接池获取链接等待时间
     */
    @Min(value = 1)
    private int poolMaxWaitTimeMs;
    /**
     * 连接闲置时间
     */
    @Min(value = 1)
    private int connectionMaxIdleTimeMs;
    /**
     * 连接最多可以使用多久
     */
    @Min(value = 1)
    private int connectionMaxLifeTimeMs;
    /**
     * 心跳检测发送频率
     */
    @Min(value = 2000)
    private int heartbeatFrequencyMs;

    /**
     * 最小的心跳检测发送频率
     */
    @Min(value = 300)
    private int minHeartbeatFrequencyMs;
    /**
     * 计算允许多少个线程阻塞等待时的乘数，算法：threadsAllowedToBlockForConnectionMultiplier*connectionsPerHost
     */
    @Min(value = 1)
    private int threadsAllowedToBlockForConnectionMultiplier;
    /**
     * 心跳检测连接超时时间
     */
    @Min(value = 200)
    private int heartbeatConnectionTimeoutMs;
    /**
     * 心跳检测读取超时时间
     */
    @Min(value = 200)
    private int heartbeatReadTimeoutMs;

    /**
     * 每个host最大连接数
     */
    @Min(value = 1)
    private int connectionsPerHost;
    /**
     * 每个host的最小连接数
     */
    @Min(value = 1)
    private int minConnectionsPerHost;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public String getAuthenticationDatabase() {
        return authenticationDatabase;
    }

    public void setAuthenticationDatabase(String authenticationDatabase) {
        this.authenticationDatabase = authenticationDatabase;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getConnectionTimeoutMs() {
        return connectionTimeoutMs;
    }

    public void setConnectionTimeoutMs(int connectionTimeoutMs) {
        this.connectionTimeoutMs = connectionTimeoutMs;
    }

    public int getReadTimeoutMs() {
        return readTimeoutMs;
    }

    public void setReadTimeoutMs(int readTimeoutMs) {
        this.readTimeoutMs = readTimeoutMs;
    }

    public int getPoolMaxWaitTimeMs() {
        return poolMaxWaitTimeMs;
    }

    public void setPoolMaxWaitTimeMs(int poolMaxWaitTimeMs) {
        this.poolMaxWaitTimeMs = poolMaxWaitTimeMs;
    }

    public int getConnectionMaxIdleTimeMs() {
        return connectionMaxIdleTimeMs;
    }

    public void setConnectionMaxIdleTimeMs(int connectionMaxIdleTimeMs) {
        this.connectionMaxIdleTimeMs = connectionMaxIdleTimeMs;
    }

    public int getConnectionMaxLifeTimeMs() {
        return connectionMaxLifeTimeMs;
    }

    public void setConnectionMaxLifeTimeMs(int connectionMaxLifeTimeMs) {
        this.connectionMaxLifeTimeMs = connectionMaxLifeTimeMs;
    }

    public int getHeartbeatFrequencyMs() {
        return heartbeatFrequencyMs;
    }

    public void setHeartbeatFrequencyMs(int heartbeatFrequencyMs) {
        this.heartbeatFrequencyMs = heartbeatFrequencyMs;
    }

    public int getMinHeartbeatFrequencyMs() {
        return minHeartbeatFrequencyMs;
    }

    public void setMinHeartbeatFrequencyMs(int minHeartbeatFrequencyMs) {
        this.minHeartbeatFrequencyMs = minHeartbeatFrequencyMs;
    }

    public int getThreadsAllowedToBlockForConnectionMultiplier() {
        return threadsAllowedToBlockForConnectionMultiplier;
    }

    public void setThreadsAllowedToBlockForConnectionMultiplier(int threadsAllowedToBlockForConnectionMultiplier) {
        this.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
    }

    public int getHeartbeatConnectionTimeoutMs() {
        return heartbeatConnectionTimeoutMs;
    }

    public void setHeartbeatConnectionTimeoutMs(int heartbeatConnectionTimeoutMs) {
        this.heartbeatConnectionTimeoutMs = heartbeatConnectionTimeoutMs;
    }

    public int getHeartbeatReadTimeoutMs() {
        return heartbeatReadTimeoutMs;
    }

    public void setHeartbeatReadTimeoutMs(int heartbeatReadTimeoutMs) {
        this.heartbeatReadTimeoutMs = heartbeatReadTimeoutMs;
    }

    public int getConnectionsPerHost() {
        return connectionsPerHost;
    }

    public void setConnectionsPerHost(int connectionsPerHost) {
        this.connectionsPerHost = connectionsPerHost;
    }

    public int getMinConnectionsPerHost() {
        return minConnectionsPerHost;
    }

    public void setMinConnectionsPerHost(int minConnectionsPerHost) {
        this.minConnectionsPerHost = minConnectionsPerHost;
    }
}