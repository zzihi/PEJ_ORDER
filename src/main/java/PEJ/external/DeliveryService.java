
package PEJ.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="Delivery", url="${api.url.delivery}")
public interface DeliveryService {

//    @RequestMapping(method= RequestMethod.DELETE, path="/deliveries/{ordId}")
//    public void cancelDelivery(@PathVariable("ordId") Long ordId);
//    @RequestMapping(method = RequestMethod.PUT, value = "/deliveries/cancelDelivery/{ordId}", consumes = "application/json")
//    void cancelDelivery(@PathVariable("ordId") Long ordId);
    @RequestMapping(method = RequestMethod.POST, path="/cancellations")
    void cancelDelivery(@RequestBody Delivery delivery);
}