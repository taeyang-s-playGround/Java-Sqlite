package JavaProject.Sqlite.global.security.jwt;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class JwtProperties {
    public static final String header = "Authorization";
    public static final String prefix = "Bearer";
    public static final String secretKey = "dfhasjkdfhayffhdtyhdfkjfvfddkvnvssdvnknkknlnkdkmnlvknllnkknlvfdhydshghjkdfaskverafter";
    public static final long accessExp = 10000L;

    public String getHeader() {
        return header;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public Long getAccessExp() {
        return accessExp;
    }

}
