package main.java.com.example.logging_middleware;


@Service
public class LoggingMiddleware{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${logging.url}")
    private String loggingUrl;
    @Value("${logging.token}")
    private String bearerToken;

    public void log(String stack, String level, String packageName, String message){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(bearerToken);
        LogRequest logRequest = new LogRequest(stack, level, packageName, message);
        HttpEntity<LogRequest> request = new HttpEntity<>(logRequest, headers);
        try{
            restTemplate.exchange(loggingUrl, HttpMethod.POST, request, String.class);
        }
        catch(Exception e){
            System.out.println("Error while sending log: " + e.getMessage());
        }
    }


}