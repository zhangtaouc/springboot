package zhangtaouc.springboot2.Response;

import org.springframework.stereotype.Component;

@Component
public class Result<T> {
    private String retCode;
    private T retData;
    private int state;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public T getRetData() {
        return retData;
    }

    public void setRetData(T retData) {
        this.retData = retData;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Result{" +
                "retCode='" + retCode + '\'' +
                ", retData=" + retData +
                ", state=" + state +
                '}';
    }
}
