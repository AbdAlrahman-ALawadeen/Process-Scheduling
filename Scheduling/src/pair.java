@SuppressWarnings("ALL")
public class pair {
    int time;
    Parameters parameters;
    public pair(int time, Parameters parameters) {
        this.time = time;
        this.parameters = parameters;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
}
