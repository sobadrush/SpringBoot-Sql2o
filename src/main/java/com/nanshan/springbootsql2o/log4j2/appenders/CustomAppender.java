package com.nanshan.springbootsql2o.log4j2.appenders;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.util.SortedArrayStringMap;

import java.io.Serializable;
import java.util.Base64;

/**
 * @author RogerLo
 * @date 2025/2/5
 *
 * 自定義 Log4j2 Appender
 * 將訊息 Base64 編碼後輸出
 */
@Plugin(name = "RogerCustomerAppender", category = "Core", elementType = Appender.ELEMENT_TYPE)
public class CustomAppender extends AbstractAppender {

    public CustomAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions, Property[] properties) {
        super(name, filter, layout, ignoreExceptions, properties);
    }

    @Override
    public void append(LogEvent event) {
        String message = event.getMessage().getFormattedMessage();
        String encodedMessage = Base64.getEncoder().encodeToString(message.getBytes());

        LogEvent newEvent = Log4jLogEvent.newBuilder()
            .setMessage(new SimpleMessage(encodedMessage))
            .setLoggerName(event.getLoggerName())
            .setLevel(event.getLevel())
            .setContextData(new SortedArrayStringMap(event.getContextData()))
            .setThreadName(event.getThreadName())
            .setTimeMillis(event.getTimeMillis())
            .setSource(event.getSource())
            .build();

        String serializedMessage = getLayout().toSerializable(newEvent).toString();
        System.out.println(serializedMessage); // 將 base64 編碼後的訊息輸出到 console
    }

    @PluginFactory
    public static CustomAppender createAppender(@PluginAttribute("name") String name,
                                                @PluginAttribute("layout") String layoutPattern) {
        if (name == null) {
            throw new IllegalArgumentException("No name provided for CustomAppender");
        }

        if (layoutPattern == null || layoutPattern.isBlank()) {
            return new CustomAppender(name, null, PatternLayout.createDefaultLayout(), true, Property.EMPTY_ARRAY);
        }

        return new CustomAppender(name, null, PatternLayout.newBuilder().withPattern(layoutPattern).build(), true, Property.EMPTY_ARRAY);
    }
}
