package ch.basler.playground.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka/heise")
public class KafkaController {

  private final HeiseRssFeedReader heiseRssFeedReader;

  @Autowired
  KafkaController(HeiseRssFeedReader heiseRssFeedReader) {
    this.heiseRssFeedReader = heiseRssFeedReader;
  }

  @RequestMapping("/version")
  public String showVersion() {
    String message = "Kafka ready to read and produce";
    return message;
  }

  @RequestMapping(value = "/publish")
  public void readFromHeiseAndPublishToKafka() {
    heiseRssFeedReader.readerAndProduce();
  }

//  @PostMapping(value = "/publish")
//  public void readFromHeiseAndPublishToKafka() {
//    heiseRssFeedReader.readerAndProduce();
//  }
//  
}
