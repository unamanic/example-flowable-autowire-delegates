package com.example.exampleflowableautowiredelegates;

import java.util.logging.Logger;

import org.flowable.engine.HistoryService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class TestDelegate implements JavaDelegate {

    static final Logger LOGGER = Logger.getLogger(TestDelegate.class.getName());

    final HistoryService historyService;

    public TestDelegate(HistoryService historyService) {
        this.historyService = historyService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) {
        LOGGER.info("Listing all historic instances of the Test Process");
        historyService.createHistoricProcessInstanceQuery().processDefinitionKey("testProcess").list()
            .forEach(historicProcessInstance -> LOGGER.info("Historic Process: " + historicProcessInstance.getId()));
        LOGGER.info("-----------");
    }
}
