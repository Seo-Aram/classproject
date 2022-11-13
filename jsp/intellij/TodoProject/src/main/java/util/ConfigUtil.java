package util;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * config.json load 클래스.
 */
@Log4j2
public class ConfigUtil {
    private Map<String, Object> config;
    private static ConfigUtil instance;

    private ConfigUtil() {
        config = new HashMap<>();

        JSONParser parser = new JSONParser();

        try {
            FileInputStream file = null;
            BufferedReader br = null;
            ClassLoader loader = ConfigUtil.class.getClassLoader();
            @Cleanup FileReader fr = new FileReader(loader.getResource("config.json").getFile());

            Object obj = parser.parse(fr);
            JSONObject jsonConfig = (JSONObject) obj;

            Set<String> keys = jsonConfig.keySet();
            for(String key : keys) {
                this.config.put(key, jsonConfig.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConfigUtil getInstance() {
        if(instance == null) {
            instance = new ConfigUtil();
        }
        return instance;
    }

    public Object getConfig(String key) {
        return config.get(key);
    }
}
