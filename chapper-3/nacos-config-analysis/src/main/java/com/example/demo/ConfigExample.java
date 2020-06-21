package com.example.demo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author ay
 * @since 2020-06-17
 */
public class ConfigExample {

	public static void main(String[] args) throws NacosException, InterruptedException, IOException {
		//服务地址
		String serverAddr = "localhost";
		String dataId = "nacos-config";
		String group = "DEFAULT_GROUP";
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
		ConfigService configService = NacosFactory.createConfigService(properties);
		String content = configService.getConfig(dataId, group, 5000);
		System.out.println(content);
		//监听器
		configService.addListener(dataId, group, new Listener() {
			@Override
			public void receiveConfigInfo(String configInfo) {
				System.out.println("recieve:" + configInfo);
			}
			@Override
			public Executor getExecutor() {
				return null;
			}
		});
		//推送配置到nacos
		boolean isPublishOk = configService.publishConfig(dataId, group, "content");
		System.out.println(isPublishOk);
		Thread.sleep(3000);
		//从nacos中获取数据
		content = configService.getConfig(dataId, group, 5000);
		System.out.println(content);
		//删除配置
		boolean isRemoveOk = configService.removeConfig(dataId, group);
		System.out.println(isRemoveOk);
		Thread.sleep(3000);
		//获取配置，检查配置是否仍存在
		content = configService.getConfig(dataId, group, 5000);
		System.out.println(content);
		Thread.sleep(300000);
	}
}