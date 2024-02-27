package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient { /* implements InitializingBean, DisposableBean {  // InitializingBean : 빈 초기화, DisposableBean : 빈 종료 */

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

//    @Override
    public void init(){ /* afterPropertiesSet() throws Exception { */
//        System.out.println("NetworkClient.afterPropertiesSet");
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    //    @Override
    public void close() { /* destroy() throws Exception { */
//        System.out.println("NetworkClient.destroy");
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
