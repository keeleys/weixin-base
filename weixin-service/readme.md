## fastweixin集成小demo

### 小提示
* 只需要`APPID`，`TOKEN`，和`EncodingAESKey`,不需要`AppSecret`.
* 消息加解密方式不能选明文，否则也会出错
* `initMessageHandles` 如果用它，继承`WeixinControllerSupport`的controller不要实现任何消息处理方法，因为它是一个补充选择，只有之前的方法返回null,才会执行handles里面的处理

### 消息处理源代码
父类方法  每个都手动写了handleDefaultMsg

```java 
protected BaseMsg handleTextMsg(TextReqMsg msg) {
        return this.handleDefaultMsg(msg);
    }

    protected BaseMsg handleImageMsg(ImageReqMsg msg) {
        return this.handleDefaultMsg(msg);
    }

    protected BaseMsg handleVoiceMsg(VoiceReqMsg msg) {
        return this.handleDefaultMsg(msg);
    }

    protected BaseMsg handleVideoMsg(VideoReqMsg msg) {
        return this.handleDefaultMsg(msg);
    }

    protected BaseMsg hadnleShortVideoMsg(VideoReqMsg msg) {
        return this.handleDefaultMsg(msg);
    }

    protected BaseMsg handleLocationMsg(LocationReqMsg msg) {
        return this.handleDefaultMsg(msg);
    }
```

消息判断的，每个都人工加上了空判断。

```java

} else if(msgType.equals("text")) {
            result = (String)reqMap.get("Content");
            LOG.debug("文本消息内容:{}", result);
            TextReqMsg e1 = new TextReqMsg(result);
            this.buildBasicReqMsg(reqMap, e1);
            msg = this.handleTextMsg(e1);
            if(BeanUtil.isNull(msg)) {
                msg = this.processMessageHandle(e1);
            }
        } else if(msgType.equals("image")) {
            result = (String)reqMap.get("PicUrl");
            e = (String)reqMap.get("MediaId");
            ImageReqMsg url1 = new ImageReqMsg(result, e);
            this.buildBasicReqMsg(reqMap, url1);
            msg = this.handleImageMsg(url1);
            if(BeanUtil.isNull(msg)) {
                msg = this.processMessageHandle(url1);
            }
```

processMessageHandle

```java
private BaseMsg processMessageHandle(BaseReqMsg msg) {
        if(CollectionUtil.isEmpty(messageHandles)) {
            Object i$ = LOCK;
            synchronized(LOCK) {
                messageHandles = this.initMessageHandles();
            }
        }

        if(CollectionUtil.isNotEmpty(messageHandles)) {
            Iterator i$1 = messageHandles.iterator();

            while(i$1.hasNext()) {
                MessageHandle messageHandle = (MessageHandle)i$1.next();
                BaseMsg resultMsg = null;

                boolean result;
                try {
                    result = messageHandle.beforeHandle(msg);
                } catch (Exception var7) {
                    result = false;
                }

                if(result) {
                    resultMsg = messageHandle.handle(msg);
                }

                if(BeanUtil.nonNull(resultMsg)) {
                    return resultMsg;
                }
            }
        }

        return null;
    }
```

### 总结
fastweixin代码有待，靠循环寻找handler，还用异常当判断，加的新功能很牵强，不建议用this.initMessageHandles处理了。
还有功能上好像只有消息处理。
