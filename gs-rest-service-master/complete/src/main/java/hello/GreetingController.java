package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	System.out.println("*****In greeting service*****");
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public ResponseEntity<?> target(@RequestBody Greeting req) {
    	System.out.println(req.getContent());
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/genericService", method=RequestMethod.POST)
    public ResponseEntity<?> genericEndPoint(@RequestBody RequestWrapper req) {
    	System.out.println(req.getHeader());
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping("/priceless/specials/v1/offers")
    public Offer offer(@RequestParam(value="coordinates", defaultValue="101") String coordinates, 
    		@RequestHeader("Authorization") String strAuthType) {
    	System.out.println("*****In priceless service*****");
    	System.out.println("coordinates: "+coordinates);
    	System.out.println("strAuthType:"+strAuthType);
    	counter.incrementAndGet();
        return new Offer(counter.get(),
                            "Offer-"+counter.get());
    }
    
    @RequestMapping(value="/mpqr", method=RequestMethod.POST)
    public String payment(@RequestBody QrDetails qr) {
    	System.out.println("*****In mpqr service*****"+qr.getQrName());
        return "Got payment with Offer-"+counter.get();
    }
}
