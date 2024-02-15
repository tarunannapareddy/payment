package payment;
import com.example.transaction.ProcessTransactionRequest;
import com.example.transaction.ProcessTransactionResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaymentEndPoint {

    private static final String NAMESPACE_URI = "http://example.com/transaction";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "processTransactionRequest")
    @ResponsePayload
    public ProcessTransactionResponse processPayment(@RequestPayload ProcessTransactionRequest request) {
        ProcessTransactionResponse response = new ProcessTransactionResponse();
        if(request.getTransaction().getPrice() >0){
            response.setStatus("SUCCESS");
        } else{
            response.setStatus("FAIL");
        }
        return response;
    }
}
