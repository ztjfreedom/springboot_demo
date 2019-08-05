package com.ztj.springbootdemo.event;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class ApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationFailedEventListener.class.getName());

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        logger.info("...ApplicationFailedEvent...");
    }

}
