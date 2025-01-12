package github.runoob09.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhang-jiahao
 * @date 2025/1/12
 * @time 11:35
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "security.aes")
public class AESConfig {
    private String key;
}
