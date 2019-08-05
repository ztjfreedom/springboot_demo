package com.ztj.springbootdemo.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerListener implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunnerListener.class.getName());

    @Override
    public void run(String... args) {
        logger.info("...CommandLineRunner...");
    }
}
