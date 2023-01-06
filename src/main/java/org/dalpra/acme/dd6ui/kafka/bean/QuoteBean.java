package org.dalpra.acme.dd6ui.kafka.bean;

import java.io.Serializable;

import org.dalpra.acme.dd6ui.kafka.consume.DemoConsumer;
import org.dalpra.acme.dd6ui.kafka.consume.DemoConsumerImpl;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class QuoteBean implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private static final String TOPIC = "demo-topic";

	public void sendMessage() {
		 DemoConsumer consumer = new DemoConsumerImpl(TOPIC);
	     consumer.doWork();
	}

}
