package com.liveasy.loads.storage;
import javax.persistence.*;

@Entity
public class LoadEntity
{
    public String loadingPoint;
    public String unloadingPoint;
    public String productType;
    public String truckType;
    public int noOfTrucks;
    public float weight;
    public String comment;
    public String shipperId;
    public String Date;

    @Id
    @GeneratedValue
    public Long loadId;

}