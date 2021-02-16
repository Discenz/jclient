package dev.nova.jclient.setting;

public class SliderSetting extends Setting<Double> {

    private Double min, max;

    public SliderSetting (Object parent, String name, Double value, Double min, Double max) {
        super(parent, name, value);
        this.min = min;
        this.max = max;
        this.type = "Slider";
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }
}
