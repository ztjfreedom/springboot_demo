package com.ztj.springbootdemo.event;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationStartingEventListener.class.getName());

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        logger.info("...ApplicationStartingEvent...");
    }

}
