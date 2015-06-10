package com.run;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testSpring-config.xml")
@Transactional
@TransactionConfiguration
public class ConsoleMarkReaderTest {

    @Autowired
    private ConsoleMarkReader consoleMarkReader;

    @Test
    public void readsNewMark() throws Exception {
        String input = "1\n1\n1\n";

        consoleMarkReader.setScanner(new Scanner(new ByteArrayInputStream(input.getBytes())));
        consoleMarkReader.readMark();
    }
}
