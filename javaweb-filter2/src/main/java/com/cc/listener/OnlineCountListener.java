package com.cc.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计网站在线人数
 */
public class OnlineCountListener implements HttpSessionListener {
    /**
     * 创建session监听
     * @param httpSessionEvent
     */
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");

        if (onlineCount == null) {
            onlineCount = 1;
        } else {
            onlineCount++;
        }

        servletContext.setAttribute("onlineCount", onlineCount);
    }

    /**
     * 销毁session监听
     * @param httpSessionEvent
     */
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        httpSessionEvent.getSession().invalidate();
        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");

        if (onlineCount == null) {
            onlineCount = 0;
        } else {
            onlineCount--;
        }

        servletContext.setAttribute("onlineCount", onlineCount);
    }

    /**
     * session销毁：
     * 1、手动销毁   getSession().invalidate();
     * 2、自动销毁
     */


}
