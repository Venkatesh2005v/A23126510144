package main.java.com.example.logging_middleware;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogRequest {
    private String stack;
    private String level;
    private String packageName;
    private String message;
}
