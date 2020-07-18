import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;

/**
 * @author liyan
 * @date 2020/7/12 下午10:15
 */

public class GenerateCode {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();

        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/liteshop-db/src/main/java");
        gc.setAuthor("ohayou");
        gc.setOpen(false);
        gc.setServiceName("%sService");
        gc.setFileOverride(true);
        gc.setBaseResultMap(true);
//        gc.setDateType(DateType.TIME_PACK);
        gc.setBaseColumnList(true);
        autoGenerator.setGlobalConfig(gc);

        //数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/lite_shop");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("");
        dataSourceConfig.setDbType(DbType.MYSQL);
//        dataSourceConfig.setTypeConvert(new MySqlTypeConvert() {
//            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType){
//                if (fieldType.toLowerCase().contains("datetime") || fieldType.toLowerCase().contains("date")) {
//                    return DbColumnType.DATE;
//                }
//                return super.processTypeConvert(globalConfig,fieldType);
//            }
//        });
        autoGenerator.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.ohayou.liteshop");
//        packageConfig.setEntity("model");
        packageConfig.setMapper("dao");
        packageConfig.setService("service");
        packageConfig.setXml("mapper");
        autoGenerator.setPackageInfo(packageConfig);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategyConfig.setInclude("litemall_user");
//        strategyConfig.setTablePrefix("mem_");

        TableFill addTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<TableFill>();
        tableFills.add(addTime);
        tableFills.add(updateTime);
        strategyConfig.setTableFillList(tableFills);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());


        autoGenerator.execute();
    }

}
