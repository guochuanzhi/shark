/*
 * Copyright 2015-2101 gaoxianglong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sharksharding.core.shard;

/**
 * 解析分库规则后计算数据源索引
 * 
 * @author gaoxianglong
 * 
 * @version 1.3.5
 */
public class DbRule extends RuleImpl {
	private ShardConfigInfo sharkConfigInfo;

	public DbRule() {
		sharkConfigInfo = ShardConfigInfo.getShardInfo();
	}

	@Override
	public int getIndex(long routeValue, String ruleArray) {
		int dbIndex = -1;
		/* 只有多库多表模式下需要计算数据源索引 */
		if (sharkConfigInfo.getShardMode())
			dbIndex = super.getDbIndex(routeValue, ruleArray);
		return dbIndex;
	}
}