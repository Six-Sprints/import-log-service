package com.sixsprints.importlog.config;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sixsprints.core.config.ParentBeans;
import com.sixsprints.core.utils.DateUtil;

@Configuration
public class Beans extends ParentBeans {

  @Bean
  @ConditionalOnMissingBean
  public DateUtil dateUtil() {
    return DateUtil.instance().timeZone(defaultTimeZone())
      .datePattern(defaultDateFormat()).shortDatePattern(defaultShortDateFormat()).build();
  }

  @Bean
  @ConditionalOnMissingBean
  public ObjectMapper mapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.setTimeZone(defaultTimeZone().toTimeZone());
    SimpleModule module = module();
    mapper.registerModule(module);
    return mapper;
  }

  @Bean
  @ConditionalOnMissingBean
  public Validator validator() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    return validator;
  }

}
