package cn.yjhroot.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * 具体中介者类
 *
 * @author YuJianHui
 * @date 2022/08/23
 */
public class ConcreteMediator implements Mediator {
    private final Map<String, Colleague> colleagueMap = new HashMap<>();

    @Override
    public void register(Colleague colleague) {
        // 如果没注册过 则注册
        if (!colleagueMap.containsKey(colleague.getId())) {
            colleagueMap.put(colleague.getId(), colleague);
        }
    }

    @Override
    public void transmit(Colleague fromColleague, String targetId) {
        for (Map.Entry<String, Colleague> entry : colleagueMap.entrySet()) {
            // 如果目标同事已经注册 则调用其接收方法
            if (entry.getKey().equals(targetId)) {
                System.out.println("我是中介，收到来自" + fromColleague.getId() + "的信息，现在转发给id为:" + targetId + "的客户");
                entry.getValue().receive(fromColleague.getId());
            }
        }
    }
}
