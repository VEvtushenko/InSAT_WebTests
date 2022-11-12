package cloud.autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties"
})
public interface ProjectConfig extends Config {

    @DefaultValue("chrome")
    String browser();
    @DefaultValue("106.0")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    @DefaultValue("Владимир")
    String firstName();

    @DefaultValue("Евтушенко")
    String lastName();

    @DefaultValue("Алексеевич")
    String secondName();

    @DefaultValue("Обучение")
    String searchText();

    String webUrl();
    String userPassword();
    String userName();
    String testEmail();
    String testPhone();
    String browserMobileView();
    String remoteDriverUrl();
    String videoStorage();
}
