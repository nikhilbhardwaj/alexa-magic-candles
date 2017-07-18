package in.nikhilbhardwaj.candles.iot;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.iotdata.AWSIotData;
import com.amazonaws.services.iotdata.AWSIotDataClient;
import com.amazonaws.services.iotdata.model.PublishRequest;

import javax.inject.Singleton;
import java.nio.ByteBuffer;

@Singleton
public class AWSIOTService {

    private static final String TOPIC = "topic_1";
    private static final String REGION = "us-east-1";
    private static final String ENDPOINT = "a1c2djc1q7u9h0.iot.us-east-1.amazonaws.com";
    private AWSIotData awsIotClient;

    public  AWSIOTService() {
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(ENDPOINT, REGION);

        this.awsIotClient = AWSIotDataClient.builder()
                .withEndpointConfiguration(endpointConfiguration)
                .build();
    }

    public void publishMessage(String message) {
        PublishRequest req = new PublishRequest();
        req.setTopic(TOPIC);
        req.setQos(0);
        req.setPayload(ByteBuffer.wrap(message.getBytes()));

        awsIotClient.publish(req);
    }

}
