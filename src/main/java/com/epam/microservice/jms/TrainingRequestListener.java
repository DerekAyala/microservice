package com.epam.microservice.jms;

import com.epam.microservice.model.TrainingRequest;
import com.epam.microservice.service.TrainingWorkService;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TrainingRequestListener {

    private final TrainingWorkService trainingWorkService;
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TrainingRequestListener.class);
    @JmsListener(destination = "trainingQueue")
    public void receiveMessage(@Payload TrainingRequest request) {
        MDC.put("transactionId", request.getTransactionId());
        LOGGER.info("Transaction Id: {}, Received training request: {}", MDC.get("transactionId"), request);
        trainingWorkService.acceptTrainerWork(request);
        MDC.remove("transactionId");
    }
}
