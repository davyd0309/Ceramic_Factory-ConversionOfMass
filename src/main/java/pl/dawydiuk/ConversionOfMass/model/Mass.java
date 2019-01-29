package pl.dawydiuk.ConversionOfMass.model;

import lombok.Builder;

/**
 * Created by Judith on 22.12.2018.
 */
@Builder
public class Mass {

    private Integer id;
    private double weight;
    private Clay clay;
    private Quartz quartz;
    private Kaolinite kaolinite;


    public Mass() {
    }


    public Mass(Integer id, double weight, Clay clay, Quartz quartz, Kaolinite kaolinite) {
        this.id = id;
        this.weight = weight;
        this.clay = clay;
        this.quartz = quartz;
        this.kaolinite = kaolinite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Clay getClay() {
        return clay;
    }

    public void setClay(Clay clay) {
        this.clay = clay;
    }

    public Quartz getQuartz() {
        return quartz;
    }

    public void setQuartz(Quartz quartz) {
        this.quartz = quartz;
    }

    public Kaolinite getKaolinite() {
        return kaolinite;
    }

    public void setKaolinite(Kaolinite kaolinite) {
        this.kaolinite = kaolinite;
    }
}
