package com.caxs.minos.utils;


/**
 * @author coffee
 * @created 2020-08-19 16:32
 * @desc apollo读取配置信息的工具类
 **/
public class ApolloConfigUtils {

  /*  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ApolloConfigUtils.class);

    private Config config;
    private Config paramConfig;
    private ConfigChangeListener changeListener;
    private static final String DEFAULT_VALUE = "undefined";

    *//**
     * 配置文件namespace(默认的一个param.properties)
     *//*
    private static final String PARAM_PRO="param";


    *//**
     * 初始化config并启动监听程序，默认读取application和param两个namespace
     *//*
    public ApolloConfigUtils(){
        changeListener = changeEvent -> {
            logger.info("Changes for namespace "+changeEvent.getNamespace());
            for (String key : changeEvent.changedKeys()) {
                ConfigChange change = changeEvent.getChange(key);
                logger.info("Change - key: "+change.getNamespace()+", oldValue: "+change.getOldValue()+"" +
                        ", newValue: "+change.getNewValue()+", changeType: "+change.getChangeType()+"");
            }
        };
        config = ConfigService.getAppConfig();
        config.addChangeListener(changeListener);
        paramConfig = ConfigService.getConfig(PARAM_PRO);
        paramConfig.addChangeListener(changeListener);

    }

    *//**
     * 获取项目内部私有配置参数的方法，允许使用扩展nameSpace
     * @param key key
     * @param nameSpace 扩展namespace
     * @return value
     *//*
    private String getProperty(String key, String nameSpace){

        String value = config.getProperty(key,DEFAULT_VALUE);
        if(DEFAULT_VALUE.equals(value)){
            value = paramConfig.getProperty(key,DEFAULT_VALUE);
            if(DEFAULT_VALUE.equals(value)){
                Config paramOurConfig = ConfigService.getConfig(nameSpace);
                paramOurConfig.addChangeListener(changeListener);
                value = paramOurConfig.getProperty(key,DEFAULT_VALUE);
            }
        }
        return value;
    }

    *//**
     * 获取项目内部私有配置参数的方法，默认的application和param
     * @param key key
     * @return value
     *//*
    private String getProperty(String key){

        String value = config.getProperty(key,DEFAULT_VALUE);
        if(DEFAULT_VALUE.equals(value)){
            value = paramConfig.getProperty(key,DEFAULT_VALUE);
        }
        if(!DEFAULT_VALUE.equals(value)){
            logger.info("配置字段读取(默认配置)："+key+" = "+value);
        }

        return value;
    }


    *//**
     * <h3>读取配置参数 _ 遍历所有命名空间进行读取<h3/>
     * <p>默认读取的命名空间：application 和 param<p/>
     * <p>读取原则：先配置先读取，
     * 如果在先前配置文件中配置了该参数，就会直接读出来，如果没有则会去遍历下一个namespace。
     * 后续配置文件里面的重复参数（重复配置的 key）不会覆盖先前配置文件里面已经存在的。
     * </p>
     * <label>注意：新增的命名空间默认不会加载，需要在外部添加配置文件：apollo_namespaces.properties，
     * 写入配置参数（命名空间名称以逗号分隔，且无需重启服务，配置发布完成后立即生效）。
     * <p>例，apollo.namespaces=your_ns01,your_ns02,your_ns03<p/>
     * <label/>
     * @param key key
     * @return value
     *//*
    public String getConfigStr(String key){

        String result = null;
        try{
            String apolloNameSpaces = ReadProperties.readPropertiesFromfiles("/apollo_namespaces.properties", "apollo.namespaces", "CONF_HOME");
            String[] nameSpaces = null;
            if(apolloNameSpaces!=null){
                nameSpaces = apolloNameSpaces.split(",");
                result = getProperty(key);
                if(DEFAULT_VALUE.equals(result)){
                    for (String nameSpace:nameSpaces) {
                        result = getProperty(key,nameSpace);
                        if(!DEFAULT_VALUE.equals(result)){
                            logger.info("调取的 namespace = "+nameSpace +", 配置字段读取: "+key+" = "+result);
                            break;
                        }
                    }
                }
            } else {
                result = getProperty(key);
                if(DEFAULT_VALUE.equals(result)){
                    logger.info("配置字段读取(默认配置)："+key+" = "+result);
                }
            }
        } catch(Exception e) {
            result = getProperty(key);
            if(DEFAULT_VALUE.equals(result)){
                logger.info("配置字段读取(默认配置)："+key+" = "+result);
            }
        }

        return result;
    }

    *//**
     * 读取指定命名空间文件里面的参数
     * @param key key
     * @param nameSpace 指定的命名空间
     * @return value
     *//*
    public String getSomeConfigStr(String key,String nameSpace){
        logger.info("指定的 namespace = "+nameSpace);
        Config paramOurConfig = ConfigService.getConfig(nameSpace);
        paramOurConfig.addChangeListener(changeListener);
        String result = paramOurConfig.getProperty(key,DEFAULT_VALUE);
        logger.info("配置字段读取："+key+" = "+result);
        return result;
    }

    public static void main(String[] args) throws IOException {

        ApolloConfigUtils apolloDemo = new ApolloConfigUtils();

        while (true) {
            System.out.print("> ");
            String input = new BufferedReader(new InputStreamReader(System.in, Charsets.UTF_8)).readLine();
            if (input == null || input.length() == 0) {
                continue;
            }
            input = input.trim();
            if (input.equalsIgnoreCase("quit")) {
                System.exit(0);
            }
            apolloDemo.getConfigStr(input);
        }


    }
*/
}

