package com.example.adeilsonassis.processoseletivo.Events;

import com.example.adeilsonassis.processoseletivo.Model.Shot;
import com.example.adeilsonassis.processoseletivo.Model.ShotCatalog;

import java.util.List;

/**
 * Created by adeilson.assis on 21/09/2017.
 */

public class ShotEvent
{
    private final List<Shot> shots;

    public ShotEvent(List<Shot> shots)
    {
        this.shots = shots;
    }

    public List<Shot> getShots()
    {
        return shots;
    }

}
