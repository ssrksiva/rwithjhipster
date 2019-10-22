package com.stpl.javar.cucumber.stepdefs;

import com.stpl.javar.RwithJhipsterApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = RwithJhipsterApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
