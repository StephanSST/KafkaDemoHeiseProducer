package ch.basler.playground.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import ch.basler.playground.kafka.model.RssFeedEntry;

@Service
public class KafkaProducer {

  private static final Logger LOG = LoggerFactory.getLogger(KafkaProducer.class);
  private static final String TOPIC = "heise";

  @Autowired
  private KafkaTemplate<String, RssFeedEntry> kafkaTemplate;

  public void sendMessage(RssFeedEntry message) {
    LOG.info(String.format("#### -> Producing message -> %s", message));
    this.kafkaTemplate.send(TOPIC, message);
  }
}